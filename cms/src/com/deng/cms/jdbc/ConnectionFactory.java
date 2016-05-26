package com.deng.cms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	
	static{
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/news";
		name="root";
		password="root";
	}
	public static Connection getConn(){
		Connection conn=null;
		try{
			//注册驱动
			Class.forName(driver);
			conn=DriverManager.getConnection(url,name,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs
			,PreparedStatement pstmt,Connection conn) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}

package com.deng.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deng.cms.bean.Category;
import com.deng.cms.jdbc.ConnectionFactory;

public class CategoryDao {

	/**
	 * 保存栏目
	 * */
	public void save(Category category){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="insert into t_category(name,code) values(?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2, category.getCode());
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有栏目
	 * */
	public List<Category> findAll(){
		List<Category> list=new ArrayList<Category>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_category";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String name=rs.getString("name");
					Integer code=rs.getInt("code");
					Category category=new Category(name,code);
					category.setId(id);
					list.add(category);
				}
			}finally{
				ConnectionFactory.close(rs, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 通过id查询栏目信息
	 * */
	public Category findById(Long id){
		Category category=new Category();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_category where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String name=rs.getString("name");
					Integer code=rs.getInt("code");
					category.setId(id);
					category.setName(name);
					category.setCode(code);
				}
			}finally{
				ConnectionFactory.close(rs, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return category;
	} 
	
	/**
	 * 更新栏目
	 * */
	public void update(Category category){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="update t_category set name=?,code=? where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2, category.getCode());
				pstmt.setLong(3, category.getId());
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id删除栏目
	 * */
	public void deleteById(Long id){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="delete from t_category where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

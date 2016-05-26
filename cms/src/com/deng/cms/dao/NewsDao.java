package com.deng.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deng.cms.bean.News;
import com.deng.cms.jdbc.ConnectionFactory;

public class NewsDao {

	/**
	 * 保存新闻信息
	 * */
	public void save(News news){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="insert into t_news(title,author,content"
						+ ",publishDate,clickTimes,c_id) values(?,?,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, news.getTitle());
				pstmt.setString(2, news.getAuthor());
				pstmt.setString(3, news.getContent());
				pstmt.setDate(4, new Date(news.getPublishDate().getTime()));
				pstmt.setInt(5, news.getClickTimes());
				pstmt.setLong(6, news.getC_id());
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 遍历新闻信息
	 * */
	public List<News> findAll(){
		List<News> list=new ArrayList<News>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_news order by t_news.publishDate DESC,t_news.id DESC";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String title=rs.getString("title");
					String author=rs.getString("author");
					String content=rs.getString("content");
					Date publishDate=rs.getDate("publishDate");
					Integer clickTimes=rs.getInt("clickTimes");
					Long c_id=rs.getLong("c_id");
					News news=new News();
					news.setId(id);
					news.setTitle(title);
					news.setAuthor(author);
					news.setContent(content);
					news.setPublishDate(publishDate);
					news.setClickTimes(clickTimes);
					news.setC_id(c_id);
					list.add(news);
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
	 * 通过id查询新闻信息
	 * */
	public News findById(Long id){
		News news=new News();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_news where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String title=rs.getString("title");
					String author=rs.getString("author");
					String content=rs.getString("content");
					Date publishDate=rs.getDate("publishDate");
					Integer clickTimes=rs.getInt("clickTimes");
					Long c_id=rs.getLong("c_id");
					news.setId(id);
					news.setTitle(title);
					news.setAuthor(author);
					news.setContent(content);
					news.setPublishDate(publishDate);
					news.setClickTimes(clickTimes);
					news.setC_id(c_id);
				}
			}finally{
				ConnectionFactory.close(rs, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return news;
	}
	
	/**
	 * 通过栏目id查询新闻信息
	 * */
	public List<News> findByCid(Long c_id){
		List<News> list=new ArrayList<News>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_news where c_id=? order by t_news.publishDate DESC,t_news.id DESC";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, c_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String title=rs.getString("title");
					String author=rs.getString("author");
					String content=rs.getString("content");
					Date publishDate=rs.getDate("publishDate");
					Integer clickTimes=rs.getInt("clickTimes");
					News news=new News();
					news.setId(id);
					news.setTitle(title);
					news.setAuthor(author);
					news.setContent(content);
					news.setPublishDate(publishDate);
					news.setClickTimes(clickTimes);
					news.setC_id(c_id);
					list.add(news);
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
	 * 更新新闻信息
	 * */
	public void update(News news){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="update t_News set title=?,author=?,c_id=?,"
						+ "content=?,publishDate=? where id=? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, news.getTitle());
				pstmt.setString(2, news.getAuthor());
				pstmt.setLong(3, news.getC_id());
				pstmt.setString(4, news.getContent());
				pstmt.setDate(5, new Date(news.getPublishDate().getTime()));
				pstmt.setLong(6, news.getId());
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id删除新闻信息
	 * */
	public void deleteById(Long id){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				conn=ConnectionFactory.getConn();
				String sql="delete from t_news where id=?";
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

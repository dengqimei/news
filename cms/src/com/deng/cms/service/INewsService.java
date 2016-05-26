package com.deng.cms.service;

import java.util.List;

import com.deng.cms.bean.News;
import com.deng.cms.model.CategoryModel;

public interface INewsService {

	//添加新闻信息
	void add(News news);
	
	//查询所有新闻信息
	List<News> findAll();
	
	//通过id查询新闻信息
	News findById(Long id);
	
	//通过栏目id查询新闻信息
	List<News> findByCid(Long c_id);
	
	//修改新闻信息
	void update(News news);
	
	//通过id删除新闻信息
	void deleteById(Long id);
	
	//查询所有
	List<CategoryModel> listAll();
}

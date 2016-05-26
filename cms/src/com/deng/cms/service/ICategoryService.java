package com.deng.cms.service;

import java.util.List;

import com.deng.cms.bean.Category;

public interface ICategoryService {

	//添加栏目
	void add(Category category);
	
	//查询所有栏目
	List<Category> list();
	
	//修改栏目
	void update(Category category);
	
	//通过id删除栏目
	void deleteById(Long id);
	
	//通过id查询栏目信息
	Category findById(Long id);
}

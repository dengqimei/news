package com.deng.cms.service.impl;

import java.util.List;

import com.deng.cms.bean.Category;
import com.deng.cms.dao.CategoryDao;
import com.deng.cms.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	private CategoryDao categoryDao=new CategoryDao();
	
	//添加栏目
	@Override
	public void add(Category category) {
		categoryDao.save(category);
	}

	//查询所有栏目
	@Override
	public List<Category> list() {
		return categoryDao.findAll();
	}

	//修改栏目
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	//通过id删除栏目
	@Override
	public void deleteById(Long id) {
		categoryDao.deleteById(id);
	}

	//通过id查询栏目信息
	@Override
	public Category findById(Long id) {
		return categoryDao.findById(id);
	}

}

package com.deng.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deng.cms.bean.Category;
import com.deng.cms.bean.News;
import com.deng.cms.dao.CategoryDao;
import com.deng.cms.dao.NewsDao;
import com.deng.cms.model.CategoryModel;
import com.deng.cms.service.INewsService;

public class NewsServiceImpl implements INewsService {

	private NewsDao newsDao= new NewsDao();
	private CategoryDao categoryDao=new CategoryDao();
	
	@Override
	public void add(News news) {
		newsDao.save(news);
	}

	@Override
	public List<News> findAll() {
		return newsDao.findAll();
	}

	@Override
	public News findById(Long id) {
		return newsDao.findById(id);
	}

	@Override
	public void update(News news) {
		newsDao.update(news);
	}

	@Override
	public void deleteById(Long id) {
		newsDao.deleteById(id);
	}

	@Override
	public List<News> findByCid(Long c_id) {
		return newsDao.findByCid(c_id);
	}

	@Override
	public List<CategoryModel> listAll() {
		List<CategoryModel> list=new ArrayList<CategoryModel>();
		List<Category> categoryList=categoryDao.findAll();
		for(Category c:categoryList){
			CategoryModel model=new CategoryModel();
			model.setCategory(c);
			List<News> newsList=newsDao.findByCid(c.getId());
			model.setNews(newsList);
			list.add(model);
		}
		return list;
	}

}

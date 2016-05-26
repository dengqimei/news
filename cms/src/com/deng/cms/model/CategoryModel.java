package com.deng.cms.model;

import java.util.List;

import com.deng.cms.bean.Category;
import com.deng.cms.bean.News;

public class CategoryModel {

	private Category category;
	private List<News> news;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
}

package com.deng.cms.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.deng.cms.bean.Category;
import com.deng.cms.bean.News;
import com.deng.cms.model.CategoryModel;
import com.deng.cms.service.ICategoryService;
import com.deng.cms.service.INewsService;
import com.deng.cms.service.impl.CategoryServiceImpl;
import com.deng.cms.service.impl.NewsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Category> categoryList;
	private List<News> newsList;
	private List<CategoryModel> cmList;
	private Category category;
	private News news;
	
	private Long id;
	private Long c_id;
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	private INewsService newsService=new NewsServiceImpl();

	/**
	 * 跳转到前台首页
	 * */
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
		categoryList=categoryService.list();
		cmList=newsService.listAll();
		return SUCCESS;
	}
	
	/**
	 * 跳转到列表页
	 * */
	@Action(value="toList",results={
			@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		categoryList=categoryService.list();
		newsList=newsService.findByCid(c_id);
		category=categoryService.findById(c_id);
		return SUCCESS;
	}
	
	/**
	 * 跳转到详细页
	 * */
	@Action(value="toContent",results={
			@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		categoryList=categoryService.list();
		news=newsService.findById(id);
		category=categoryService.findById(news.getC_id());
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<CategoryModel> getCmList() {
		return cmList;
	}

	public void setCmList(List<CategoryModel> cmList) {
		this.cmList = cmList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
}

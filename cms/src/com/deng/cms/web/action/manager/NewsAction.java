package com.deng.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.deng.cms.bean.Category;
import com.deng.cms.bean.News;
import com.deng.cms.service.ICategoryService;
import com.deng.cms.service.INewsService;
import com.deng.cms.service.impl.CategoryServiceImpl;
import com.deng.cms.service.impl.NewsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	private INewsService newsService=new NewsServiceImpl();
	
	private List<Category> categoryList;
	private List<News> newsList;
	private News news;
	private Category category;
	
	private Long id;
	private String title;
	private String author;
	private String content;
	private Long c_id;

	/**
	 * 跳转到添加新闻页面
	 * */
	@Action(value="toAddNews",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addNews.jsp")})
	public String toAddNews(){
		categoryList=categoryService.list();
		return SUCCESS;
	}
	
	//添加新闻
	@Action(value="addNews")
	public void addNews(){
		News news=new News();
		news.setTitle(title);
		news.setAuthor(author);
		news.setContent(content);
		news.setC_id(c_id);
		news.setPublishDate(new Date());
		news.setClickTimes(0);
		newsService.add(news);
	}
	
	//跳转到新闻管理页面
	@Action(value="toNewsManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/newsManager.jsp")})
	public String toNewsManager(){
		newsList=newsService.findAll();
		return SUCCESS;
	}
	
	//跳转到修改新闻页面
	@Action(value="toUpdNews",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updNews.jsp")})
	public String toUpdNews(){
		categoryList=categoryService.list();
		news=newsService.findById(id);
		category=categoryService.findById(news.getC_id());
		return SUCCESS;
	}
	
	//修改新闻
	@Action(value="updNews")
	public void updNews(){
		News news=new News();
		news.setId(id);
		news.setTitle(title);
		news.setAuthor(author);
		news.setContent(content);
		news.setC_id(c_id);
		news.setPublishDate(new Date());
		news.setClickTimes(0);
		newsService.update(news);
	}
	
	//删除新闻
	@Action(value="delNews")
	public void delNews(){
		newsService.deleteById(id);
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

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	
}

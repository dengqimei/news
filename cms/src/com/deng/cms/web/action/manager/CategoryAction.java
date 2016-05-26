package com.deng.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.deng.cms.bean.Category;
import com.deng.cms.service.ICategoryService;
import com.deng.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer code;
	
	private List<Category> categoryList;
	private Category category;
	
	private ICategoryService categoryService=new CategoryServiceImpl();

	/**
	 * 跳转到添加栏目页面
	 * */
	@Action(value="toAddCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")})
	public String toAddCategory(){
		return SUCCESS;
	}
	
	@Action(value="addCategory")
	public void addCategory(){
		Category category=new Category(name,code); 
		categoryService.add(category);
	}
	
	/**
	 * 跳转到栏目管理页面
	 * */
	@Action(value="toCategoryManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")})
	public String toCategoryManager(){
		categoryList=categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改栏目页面
	 * */
	@Action(value="toUpdCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updCategory.jsp")})
	public String toUpdCategory(){
		category=categoryService.findById(id);
		return SUCCESS;
	}
	
	//修改栏目信息
	@Action(value="updCategory")
	public void updCategory(){
		Category category =new Category();
		category.setId(id);
		category.setName(name);
		category.setCode(code);
		categoryService.update(category);
	}
	
	//删除栏目信息
		@Action(value="delCategory")
		public void delCategory(){
			categoryService.deleteById(id);
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}

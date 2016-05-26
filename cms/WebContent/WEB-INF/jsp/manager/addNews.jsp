<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function(){
		var form = $("#addNewsForm");
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				form[0].reset();
				alert("添加成功！");
			});
			return false;
		});
	});
</script>
<style>
    table tr{
        height:30px;
    }
</style>
<form action="addNews.action" method="post" id="addNewsForm">
	<table style="border-collapse: collapse; width: 100%;">
		<caption style="font-size:24px;font-weight: bold;">发布新闻</caption>
		<tr>
			<td width="70px">文章标题：</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>文章作者：</td>
			<td><input type="text" name="author"></td>
		</tr>
		<tr>
			<td>所属栏目：</td>
			<td><select name="c_id">
					<option value="">---请选中---</option>
					<c:forEach items="${categoryList }" var="category">
						<option value="${category.id }">${category.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>文章内容：</td>
			<td><textarea rows="5" cols="60" name="content"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="发布"></td>
		</tr>
	</table>
</form>
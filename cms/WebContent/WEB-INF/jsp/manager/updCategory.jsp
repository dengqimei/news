<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
$(function(){
	var form=$("#updCategoryForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset;
			alert("添加成功！");
			$(".baseUI li :contains('栏目管理')").trigger("click");
		});
		return false;
	});	
});

</script>
<center>
<div>
	<form action="updCategory.action" method="post" id="updCategoryForm">
	<input type="hidden" name="id" value="${category.id }">
	<table style="border-collapse: collapse; width: 100%;">
	    <caption style="font-size:24px;font-weight: bold;">修改栏目</caption>
		<tr height="30px"><td width="70px">栏目名称:</td><td><input type="text" name="name" value="${category.name }" /></td></tr> 
		<tr height="30px"><td width="70px">栏目编号:</td><td><input type="text"name="code" value="${category.code }"/></td></tr> 
		<tr height="30px"><td colspan="2"><input type="submit" value="修改" /></td></tr>
	</table>
	</form>
</div>
</center>
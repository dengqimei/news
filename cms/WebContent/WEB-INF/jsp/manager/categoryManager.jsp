<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        th{
            background: lightyellow;
            font-size:16px;
            font-family:微软雅黑;
        }
        td{
            font-size:14px;
            font-family:微软雅黑;
            text-align:center;
        }
    </style>
	<table border="1" style=" border-collapse:collapse; width:100%;">
	<caption style="font-size:24px;font-weight: bold;">所有栏目信息</caption>
		<tr>
			<th>编号</th>
			<th>栏目名称</th>
			<th>栏目编号</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${categoryList }" var="category" varStatus="status">
		<tr <c:if test="${status.index %2 !=0 }">style="background:lightgreen"</c:if><c:if test="${status.index %2 ==0 }">style="background:lightblue"</c:if>>
			<td><input type="checkbox" name="id" value="${category.id }"/></td>
			<td>${category.name }</td>
			<td>${category.code }</td>
			<td>
			   <a href="javascript:void(0)" val="${category.id }" class="upd">修改</a>
			   <a href="javascript:void(0)" val="${category.id }" class="del">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
<script>
$(function(){
	$(".upd").off();
	$(".upd").on("click",function(){
		var id=$(this).attr("val");
		$.post("toUpdCategory.action",{id:id},function(){
			$(".right").load("toUpdCategory.action",{id:id});
		});
	});
	
	$(".del").off();
	$(".del").on("click",function(){
		var flag = confirm("确定删除吗？");
		if(flag){
		    var id = $(this).attr("val");
		    $.post("delCategory.action",{id:id},function(){
			    $(".baseUI li :contains('栏目管理')").trigger("click");
			    alert("删除成功")
		    });
		}
	});		
});
	
</script>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yjwbaginfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
 	function tz(pagecount){
 		var page=document.getElementById("page").value;
 		if(isNaN(page)){
 			alert("请输入数字！~");
 			return false;
 		}
 		if(page<1||page>pagecount){
 			alert("输入数字范围有误！~");
 			document.getElementById("page").value="";
 			return false;
 		}else{
 			location.href="Query?page="+(page-1);
 		}
 	}
  </script>
  <body>
    欢迎您~:${user }<br><br>
    <form action="Query" method="post">
    	编号:<input type="text" name="yjwbno">
    	<input type="submit" value="查询">
    </form>
    <a href="yjwaddbag.jsp">添加</a>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    		<td>颜色</td>
    		<td>库存</td>
    		<td>单价</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${bag}" var="bg">
    		<tr>
    		<td>${bg.yjwbno }</td>
    		<td>${bg.yjwbname }</td>
    		<td>${bg.yjwbcolor }</td>
    		<td>${bg.yjwbnumber }</td>
    		<td>${bg.yjwbprice }</td>
    		<td><a href="yjwupdatebag?bno=${bg.yjwbno }">修改</a> <a href="yjwdeletebag?bno=${bg.yjwbno }">删除</a></td>
    	</tr>
    	</c:forEach>
    </table><br>
    共${pagecount }页  第${pagenow+1 }页
    <a href="Query?page=0">首页</a>
    <c:choose>
    	<c:when test="${pagenow==0}">上一页</c:when>
    	<c:otherwise><a href="Query?page=${pagenow-1 }">上一页</a></c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${pagenow==pagecount-1}">下一页</c:when>
    	<c:otherwise><a href="Query?page=${pagenow+1 }">下一页</a></c:otherwise>
    </c:choose>
    <a href="Query?page=${pagecount-1 }">尾页</a>
    跳转到<input id="page" type="text" size="4">页
    <input type="button" value="GO" onclick="tz(${pagecount })" /><br/><br/>
    
    <a href="yjwexcel">导出信息</a>
    <form action="yjwexcel" method="post" enctype="multipart/form-data">
    	<input type="file" name="file"/>
    	<input type="submit" value="导入"/>
    </form>
  </body>
</html>

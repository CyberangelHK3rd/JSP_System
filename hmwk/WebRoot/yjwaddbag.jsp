<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yjwaddbag.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="addbaginfo" method="post">
    	编号:<input type="text" name="yjwbno"><br><br>
    	名称:<input type="text" name="yjwbname"><br><br>
    	颜色:<input type="text" name="yjwbcolor"><br><br>
    	库存:<input type="text" name="yjwbnumber"><br><br>
    	单价:<input type="text" name="yjwbprice"><br><br>
    	<input type="submit" value="增加"><a href="yjwbaginfo.jsp">返回</a>
    </form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Brand</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath }/jsp/index.jsp">首页</a></li>
      <li><a href="#">家长入口</a></li>
      <li><a href="#">教员入口</a></li>
      <li><a href="#">在线客服</a></li>
      <li><a href="#">致学招聘</a></li>
      <li><a href="#">反馈建议</a></li>
      <li><a href="${pageContext.request.contextPath }/jsp/aboutUs.jsp">关于我们</a></li>
    </ul>
    <!-- <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form> -->
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${ empty existUser}">
      <li><a href="${pageContext.request.contextPath }/wisdom">登录</a></li>
      <li><a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a></li>
      </c:if>
      <c:if test="${not empty existUser}">
      		<li><a><font style="color:red">你好,&nbsp;&nbsp;${existUser.name}</font></a></li>
      		<li><a href="${pageContext.request.contextPath }/user_logout">退出</a></li>
      </c:if>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>
</body>
</html>
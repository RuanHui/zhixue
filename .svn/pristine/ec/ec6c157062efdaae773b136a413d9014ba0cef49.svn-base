<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>用户登录</title>
<style type="text/css">
	/*div{
		border:1px solid red;
	}*/
</style>

<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container" style="height:500px">
   		<!--导航栏-->
        <%@ include file="menu.jsp" %>
        
       <div class="container" style="margin-top:15%;">
       		<div class="col-md-7 hidden-xs hidden-sm" <%-- style="background-image: url('${ pageContext.request.contextPath }/image/timg.jpg'); "--%>>
       			<br><br><br><br><br>
       			<font color="gray" size="6px">${wisdom }</font><br>
       			<font color="gray" size="6px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----${name }</font>
       		</div>
       		<div class="col-md-1 hidden-xs hidden-sm"></div>
       		<div class="col-md-4 col-xs-12 col-sm-12" style="background-color: white;border: 5px solid gray;">  
       			 <!--登录-->
		        <div class="col-md-12" margin="5%">
		        	<div><font color="red">&nbsp;${msg }</font></div>
		        	<form action="${pageContext.request.contextPath }/user_login" method="post" class="form-horizontal" role="form">
					  <div class="form-group">
					    <label for="inputEmail3">用户名</label>
					      <input type="text" class="form-control" value="${cookie.username.value }" id="username" name="username" placeholder="username">
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3">密码:</label>
					      <input type="password" class="form-control" id="password" name="password" placeholder="password">
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <div class="checkbox">
					          <input type="checkbox" name="autoLogin" value="true"> 自动登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					          <input type="checkbox" name="remember" value="true"> 记住用户名
					      </div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default" style="width:180px;">登录</button>
					    </div>
					  </div>
					</form>
		        </div>
       		</div>
       </div>
        <!--底栏-->
        <div class="col-md-12" style="height:200px">
        	<%@ include file="footer.jsp" %>
        </div>
    </div>
</body>
</html>

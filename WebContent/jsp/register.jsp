<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#repassword").blur(function(){
			var $reVal = $(this).val();
			var $val = $("#password").val();
			if($reVal != $val){
				$("#reg").prop("disabled","true");
				$("#sp1").html("两次密码不一致");
			}else if($reVal == $val) {
				$("#reg").prop("disabled","");
				$("#sp1").html("");
			}
		});
	});
</script>
<!-- 校验密码格式 -->
<script type="text/javascript">
		function check(){
			var password = document.getElementById("password").value;
			var match = /^[a-zA-Z]\w{5,15}$/ ;
			var s1 = document.getElementById("s1");
			var reg = document.getElementById("reg");
			if(match.test(password)) {
				s1.innerHTML = "<font style='color:green'>密码格式正确</font>";
				reg.disabled = "";
			}else{
				s1.innerHTML = "<font style='color:red'>密码格式有误</font>";
				reg.disabled = "true";
			}			
		}
</script>
</head>
<body>
	<div class="container" style="height:500px">
   		<!--导航栏-->
        	<%@ include file="menu.jsp" %>
        <!--登录-->
        <div class="col-md-12">
        	<font color="red">${msg }</font>
        	<form action="${pageContext.request.contextPath }/user_register" method="post" class="form-horizontal" role="form">
			  <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名 &nbsp;<font style="color:red;font-size:15px">*</font></label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" onblur="check()" name="password" id="password" placeholder="请输入以字母开头的6到16位密码">
			    </div>
			    <span id="s1"></span>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="repassword" id="repassword" placeholder="请输入确认密码">
			    </div>
			      <font style="color:red;font-size:15px"><span id="sp1"></span></font>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" name="email" id="inputEmail3" placeholder="Email">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="name" id="name" placeholder="请输入姓名">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">年龄</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="age" id="age" placeholder="请输入年龄">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="男" checked> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" name="birthday" class="form-control"  >		      
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" name="telephone" class="form-control"  >		      
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" id="reg" class="btn btn-default">注册</button>
			    </div>
			  </div>
			</form>
        </div>
        <!--底栏-->
        <div class="col-md-12" style="height:200px">
        	<%@ include file="footer.jsp" %>
        </div>
    </div>
</body>
</html>
    
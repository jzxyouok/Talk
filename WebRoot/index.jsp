<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>老外趣聊</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<style type="text/css">
.d1{
	border:0;
	background-image:url('images/a.bmp');
	height:22px;
	font-size:20;
	text-align:center;
	font-style:italic;
	letter-spacing:12px;
	width:115px;
}
.d2{
	border:0;
	background-color:'#ffffff';
	color:red;
	font-size:12;

}
.yzm-img{
	border:0;
	background-image:url('images/a.bmp');
	height:22px;
	font-size:20;
	text-align:center;
	font-style:italic;
	letter-spacing:12px;
	width:100px;
}



</style>
<script language="javascript">

			function check(form){
			 
				if (form.name.value==""){
					alert("请输入用户名!");form.name.focus();return false;
				} 
				if (form.pass.value==""){
					alert("请输入密码!");form.pass.focus();return false;
				} 
				if (form.yanzheng.value=="") {
					alert("请输入验证码");form.yanzheng.focus();return false;
				} 
				if (form.yanzheng.value.toUpperCase() != document.getElementById("checkCode").value.toUpperCase()) {
					alert("验证码输入错误！");
					form.yanzheng.focus();
					createCode();
					return false;
				}else {
					alert("|" + inputCode + "|" + checkCode.value);
					document.forms['form1'].submit();
					return true;
				}
			}
			function doAjax(){
				
               var gname=document.getElementById("username").value;
                
              
                var url="<%=request.getContextPath() %>/manage/manager.do?method=queryAjax";
            

                
            	$.post(url,{manager_name:username},function (data){
            		
            		tianxie(data);//调用填写这个函数，其目的就是在后面给予人性化的提示
            			
       		});	

			}

			
			//填写
			function tianxie(flag){
				
			if("no"==flag){
			$("#tishi").html("<font  color='red'>代号不使用</font>");
			}else{
			$("#tishi").html("<font  color='green'>代号可用</font>");
			}
			
			}
			
			//重写填写
			function retianxie(){
			document.getElementById("username").value="";
			$("#tishi").html("");
			}
			function Zhuce(){
				window.location.href="sigin/ZhucePage.jsp";
			}
			function createCode() {
				code = new Array();
				var codeLength = 4;
				//验证码的长度
				var checkCode = document.getElementById("checkCode");
				checkCode.value = "";
				var selectChar = new Array('a','b','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
						'u','v','w','x','y','z',1,2,3,4,5,6,7,8,9,0,'A','B','C','D','E','F','G','H',
						'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
				for ( var i = 0; i < codeLength; i++) {
					var charIndex = Math.floor(Math.random() * 32);
					code += selectChar[charIndex];
				}
				if (code.length != codeLength) {
					createCode();
				}
				checkCode.value = code;
			}
</script>

</head>

<body onload="createCode()">


<div class="header">
  <h1 class="headerLogo"><a title="老外趣聊" target="_blank" ><img alt="logo" src="image/logo.bmp"></a></h1>
	<div class="headerNav">
		<a target="_blank" href="https://github.com/">趣聊官网</a>
		<a target="_blank" href="https://github.com/">关于趣聊</a>
		<a target="_blank" href="https://github.com/">开发团队</a>
		<a target="_blank" href="https://github.com/" >意见反馈</a>
		<a target="_blank" href="https://github.com/" >帮助</a>	
	</div>
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform" id="fom" name="managerForm"  action="<%=request.getContextPath() %>/login/LogInServlet" method="post" focus="name" onsubmit="return check(managerForm)" style="margin: 0px">
   <div class="fm-item">
	   <label for="logonId" class="form-label">用户名：</label>
	   <input type="text" value="" maxlength="100" id="username" name="name" class="i-text" onblur="doAjax()"   onfocus=" retianxie()"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">密&nbsp;码：</label>
	   <input type="password" value="" maxlength="100" id="password"  name="pass" class="i-text" >    
       <div class="ui-form-explain"></div>
  </div>
  
  
  
  <div class="fm-item pos-r">
	   <label for="logonId" class="form-label">验证码</label>
	   <input type="text" value="" maxlength="100" id="yzm" name="yanzheng" class="i-text yzm" nullmsg="请输入验证码！" />    
       <div class="ui-form-explain"><input type="button" id="checkCode" class="yzm-img" style="width: 110px; height: 40px" onClick="createCode()"/></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
	   <input type="button" value="" tabindex="4" id="zhuce-btn" class="btn-zhuce" onclick="Zhuce()">    
	 

 
       <div class="ui-form-explain"></div>
  </div>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(themes/theme-pic1.bmp) #CCE1F3 center 0 no-repeat;"><a target="_blank" ></a></li>
			<li style="background:url(themes/theme-pic2.bmp) #BCE0FF center 0 no-repeat;"><a target="_blank" ></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
   <p>Copyright &copy; 2015.梁文硕 All rights reserved.</p>
</div>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/error.css">
<title>错误页面</title>
</head>
<body>
	<div id="success">
		<div id="message">
			<span class="a">注册成功,自动转跳</span>
		</div>
		<div>
		<span>距离跳转还剩<span id="DaoJiShi">3</span>秒</span>
		</div>
		<a href="index">-如果转跳失败请点击这里</a>
		<!-- 返回上一页 -->
		<div id="upPage">
			<a href="javascript:history.go(-1)">返回上一页</a>
		</div>
	</div>
</body>	
 <script>
		 var n=3;
 		setInterval("aaa()",1000)
 		var a = document.getElementById('DaoJiShi');
 		function aaa()
        {
 	 		if(n>0){
 	 			a.innerText=n-1;
 	 		}
        }
 	
        setInterval("myInterval()",3000);//1000为1秒钟
        function myInterval()
        {
            window.location.href='index';
        }
    </script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <title>注册 - Eazychina</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/login.css" media="all">
</head>
<body>
  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>Eazychina</h2>
        <p>注册</p>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        
 		<form action="<%=request.getContextPath()%>/register">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
          <input type="text" name="username" id="LAY-user-login-username" lay-verify="username" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-email" for="LAY-user-login-email"></label>
          <input type="text" name="email" id="LAY-user-login-email" lay-verify="email" placeholder="邮箱" class="layui-input">
        </div>
        <div class="layui-form-item">
          <div class="layui-row">
            <div class="layui-col-xs7">
              <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
              <input type="text" id="LAY-user-login-vercode" lay-verify="required" placeholder="验证码" class="layui-input">
            </div>
            <div class="layui-col-xs5">
              <div style="margin-left: 10px;">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="LAY-user-getsmscode">获取验证码</button>
              </div>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="密码" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
          <input type="password" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
          <input type="text" name="nickname" id="LAY-user-login-nickname" lay-verify="nickname" placeholder="昵称" class="layui-input">
        </div>
        <div class="layui-form-item">
          <button type="submit" value="Submit" id="btn"  class="layui-btn layui-btn-fluid" >注 册</button>
        </div>
       </form> 
        <div class="layui-trans layui-form-item layadmin-user-login-other">
          
          <a href="login.html" class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
          <a href="login.html" class="layadmin-user-jump-change layadmin-link layui-hide-sm layui-show-xs-inline-block">登入</a>
        </div>
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>© EazyCina <a href="http://www.eazychina.store/" target="_blank">EazyCina.com</a></p>
    </div>

  </div>

  <script src="<%=request.getContextPath()%>/resources/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '<%=request.getContextPath()%>/resources/layuiadmin/' //静态资源所在路径

  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user'], function(){
    var $ = layui.$
    ,setter = layui.setter
    ,admin = layui.admin
    ,form = layui.form
    ,router = layui.router();

    form.render();

    //提交
    form.on('submit(LAY-user-reg-submit)', function(obj){
      var field = obj.field;
      
      //确认密码
      if(field.password !== field.repass){
        return layer.msg('两次密码输入不一致');
      }
      
      
      return false;
    });
  });
  </script>
</body>
</html>
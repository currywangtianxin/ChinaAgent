<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>忘记密码 - layuiAdmin</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/login.css" media="all"></head>
<style>
        #btn {
            display:none;
        }
</style>

<body>
 <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>layuiAdmin</h2>
        <p>layui 官方出品的单页面后台管理模板系统</p>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
      
        <script type="text/html" template>
          {{# if(layui.router().search.type === 'resetpass'){ }}
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
              <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="新密码" class="layui-input">
            </div>
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
              <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
            </div>
            <div class="layui-form-item">
              <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-forget-resetpass">重置新密码</button>
            </div>
          {{# } else { }}
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-cellphone" for="LAY-user-login-cellphone"></label>
              <input type="text" name="cellphone" id="LAY-user-login-cellphone" lay-verify="phone" placeholder="请输入注册时的手机号" class="layui-input">
            </div>
            <div class="layui-form-item">
              <div class="layui-row">
                <div class="layui-col-xs7">
                  <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                  <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                </div>
                <div class="layui-col-xs5">
                  <div style="margin-left: 10px;">
     	   			<a class="checkcode" href=""><img class="layadmin-user-login-codeimg" id="LAY-user-get-vercode" src="codeBuilder"></a>

                  </div>
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <div class="layui-row">
                <div class="layui-col-xs7">
                  <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-smscode"></label>
                  <input type="text" name="vercode" id="LAY-user-login-smscode" lay-verify="required" placeholder="短信验证码" class="layui-input">
                </div>
                <div class="layui-col-xs5">
                  <div style="margin-left: 10px;">
                    <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="LAY-user-getsmscode">获取验证码</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <button id="btn" class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-forget-submit">找回密码</button>
            </div>
          {{# } }}
        </script>
   
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>© 2018 <a href="http://www.layui.com/" target="_blank">layui.com</a></p>
      
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

    //找回密码下一步
    form.on('submit(LAY-user-forget-submit)', function(obj){
      var field = obj.field;

      //请求接口
      admin.req({
        url: layui.setter.base + 'json/user/forget.js' //实际使用请改成服务端真实接口
        ,data: field
        ,done: function(res){        
          location.hash = '/type=resetpass';
          location.reload();
        }
      });
      
      return false;
    });
    
    //重置密码
    form.on('submit(LAY-user-forget-resetpass)', function(obj){
      var field = obj.field;
      
      //确认密码
      if(field.password !== field.repass){
        return layer.msg('两次密码输入不一致');
      }

      //请求接口
      admin.req({
        url: layui.setter.base + 'json/user/resetpass.js' //实际使用请改成服务端真实接口
        ,data: field
        ,done: function(res){        
          layer.msg('密码已成功重置', {
            offset: '15px'
            ,icon: 1
            ,time: 1000
          }, function(){
            location.href = 'login.html'; //跳转到登入页
          });
        }
      });
      
      return false;
    });
    $("#LAY-user-login-vercode").bind('input',function(){
    	//当输入的验证码值发生改变时触发事件
    	console.log("坚挺到正在输入验证码");
    	console.log($("#LAY-user-login-vercode").val());
    	var a=$("#LAY-user-login-vercode").val();
    	var truefalse=0;
    	$.ajax({
    		url:"checkajax",
    		type:"get",
    		ansync:false,
    		data:{"code":a,"truefalse":0},
    		dataType:"html",
    		success:function(Data){
    			 console.log("响应成功");
    			 
    			 
    			 console.log(Data);
    			 //var data=Data;
    			 //for(var key in data){
    				// console.log(1); }
    		
    			truefalse=Data;
    			 //console.log(data.truefalse);
    			console.log(truefalse);
    			//如果验证码正确,就显示注册按钮
    			if(truefalse==1){
    				$("#btn").css('display', 'block');
    			}else{
    				$("#btn").css('display', 'none');
    			}
    		}
    	});
    	console.log("监测truefalse的值为:"+truefalse);
    })
    
  });
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta charset="utf-8">
        <title>登入 - Eazychina.store后台管理系统</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/layui/css/layui.css" media="all">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/admin.css" media="all">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layuiadmin/style/login.css" media="all">

        <style>
            #btn {
                display: none;
            }
        </style>
    </head>

    <body>

        <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

            <div class="layadmin-user-login-main">
                <div class="layadmin-user-login-box layadmin-user-login-header">
                    <h2>EazyChina</h2>
                    <p>EazyChina 天信出品的单页面后台管理模板系统</p>
                </div>
                <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                   	<form action="<%=request.getContextPath()%>/user/userlogin">
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                        <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                        <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-row">
                            <div class="layui-col-xs7">
                                <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                                <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                            </div>
                            <div class="layui-col-xs5">
                                <div style="margin-left: 10px;">
                                    <!--<a class="checkcode" href=""><img id="sfhanhan" alt="" src="codeBuilder"></a> -->
                                    <a class="checkcode" href=""><img class="layadmin-user-login-codeimg" id="LAY-user-get-vercode" src="codeBuilder"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item" style="margin-bottom: 20px;">
                        <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                        <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
                    </div>
                    <div class="layui-form-item">
                        <button type="submit" value="Submit" id="btn" class="layui-btn layui-btn-fluid">登 入</button>
                    </div>
                    </form>
                    <div class="layui-trans layui-form-item layadmin-user-login-other">

                        <a href="reg.html" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
                    </div>
                </div>
            </div>

            <div class="layui-trans layadmin-user-login-footer">

                <p>© EazyCina <a href="http://www.eazychina.store/" target="_blank">EazyCina.com</a></p>
            </div>

            <!--<div class="ladmin-user-login-theme">
      <script type="text/html" template>
        <ul>
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
      </script>
    </div>-->

        </div>

        <script src="<%=request.getContextPath()%>/resources/layuiadmin/layui/layui.js"></script>
        <script>
            layui.config({
                base: '<%=request.getContextPath()%>/resources/layuiadmin/' //静态资源所在路径
            }).extend({
                index: 'lib/index' //主入口模块
            }).use(['index', 'user'], function() {
                var $ = layui.$,
                    setter = layui.setter,
                    admin = layui.admin,
                    form = layui.form,
                    router = layui.router(),
                    search = router.search;

                form.render();


                $("#LAY-user-login-vercode")

                $("#LAY-user-login-vercode").bind('input', function() {
                    //当输入的验证码值发生改变时触发事件
                    console.log("坚挺到正在输入验证码");
                    console.log($("#LAY-user-login-vercode").val());
                    var a = $("#LAY-user-login-vercode").val();
                    var truefalse = 0;
                    $.ajax({
                        url: "checkajax",
                        type: "get",
                        ansync: false,
                        data: {
                            "code": a,
                            "truefalse": 0
                        },
                        dataType: "html",
                        success: function(Data) {
                            console.log("响应成功");


                            console.log(Data);
                            //var data=Data;
                            //for(var key in data){
                            // console.log(1); }

                            truefalse = Data;
                            //console.log(data.truefalse);
                            console.log(truefalse);
                            //如果验证码正确,就显示注册按钮
                            if (truefalse == 1) {
                                $("#LAY-user-login-vercode").attr("name", "");
                                $("#btn").css('display', 'block');


                            } else {
                                $("#btn").css('display', 'none');
                            }
                        }
                    });
                    console.log("监测truefalse的值为:" + truefalse);
                })
            });
        </script>
    </body>

    </html>
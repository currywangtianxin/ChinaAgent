/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-10-21 06:10:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("    <html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>登入 - Eazychina.store后台管理系统</title>\r\n");
      out.write("        <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/layuiadmin/layui/css/layui.css\" media=\"all\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/layuiadmin/style/admin.css\" media=\"all\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/layuiadmin/style/login.css\" media=\"all\">\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            #btn {\r\n");
      out.write("                display: none;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"layadmin-user-login layadmin-user-display-show\" id=\"LAY-user-login\" style=\"display: none;\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"layadmin-user-login-main\">\r\n");
      out.write("                <div class=\"layadmin-user-login-box layadmin-user-login-header\">\r\n");
      out.write("                    <h2>EazyChina</h2>\r\n");
      out.write("                    <p>EazyChina 天信出品的单页面后台管理模板系统</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layadmin-user-login-box layadmin-user-login-body layui-form\">\r\n");
      out.write("                   \t<form action=\"");
      out.print(request.getContextPath());
      out.write("/user/userlogin\">\r\n");
      out.write("                    <div class=\"layui-form-item\">\r\n");
      out.write("                        <label class=\"layadmin-user-login-icon layui-icon layui-icon-username\" for=\"LAY-user-login-username\"></label>\r\n");
      out.write("                        <input type=\"text\" name=\"username\" id=\"LAY-user-login-username\" lay-verify=\"required\" placeholder=\"用户名\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\">\r\n");
      out.write("                        <label class=\"layadmin-user-login-icon layui-icon layui-icon-password\" for=\"LAY-user-login-password\"></label>\r\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"LAY-user-login-password\" lay-verify=\"required\" placeholder=\"密码\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\">\r\n");
      out.write("                        <div class=\"layui-row\">\r\n");
      out.write("                            <div class=\"layui-col-xs7\">\r\n");
      out.write("                                <label class=\"layadmin-user-login-icon layui-icon layui-icon-vercode\" for=\"LAY-user-login-vercode\"></label>\r\n");
      out.write("                                <input type=\"text\" name=\"vercode\" id=\"LAY-user-login-vercode\" lay-verify=\"required\" placeholder=\"图形验证码\" class=\"layui-input\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"layui-col-xs5\">\r\n");
      out.write("                                <div style=\"margin-left: 10px;\">\r\n");
      out.write("                                    <!--<a class=\"checkcode\" href=\"\"><img id=\"sfhanhan\" alt=\"\" src=\"codeBuilder\"></a> -->\r\n");
      out.write("                                    <a class=\"checkcode\" href=\"\"><img class=\"layadmin-user-login-codeimg\" id=\"LAY-user-get-vercode\" src=\"codeBuilder\"></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\" style=\"margin-bottom: 20px;\">\r\n");
      out.write("                        <input type=\"checkbox\" name=\"remember\" lay-skin=\"primary\" title=\"记住密码\">\r\n");
      out.write("                        <a href=\"forget.html\" class=\"layadmin-user-jump-change layadmin-link\" style=\"margin-top: 7px;\">忘记密码？</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\">\r\n");
      out.write("                        <button type=\"submit\" value=\"Submit\" id=\"btn\" class=\"layui-btn layui-btn-fluid\">登 入</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <div class=\"layui-trans layui-form-item layadmin-user-login-other\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"reg.html\" class=\"layadmin-user-jump-change layadmin-link\">注册帐号</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"layui-trans layadmin-user-login-footer\">\r\n");
      out.write("\r\n");
      out.write("                <p>© EazyCina <a href=\"http://www.eazychina.store/\" target=\"_blank\">EazyCina.com</a></p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!--<div class=\"ladmin-user-login-theme\">\r\n");
      out.write("      <script type=\"text/html\" template>\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li data-theme=\"\"><img src=\"{{ layui.setter.base }}style/res/bg-none.jpg\"></li>\r\n");
      out.write("          <li data-theme=\"#03152A\" style=\"background-color: #03152A;\"></li>\r\n");
      out.write("          <li data-theme=\"#2E241B\" style=\"background-color: #2E241B;\"></li>\r\n");
      out.write("          <li data-theme=\"#50314F\" style=\"background-color: #50314F;\"></li>\r\n");
      out.write("          <li data-theme=\"#344058\" style=\"background-color: #344058;\"></li>\r\n");
      out.write("          <li data-theme=\"#20222A\" style=\"background-color: #20222A;\"></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </script>\r\n");
      out.write("    </div>-->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/layuiadmin/layui/layui.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            layui.config({\r\n");
      out.write("                base: '");
      out.print(request.getContextPath());
      out.write("/resources/layuiadmin/' //静态资源所在路径\r\n");
      out.write("            }).extend({\r\n");
      out.write("                index: 'lib/index' //主入口模块\r\n");
      out.write("            }).use(['index', 'user'], function() {\r\n");
      out.write("                var $ = layui.$,\r\n");
      out.write("                    setter = layui.setter,\r\n");
      out.write("                    admin = layui.admin,\r\n");
      out.write("                    form = layui.form,\r\n");
      out.write("                    router = layui.router(),\r\n");
      out.write("                    search = router.search;\r\n");
      out.write("\r\n");
      out.write("                form.render();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                $(\"#LAY-user-login-vercode\")\r\n");
      out.write("\r\n");
      out.write("                $(\"#LAY-user-login-vercode\").bind('input', function() {\r\n");
      out.write("                    //当输入的验证码值发生改变时触发事件\r\n");
      out.write("                    console.log(\"坚挺到正在输入验证码\");\r\n");
      out.write("                    console.log($(\"#LAY-user-login-vercode\").val());\r\n");
      out.write("                    var a = $(\"#LAY-user-login-vercode\").val();\r\n");
      out.write("                    var truefalse = 0;\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url: \"checkajax\",\r\n");
      out.write("                        type: \"get\",\r\n");
      out.write("                        ansync: false,\r\n");
      out.write("                        data: {\r\n");
      out.write("                            \"code\": a,\r\n");
      out.write("                            \"truefalse\": 0\r\n");
      out.write("                        },\r\n");
      out.write("                        dataType: \"html\",\r\n");
      out.write("                        success: function(Data) {\r\n");
      out.write("                            console.log(\"响应成功\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            console.log(Data);\r\n");
      out.write("                            //var data=Data;\r\n");
      out.write("                            //for(var key in data){\r\n");
      out.write("                            // console.log(1); }\r\n");
      out.write("\r\n");
      out.write("                            truefalse = Data;\r\n");
      out.write("                            //console.log(data.truefalse);\r\n");
      out.write("                            console.log(truefalse);\r\n");
      out.write("                            //如果验证码正确,就显示注册按钮\r\n");
      out.write("                            if (truefalse == 1) {\r\n");
      out.write("                                $(\"#LAY-user-login-vercode\").attr(\"name\", \"\");\r\n");
      out.write("                                $(\"#btn\").css('display', 'block');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            } else {\r\n");
      out.write("                                $(\"#btn\").css('display', 'none');\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                    console.log(\"监测truefalse的值为:\" + truefalse);\r\n");
      out.write("                })\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("    </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

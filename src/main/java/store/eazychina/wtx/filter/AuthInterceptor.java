package store.eazychina.wtx.filter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import store.eazychina.wtx.*; 
import store.eazychina.wtx.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		String methodName = handlerMethod.getMethod().getName();
		
		if (!methodName.equals("register")&&!methodName.equals("forget")&&!methodName.equals("userlogin") && !methodName.equals("login")&& !methodName.equals("reg")) {
			System.out.println("被拦截");
			HttpSession session = request.getSession(true);
			User loginUser = (User) session.getAttribute("loginUser");
			if (loginUser == null) {
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}
		}
		if (methodName.equals("index")) {
			System.out.println("被拦截");

			HttpSession session = request.getSession(true);
			User loginUser = (User) session.getAttribute("loginUser");
			if (loginUser == null) {
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}
		}
		System.out.println("放行");
		return super.preHandle(request, response, handler);
	}
}

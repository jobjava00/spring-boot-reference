package com.github.jobjava00.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * main Application 에서 ServletComponentScan 해주면 @Component 사용 안해도 됨
 * @author jobjava00
 */
@WebFilter(urlPatterns = "/user")
public class MyFilter implements Filter {
	@Override public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init");
	}

	@Override public void destroy() {
		System.out.println("Filter destroy");
	}

	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Filter doFilter");
		filterChain.doFilter(servletRequest, servletResponse);
	}
}

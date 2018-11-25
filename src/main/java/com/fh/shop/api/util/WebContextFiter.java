package com.fh.shop.api.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class WebContextFiter
 */
public class WebContextFiter implements Filter {

    /**
     * Default constructor. 
     */
    public WebContextFiter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("==============绑定doFilter");
		WebContext.setRequset((HttpServletRequest) request);
		try {
			 System.out.println("========开始doFilter");
			chain.doFilter(request, response);
			System.out.println("========结束doFilter");
		}finally{
			WebContext.remove();
			System.out.println("========销毁doFilter");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.seanjohn.nhl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.DispatcherType;

/**
 * Servlet Filter implementation class Authenticate
 */
@WebFilter(
		urlPatterns = "/*",
		filterName = "Authenticate",
		description = "Require that each session provide the database password"
)
public class Authenticate implements Filter {

    private FilterConfig filterConfig;

	/**
     * Default constructor.
     */
    public Authenticate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
        filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		((HttpServletResponse)response).setHeader("X-Authentication-Filter", this.getClass().getName());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		filterConfig = fConfig;
	}

}

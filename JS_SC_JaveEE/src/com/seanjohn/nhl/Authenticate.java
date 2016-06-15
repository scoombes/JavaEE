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
import javax.servlet.http.HttpSession;
import javax.servlet.DispatcherType;

/**
 * Servlet Filter implementation class Authenticate
 */
@WebFilter(
		urlPatterns = "/*",
		dispatcherTypes = DispatcherType.REQUEST,
		filterName = "Authenticate",
		description = "Require that each session provide the database password"
)
public class Authenticate implements Filter {

    private FilterConfig filterConfig;
    private String[] staticFiles = {".map", ".css", ".js"};

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
        HttpServletRequest httpReqiest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpReqiest.getSession();
		String uri = httpReqiest.getRequestURI();
		httpResponse.setHeader("X-Authentication-Filter", this.getClass().getName());
		filterConfig.getServletContext().log(uri);


		// Check if it's a file we are happy with
		for (String suffix : staticFiles) {
			if (uri.endsWith(suffix)) {
				chain.doFilter(request, response);
				return; // Don't continue for static files
			}
		}

		String paramUsername = httpReqiest.getParameter("username");
		String paramPassword = httpReqiest.getParameter("password");

		if (paramUsername != null && paramPassword != null) {
			session.setAttribute("plaintextSQLUser", paramUsername);
			session.setAttribute("plaintextSQLPass", paramPassword);
			String originalUri = (String) session.getAttribute("redirectUri");
			session.removeAttribute(originalUri);
			httpResponse.sendRedirect(originalUri);
			return;
		}

		// Check if they have a user/pass. Bad credentials will be used then deleted
		boolean hasUser = session.getAttribute("plaintextSQLUser") != null;
		boolean hasPass = session.getAttribute("plaintextSQLPass") != null;

		// skip filter when user has credentials in their session
		if (hasUser && hasPass) {
			chain.doFilter(request, response);
			return;
		}

		// User hasn't authenticated and this is not a static file
        // Lets save the requested URL
        session.setAttribute("redirectUri", uri);
        // Then send them to the auth page
        httpResponse.setStatus(401); // Unauthorised
        filterConfig.getServletContext().getRequestDispatcher("/auth.jsp").forward(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		filterConfig = fConfig;
	}

}

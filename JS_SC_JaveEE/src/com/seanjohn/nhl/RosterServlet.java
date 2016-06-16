/*
 *   Document   : RosterServlet.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.data.RosterIO;

/**
 * Servlet implementation class RosterServlet
 */
@WebServlet({"/roster", "/Roster"})
public class RosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("X-Servlet-Name", getServletName());
	    response.setContentType("text/html;charset=UTF-8");
	    String teamid = request.getParameter("teamid");
	    
	    if (teamid == null) {
			// there was an error 
		}
	    else {
	    	HttpSession session = request.getSession();
		    String user = (String)session.getAttribute("plaintextSQLUser");
		    String pass = (String)session.getAttribute("plaintextSQLPass");	    
		    		    
	    	RosterIO rosterIO = new RosterIO(user, pass);
	    	ArrayList<Roster> roster;
	        String teamName = ""; 
	    	
	    	try {
				roster = rosterIO.getRoster(teamid);
				teamName = rosterIO.getTeam(teamid);
			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				roster = new ArrayList<Roster>();
			}
	    	 
	         
	         request.setAttribute("roster", roster);
	         request.setAttribute("teamName", teamName);
		}
	    
        String url = "/roster.jsp";
        ServletContext sc = getServletContext();
        
       
        
        sc.getRequestDispatcher(url).forward(request, response);
	}
}

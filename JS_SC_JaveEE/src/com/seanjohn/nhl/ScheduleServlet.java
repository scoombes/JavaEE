/*
 *   Document   : ScheduleServlet.java
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

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.data.ScheduleIO;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet({"/schedule", "/Schedule"})
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("X-Servlet-Name", getServletName());
	    HttpSession session = request.getSession();
	    String user = (String)session.getAttribute("plaintextSQLUser");
	    String pass = (String)session.getAttribute("plaintextSQLPass");
	    
	    ScheduleIO sched = new ScheduleIO(user, pass);
	    ArrayList<Game> upcomingGames;
	    try {
			upcomingGames = sched.getUpcomingGames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ServletContext context = this.getServletContext();
			context.log("getTeams", e);
			upcomingGames = new ArrayList<Game>();
		}
	    
	    request.setAttribute("upcoming", upcomingGames);
        String url = "/schedule.jsp";
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).forward(request, response);

	}
}

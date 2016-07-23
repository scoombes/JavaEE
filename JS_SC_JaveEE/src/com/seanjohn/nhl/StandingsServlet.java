/*
 *   Document   : StandingsServlet.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.Standing;
import com.seanjohn.nhl.data.TeamHIO;

/**
 * Servlet implementation class StandingsServlet
 */
@WebServlet({"/standings", "/Standings"})
public class StandingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("X-Servlet-Name", getServletName());
	    
		// gets team standings from TeamHIO
		TeamHIO teamIO = new TeamHIO();
		List<Standing> teams = teamIO.getStandings();

		// adds list of teams to be used on jsp
		request.setAttribute("teams", teams);
		String url = "/standings.jsp";
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher(url).forward(request, response);
	}
}

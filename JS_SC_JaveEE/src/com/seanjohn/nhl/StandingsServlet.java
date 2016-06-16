/*
 *   Document   : StandingsServlet.java
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

import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.TeamIO;

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

	    //gets user data from current session
	    HttpSession session = request.getSession();
	    String user = (String)session.getAttribute("plaintextSQLUser");
	    String pass = (String)session.getAttribute("plaintextSQLPass");	    
	    
	    //gets team standings from TeamIon
    	TeamIO teamIO = new TeamIO(user, pass);
    	ArrayList<Team> teams;      
    	try {
			teams = teamIO.getStandings();
		} catch (SQLException e) {
			ServletContext context = this.getServletContext();
			context.log("getRoster", e);
			teams = new ArrayList<Team>();
		}

    	//adds list of teams to be used on jsp
    	request.setAttribute("teams", teams);    
        String url = "/standings.jsp";
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).forward(request, response);

	}
}

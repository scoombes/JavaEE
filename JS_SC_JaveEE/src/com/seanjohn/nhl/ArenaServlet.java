/*
 *   Document   : TeamsServlet.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.Arena;
import com.seanjohn.nhl.data.ArenaHIO;

/**
 * Servlet implementation class TeamsServlet
 */
@WebServlet({"/arenas", "/Arenas"})
public class ArenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("X-Servlet-Name", getServletName());
	    
	    //gets lists of teams from derby database via TeamIO class
	    ArenaHIO arenaIO = new ArenaHIO();
	    List<Arena> arenas;
	    try {
			arenas = arenaIO.getArenas();
		} catch (SQLException e) {
			ServletContext context = this.getServletContext();
			context.log(getServletName(), e);
			arenas = new ArrayList<Arena>();
		}
	    
	    //adds to team to an attribute to be used in the jsp
	    request.setAttribute("arenas", arenas);
        String url = "/arenas.jsp";
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).forward(request, response);
	}
}

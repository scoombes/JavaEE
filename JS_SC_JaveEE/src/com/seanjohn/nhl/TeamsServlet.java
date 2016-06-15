package com.seanjohn.nhl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.Team;

/**
 * Servlet implementation class TeamsServlet
 */
@WebServlet({"/teams", "/Teams"})
public class TeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("X-Servlet-Name", getServletName());

	    //query db for a list of teams
	    //take list of teams and display their names and their coaches/management
	    //make team name a link on the jsp page that redirects 
	    Team[] teams = new Team[8];

	    for (int i = 0; i < teams.length; i++) {
	    	Random ran = new Random();
	    	
			Team team = new Team();
			team.setTeamid("lfs" + ran.nextInt(999 - 100 + 1) + 100);
		}
	    
        String url = "/teams.jsp";
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).forward(request, response);
	}
}

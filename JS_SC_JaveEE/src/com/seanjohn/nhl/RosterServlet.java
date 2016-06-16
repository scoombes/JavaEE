package com.seanjohn.nhl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.Player;

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
	    
	    String team = request.getParameter("team");
	    
	    if (team == null) {
			// there was an error 
		}
	    else {
	    	 Player[] roster = new Player[10];
	         
	         for (int i = 0; i < roster.length; i++) {
	         	Random ran = new Random();
	 			Player player = new Player();
	 			player.setFirstname("DudeMan");
	 			player.setLastname("ManDude");
	 			player.setPlayerid(new Long(ran.nextInt(99 - 1 + 1 )+ 1));
	 			
	 			roster[i] = player;
	 		}
	         
	         request.setAttribute("roster", roster);
		}
	    
        String url = "/roster.jsp";
        ServletContext sc = getServletContext();
        
       
        
        sc.getRequestDispatcher(url).forward(request, response);
	}
}

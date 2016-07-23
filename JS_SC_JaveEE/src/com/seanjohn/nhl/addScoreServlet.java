/*
 *   Document   : CompleteGamesServlet.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.data.GameHIO;

/**
 * Servlet implementation class CompleteGamesServlet
 */
@WebServlet({ "/addscore" })
public class addScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("X-Servlet-Name", getServletName());
		Long gameId= null;
		String teamId = request.getParameter("teamid");
		Game game = null;
		
		try {
			gameId = Long.parseLong(request.getParameter("gameid"));
		} catch (Exception e) {}
		
		
		if (gameId == null) {
			// there was an error
		} else {
			try {
				GameHIO gameIO = new GameHIO();
				game = gameIO.getGame(gameId);
				
			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
			}

		}

		request.setAttribute("game", game);
		request.setAttribute("teamId", teamId);
		String url = "/addScore.jsp";
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				long homeScore;
				long visitorScore;
				String OT = request.getParameter("OT");
				String SO = request.getParameter("SO");
				
				Long gameId = null;
				String teamId = request.getParameter("teamId");
				GameHIO gameIO;
				String url = "/upcominggames";
				
				
				try {
					homeScore = Long.parseLong(request.getParameter("homeScore"));
					visitorScore = Long.parseLong(request.getParameter("visitorScore"));
					gameId = Long.parseLong(request.getParameter("gameId"));
				} catch (Exception e) {
					homeScore = 0;
					visitorScore = 0;
				}
				
				if(gameId == null){
					//there was an error with getting the id
				}else{
					try {
						gameIO = new GameHIO();
						Game game = gameIO.getGame(gameId);
						
						game.setHomeScore(homeScore);
						game.setVisitorScore(visitorScore);
						
						if(OT == "on"){
							game.setOT('Y');	
						}else{
							game.setOT('N');
						}
						
						if(SO == "on"){
							game.setOT('Y');
							game.setSO('Y');
						}else{
							game.setSO('N');
						}
						
						gameIO.updateGame(game);

					} catch (SQLException e) {
						ServletContext context = this.getServletContext();
						context.log(getServletName(), e);
					}	
				}
				
				if(teamId != null){
					url = "teamschedule?teamid=" + teamId;
				}
				
				response.sendRedirect(url);
				// ServletContext sc = getServletContext();
				// sc.getRequestDispatcher(url).forward(request, response);
				
				
				
				
			    
			}
}

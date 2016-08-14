/*
 *   Document   : TeamGamesServlet.java
 *   Created on : July 23, 2016
 *   Edited on  : August 14, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import com.seanjohn.enterprise.GameEJB;
import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.business.TeamGame;
import com.seanjohn.nhl.data.ScheduleHIO;
import com.seanjohn.nhl.data.TeamHIO;

/**
 * Servlet implementation class CompleteGamesServlet
 */
@WebServlet({ "/teamschedule" })
public class TeamGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	GameEJB gameEJB;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("X-Servlet-Name", getServletName());
		String teamId = request.getParameter("teamid");
		String title = "";
		Team team;
		List<Game> games;
		List<TeamGame> teamGames = new ArrayList<TeamGame>();

		if (teamId == null) {
			// there was an error
		} else {

			ScheduleHIO scheduleIO = new ScheduleHIO();

			try {
				TeamHIO teamIO = new TeamHIO();
				team = teamIO.getTeam(teamId);
				title = team.getTeamName() + "'s Schedule";
				games = scheduleIO.getTeamSchedule(teamId);
			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				games = new ArrayList<Game>();
				team = new Team();
			}

			for(Game game: games){
				try {
					TeamGame teamGame = new TeamGame();
					
					teamGame.setTeamId(team.getTeamId());
					teamGame.setGameId(game.getGameId());
					teamGame.setGameDate(game.getGameDate());
					teamGame.setGameTime(game.getGameTime());
					teamGame.setVisitorTeam(game.getVisitor().getTeamName());
					teamGame.setScore(gameEJB.getScore(game, team));
					teamGame.setArena(game.getArena().getArenaName());
					
					teamGames.add(teamGame);
					gameEJB.getScore(game, team);
				} catch (NullAttributeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			request.setAttribute("games", teamGames);
			request.setAttribute("title", title);
			String url = "/teamGames.jsp";
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher(url).forward(request, response);

		}
	}
}

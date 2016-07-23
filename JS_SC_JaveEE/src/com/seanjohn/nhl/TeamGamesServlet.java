/*
 *   Document   : CompleteGamesServlet.java
 *   Created on : June 15, 2016
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
import javax.servlet.http.HttpSession;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.RosterHIO;
import com.seanjohn.nhl.data.ScheduleHIO;
import com.seanjohn.nhl.data.ScheduleIO;
import com.seanjohn.nhl.data.TeamHIO;

/**
 * Servlet implementation class CompleteGamesServlet
 */
@WebServlet({ "/teamschedule" })
public class TeamGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("X-Servlet-Name", getServletName());
		String teamId = request.getParameter("teamid");
		String title = "";
		List<Game> games;

		if (teamId == null) {
			// there was an error
		} else {

			ScheduleHIO scheduleIO = new ScheduleHIO();

			try {
				TeamHIO teamIO = new TeamHIO();
				title = teamIO.getTeam(teamId).getTeamName() + "'s Schedule";
				games = scheduleIO.getTeamSchedule(teamId);
			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				games = new ArrayList<Game>();
			}

			request.setAttribute("games", games);
			request.setAttribute("title", title);
			String url = "/games.jsp";
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher(url).forward(request, response);

		}
	}
}

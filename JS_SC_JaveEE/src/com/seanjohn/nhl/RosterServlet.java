/*
 *   Document   : RosterServlet.java
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

import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.RosterHIO;

/**
 * Servlet implementation class RosterServlet
 */
@WebServlet({ "/roster", "/Roster" })
public class RosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("X-Servlet-Name", getServletName());
		response.setContentType("text/html;charset=UTF-8");
		String teamId = request.getParameter("teamid");

		if (teamId == null) {
			// there was an error
		} else {

			RosterHIO rosterIO = new RosterHIO();
			List<Roster> roster;
			ArrayList<Roster> rosterForward = new ArrayList<Roster>();
			ArrayList<Roster> rosterDefence = new ArrayList<Roster>();
			ArrayList<Roster> rosterGoalie = new ArrayList<Roster>();

			String teamName = "";
			Staff headCoach = new Staff();
			Staff asstCoach = new Staff();
			Staff trainer = new Staff();
			Staff manager = new Staff();

			try {
				Team team = rosterIO.getTeam(teamId);
				roster = rosterIO.getRoster(teamId);
				teamName = team.getTeamname();

				headCoach = team.getHeadCoach();
				asstCoach = team.getAsstcoach();
				manager = team.getManager();
				trainer = team.getTrainer();

			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				roster = new ArrayList<Roster>();
			}

			for (Roster r : roster) {
				String position = r.getPosition();
				if (position.equals("Defence")) {
					rosterDefence.add(r);
				} else if (position.equals("Goalie")) {
					rosterGoalie.add(r);
				} else {
					rosterForward.add(r);
				}
			}

			request.setAttribute("forward", rosterForward);
			request.setAttribute("defence", rosterDefence);
			request.setAttribute("goalie", rosterGoalie);

			request.setAttribute("teamName", teamName);
			request.setAttribute("headCoach", headCoach);
			request.setAttribute("asstCoach", asstCoach);
			request.setAttribute("manager", manager);
			request.setAttribute("trainer", trainer);
		}

		String url = "/roster.jsp";
		ServletContext sc = getServletContext();

		sc.getRequestDispatcher(url).forward(request, response);
	}
}

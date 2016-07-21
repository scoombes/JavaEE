/*
 *   Document   : RosterServlet.java
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

import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.RosterHIO;
import com.seanjohn.nhl.data.RosterIO;

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
		String teamid = request.getParameter("teamid");

		if (teamid == null) {
			// there was an error
		} else {

			RosterHIO rosterIO = new RosterHIO();
			List<Roster> roster;
			ArrayList<Roster> rosterCentre = new ArrayList<Roster>();
			ArrayList<Roster> rosterRight = new ArrayList<Roster>();
			ArrayList<Roster> rosterLeft = new ArrayList<Roster>();
			ArrayList<Roster> rosterDefence = new ArrayList<Roster>();
			ArrayList<Roster> rosterGoalie = new ArrayList<Roster>();
			
			String teamName = "";
			String headCoach = "";
			String asstCoach = "";
			String trainer = "";
			String manager = "";

			try {
				roster = rosterIO.getRoster(teamid);
				Team team = roster.get(0).getTeam();

				teamName = team.getTeamname();
				
				headCoach = team.getHeadCoach().getFirstName() + " "
						+ team.getHeadCoach().getLastName();
				asstCoach = team.getAsstcoach().getFirstName() + " "
						+ team.getAsstcoach().getLastName();
				manager = team.getManager().getFirstName() + " "
						+ team.getManager().getLastName();
				trainer = team.getTrainer().getFirstName() + " "
						+ team.getTrainer().getLastName();

			} catch (SQLException e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				roster = new ArrayList<Roster>();
			}

			for (Roster r : roster) {
				String position = r.getPosition();
				if (position.equals("Defence")) {
					rosterDefence.add(r);
				} else if (position.equals("Right Wing")) {
					rosterRight.add(r);
				} else if (position.equals("Left Wing")) {
					rosterLeft.add(r);
				} else if (position.equals("Centre")) {
					rosterCentre.add(r);
				} else if (position.equals("Goalie")) {
					rosterGoalie.add(r);
				}
			}

			request.setAttribute("centre", rosterCentre);
			request.setAttribute("right", rosterRight);
			request.setAttribute("left", rosterLeft);
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

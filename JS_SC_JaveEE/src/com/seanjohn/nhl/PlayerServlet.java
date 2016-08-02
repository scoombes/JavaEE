/*
 *   Document   : PlayerServlet.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;
import java.util.ArrayList;

import javax.enterprise.inject.New;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seanjohn.nhl.business.PlayerStats;
import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.data.RosterHIO;

/**
 * Servlet implementation class RosterServlet
 */
@WebServlet({ "/player", "/Player" })
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("X-Servlet-Name", getServletName());
		response.setContentType("text/html;charset=UTF-8");
		String playerId = request.getParameter("playerid");
		long pId;
		Roster player;
		PlayerStats playerStats;

		try {
			pId = Long.parseLong(playerId);
		} catch (Exception e) {
			pId = 0;
		}

		if (pId == 0) {
			// there was an error
		} else {
			RosterHIO rosterIO = new RosterHIO();
			try {
				player = rosterIO.getPlayer(pId);
			} catch (Exception e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				player = new Roster();
			}
			
			try {
				playerStats = player.getPlayerStats().get(0);
			} catch (Exception e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				playerStats = new PlayerStats();
			}

			request.setAttribute("rosterPlayer", player);
			request.setAttribute("playerStats", playerStats);
		}

		String url = "/player.jsp";
		ServletContext sc = getServletContext();

		sc.getRequestDispatcher(url).forward(request, response);
	}
}

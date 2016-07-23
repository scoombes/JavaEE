/*
 *   Document   : RosterServlet.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		try {
			pId = Long.parseLong(playerId);
		} catch (Exception e) {
			pId = 0;
		}
		if (pId == 0) {
			// there was an error
		} else {

			try {
				RosterHIO rosterIO = new RosterHIO();
				player = rosterIO.getPlayer(pId);

			} catch (Exception e) {
				ServletContext context = this.getServletContext();
				context.log(getServletName(), e);
				player = new Roster();
			}

			request.setAttribute("rosterPlayer", player);
		}

		String url = "/player.jsp";
		ServletContext sc = getServletContext();

		sc.getRequestDispatcher(url).forward(request, response);
	}
}

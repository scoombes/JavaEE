/*
 *   Document   : ScheduleIO.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Roster;

/**
 * @author black
 *
 */
public class ScheduleHIO extends HibernateIO {
	public List<Game> getCompletedGames() throws SQLException {
		return em
				.createQuery(
						"SELECT g "
								+ "FROM Game g "
								+ "WHERE g.homeScore IS NOT null AND g.visitorScore IS NOT null "
								+ "ORDER BY g.gameDate, g.gameTime", Game.class)
				.getResultList();
	}

	public List<Game> getUpcomingGames() throws SQLException {
		return em
				.createQuery(
						"SELECT g "
								+ "FROM Game g "
								+ "WHERE g.homeScore IS null AND g.visitorScore IS null "
								+ "ORDER BY g.gameDate, g.gameTime", Game.class)
				.getResultList();
	}

	public List<Game> getTeamSchedule(String teamId) throws SQLException {
		return em
				.createQuery(
						"SELECT g "
								+ "FROM Game g "
								+ "WHERE g.home.teamId = :teamId OR g.visitor.teamId = :teamId "
								+ "ORDER BY g.gameDate, g.gameTime", Game.class)
				.setParameter("teamId", teamId).getResultList();

	}
}

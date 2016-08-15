/*
 *   Document   : ScheduleHIO.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Schedule;

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
	
	public Schedule getSchedule(String season) {
		try {
			return em.createQuery("SELECT s FROM Schedule s WHERE s.season = :season", Schedule.class).setParameter("season", season).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

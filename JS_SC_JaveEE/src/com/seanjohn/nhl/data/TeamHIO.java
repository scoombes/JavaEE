/*
 *   Document   : TeamHIO.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Standing;
import com.seanjohn.nhl.business.Team;

public class TeamHIO extends HibernateIO {

	public List<Team> getTeams() throws SQLException {
		return em.createQuery("select t from Team t", Team.class)
				.getResultList();
	}

	public Team getTeam(String teamId) {
		return em
				.createQuery(
						"SELECT t " + "FROM Team T "
								+ "WHERE t.teamId = :teamId ", Team.class)
				.setParameter("teamId", teamId).getSingleResult();
	}

	public List<Standing> getStandings() throws SQLException{
		List<Game> games = em.createQuery("select g from Game g", Game.class)
				.getResultList();
		HashMap<Team, Standing> scores = new HashMap<Team, Standing>();

		for (Game game : games) {
			if (game.getHomeScore() != null && game.getVisitorScore() != null) {
				Team home = game.getHome();
				Team visitor = game.getVisitor();

				// Set initial scores
				if (!scores.containsKey(home)) {
					scores.put(home, new Standing(home));
				}

				if (!scores.containsKey(visitor)) {
					scores.put(visitor, new Standing(visitor));
				}

				if (game.getHomeScore() > game.getVisitorScore()) {
					// Home wins
					scores.get(home).addWin();
				} else {
					// Away wins
					scores.get(visitor).addWin();
				}

				if ("Y".equalsIgnoreCase(Character.toString(game.getOT()))) {
					if (game.getHomeScore() < game.getVisitorScore()) {
						// Home lost in OT
						scores.get(home).addOvertimeLoss();
					} else {
						// Away lost in OT
						scores.get(visitor).addOvertimeLoss();
					}
				} else {
					if (game.getHomeScore() < game.getVisitorScore()) {
						// Home lost
						scores.get(home).addLoss();
					} else {
						// Away lost
						scores.get(visitor).addLoss();
					}
				}
			}
		}

		List<Standing> standings = new ArrayList<Standing>(scores.values());
		Collections.sort(standings, Collections.reverseOrder());
		return standings;
	}
}

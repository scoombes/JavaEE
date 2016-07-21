/*
 *   Document   : RosterIO.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seanjohn.nhl.business.*;

public class RosterHIO extends HibernateIO {
	public Team getTeam(String teamId) throws SQLException {
		Team team = em
				.createQuery("select t from Team t where t.teamId = :teamId",
						Team.class).setParameter("teamId", teamId)
				.getSingleResult();
		return team;
	}

	public List<Roster> getRoster(String teamId) throws SQLException {
		List<Roster> teamRoster = em
				.createQuery(
						"select r from Roster r where r.team.teamId = :teamId order by r.jersey",
						Roster.class).setParameter("teamId", teamId)
				.getResultList();
		return teamRoster;
	}
}

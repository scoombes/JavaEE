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
	
	public String getTeam(String teamId) throws SQLException{
		return "A team"; // TODO: FIXME
	}
	
	public List<Roster> getRoster(String teamId) throws SQLException {
		List<Roster> teamRoster = em.createQuery("select t from Roster t where t.team.teamId = :teamId", Roster.class)
				.setParameter("teamId", teamId).getResultList();
		
	    em.getTransaction().commit();
        return teamRoster;
    }
}

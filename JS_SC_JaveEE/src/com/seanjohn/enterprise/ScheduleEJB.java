/*
 *   Document   : ScheduleEJB.java
 *   Created on : August 14, 2016
 *   Authors    : John Steel & Sean Coombes
 */
package com.seanjohn.enterprise;

import java.text.SimpleDateFormat;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Schedule;
import com.seanjohn.nhl.business.Team;

@Stateless
@LocalBean
public class ScheduleEJB {
	EntityManager em = null;
	
    /**
     * Default constructor. 
     */
    public ScheduleEJB() {
    	EntityManagerFactory emf = null;
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("nhlLeagueContext");	
		}
		em = emf.createEntityManager();
    }
    
	public String getNextGame(Team team, Schedule schedule) {
		String pattern = "EEE d MMM yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);

		try {
			Game nextGame = em.createQuery(""
					+ "select g from Game g "
					+ "WHERE g.homeScore IS NULL AND "
					+ "    ( g.home = :team OR g.visitor = :team ) AND "
					+ "      g.schedule = :schedule "
					+ "ORDER BY g.gameDate ASC", Game.class)
					.setParameter("team", team)
					.setParameter("schedule", schedule)
					.setMaxResults(1)
					.getSingleResult();
			return format.format(nextGame.getGameDate()).toUpperCase();
		} catch (NoResultException e) {
			return "No games remaining";
		}
	}

}

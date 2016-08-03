/**
 * 
 */
package com.seanjohn.nhl.business;

import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class ScheduleSessionBean {
	
	/**
	 * 
	 */
	public ScheduleSessionBean() {
	}
	
	public String getNextGame(Team team, Schedule schedule) {
		
		String pattern = "EEE d MMM yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		String teamID = team.getTeamId();
		for (Game game : schedule.getGames()) {
			if (game.getHome().getTeamId().equals(teamID) || game.getVisitor().getTeamId().equals(teamID)) {
				return format.format(game.getGameDate()).toUpperCase();
			}
		}
		
		return "No games remaining";
	}
}

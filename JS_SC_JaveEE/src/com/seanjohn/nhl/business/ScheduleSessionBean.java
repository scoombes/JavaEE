/**
 * 
 */
package com.seanjohn.nhl.business;

import javax.ejb.Stateless;

@Stateless
public class ScheduleSessionBean {

	/**
	 * 
	 */
	public ScheduleSessionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNextGame(Team team, Schedule schedule) {
		for (Game game : schedule.getGames()) {
			if (game.getHome().equals(team) || game.getVisitor().equals(team)) {
				return game.getGameDate().toString();
			}
		}
		return "";
	}
}

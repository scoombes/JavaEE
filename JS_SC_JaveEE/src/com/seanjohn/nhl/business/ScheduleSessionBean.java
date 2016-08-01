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
		String teamID = team.getTeamId();
		for (Game game : schedule.getGames()) {
			if (game.getHome().getTeamId().equals(teamID) || game.getVisitor().getTeamId().equals(teamID)) {
				return game.getGameDate().toString();
			}
		}
		return team.getTeamname() + " Had no games?!?";
	}
}

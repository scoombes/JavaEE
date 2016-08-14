package com.seanjohn.nhl.business;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class TeamGame implements Serializable {
	private Date gameDate;
	private Time gameTime;
	private long gameId;
	private String visitorTeam;
	private String teamId;
	private String score;
	private String arena;
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(String visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public Time getGameTime() {
		return gameTime;
	}
	public void setGameTime(Time gameTime) {
		this.gameTime = gameTime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getArena() {
		return arena;
	}
	public void setArena(String arena) {
		this.arena = arena;
	}
}

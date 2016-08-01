/*
 *   Document   : Schedule.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long scheduleId;
	@ManyToOne
	@JoinColumn(name = "league")
	private League league;
	private String season;
	private String schedulename;
	private String sponsor;
	@OneToMany(mappedBy="schedule")
	private List<Game> games; 
	private List<PlayerStats> playerStats;
	
	public List<PlayerStats> getPlayerStats() {
		return playerStats;
	}
	
	public void setPlayerStats(List<PlayerStats> playerStats) {
		this.playerStats = playerStats;
	}
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleid(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSchedulename() {
		return schedulename;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
}

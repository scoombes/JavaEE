/*
 *   Document   : Roster.java
 *   Created on : June 15, 2016
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
public class Roster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int rosterId;
	@ManyToOne
	@JoinColumn(name="player")
	private Player player;
	@ManyToOne
	@JoinColumn(name="team")
	private Team team;
	private String position;
	private Long jersey;
	@OneToMany
	private List<PlayerStats> playerStats;
	
	public int getRosterId() {
		return rosterId;
	}

	public void setRosterId(int rosterId) {
		this.rosterId = rosterId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<PlayerStats> getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(List<PlayerStats> playerStats) {
		this.playerStats = playerStats;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getJersey() {
		return jersey;
	}

	public void setJersey(Long jersey) {
		this.jersey = jersey;
	}
}

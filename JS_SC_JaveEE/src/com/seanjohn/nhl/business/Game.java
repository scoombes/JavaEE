/*
 *   Document   : Game.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.business;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long gameId;
	@ManyToOne
	@JoinColumn(name = "schedule")
	private Schedule schedule;
	private Date gameDate;
	private Time gameTime;
	@ManyToOne
	@JoinColumn(name = "arena")
	private Arena arena;
	@ManyToOne
	@JoinColumn(name = "home")
	private Team home;
	@ManyToOne
	@JoinColumn(name = "visitor")
	private Team visitor;
	private Long homeScore;
	private Long visitorScore;
	private char OT;
	private char SO;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getVisitor() {
		return visitor;
	}

	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}

	public long getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(long homeScore) {
		this.homeScore = homeScore;
	}

	public long getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(long visitorScore) {
		this.visitorScore = visitorScore;
	}

	public char getOT() {
		return OT;
	}

	public void setOT(char oT) {
		OT = oT;
	}

	public char getSO() {
		return SO;
	}

	public void setSO(char sO) {
		SO = sO;
	}

}

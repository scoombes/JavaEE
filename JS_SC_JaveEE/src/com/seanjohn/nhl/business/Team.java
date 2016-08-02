/*
 *   Document   : Team.java
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
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String teamId;
	private String teamName;
	private String webSite;
	@ManyToOne
	@JoinColumn(name = "headCoach")
	private Staff headCoach;
	@ManyToOne
	@JoinColumn(name = "asstcoach")
	private Staff asstcoach;
	@ManyToOne
	@JoinColumn(name = "trainer")
	private Staff trainer;
	@ManyToOne
	@JoinColumn(name = "manager")
	private Staff manager;
	@OneToMany
	private List<Game> games;
	
	@OneToMany(mappedBy="team")
	private List<Roster> roster;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Staff getAsstcoach() {
		return asstcoach;
	}

	public void setAsstcoach(Staff asstcoach) {
		this.asstcoach = asstcoach;
	}

	public List<Roster> getRoster() {
		return roster;
	}

	public void setRoster(List<Roster> roster) {
		this.roster = roster;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamname() {
		return teamName;
	}

	public void setTeamname(String teamname) {
		this.teamName = teamname;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Staff getHeadCoach() {
		return headCoach;
	};

	public void setHeadCoach(Staff headCoach) {
		this.headCoach = headCoach;
	}

	public Staff getTrainer() {
		return trainer;
	};

	public void setTrainer(Staff trainer) {
		this.trainer = trainer;
	}

	public Staff getManager() {
		return manager;
	};

	public void setManager(Staff manager) {
		this.manager = manager;
	}
}

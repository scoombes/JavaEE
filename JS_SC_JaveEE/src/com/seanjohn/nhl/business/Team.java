/*
 *   Document   : Team.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	public Staff getAsstCoach() {
		return asstcoach;
	};

	public void setAsstCoach(Staff asstcoach) {
		this.asstcoach = asstcoach;
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

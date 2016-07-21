package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class League implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String leagueId;
	private String leagueName;
	private String leagueSponsor;

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueSponsor() {
		return leagueSponsor;
	}

	public void setLeagueSponsor(String leagueSponsor) {
		this.leagueSponsor = leagueSponsor;
	}
}

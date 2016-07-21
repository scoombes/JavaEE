package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlayerStats implements Serializable {
	@Id
	private String leagueId;

}

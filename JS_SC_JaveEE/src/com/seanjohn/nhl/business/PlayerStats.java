package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlayerStats implements Serializable {
	@Id
	private String statsId;
	@ManyToOne
	@JoinColumn(name="player")
	private Player player;
	@ManyToOne
	@JoinColumn(name="roster")
	private Roster roster;
	@ManyToOne
	@JoinColumn(name="schedule")
	private Schedule schedule;
	private long gp;
	private long goals;
	private long assists;
	private long plusMinus;
	private long pim;
	private long pp;
	private long sh;
	private long gwg;
	private long shots;
	private long shotpct;
	private long suspensions;
	private long gaa;
	private long so;

}

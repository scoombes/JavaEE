/*
 *   Document   : PlayerStats.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlayerStats implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	public String getStatsId() {
		return statsId;
	}
	public void setStatsId(String statsId) {
		this.statsId = statsId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Roster getRoster() {
		return roster;
	}
	public void setRoster(Roster roster) {
		this.roster = roster;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public long getGp() {
		return gp;
	}
	public void setGp(long gp) {
		this.gp = gp;
	}
	public long getGoals() {
		return goals;
	}
	public void setGoals(long goals) {
		this.goals = goals;
	}
	public long getAssists() {
		return assists;
	}
	public void setAssists(long assists) {
		this.assists = assists;
	}
	public long getPlusMinus() {
		return plusMinus;
	}
	public void setPlusMinus(long plusMinus) {
		this.plusMinus = plusMinus;
	}
	public long getPim() {
		return pim;
	}
	public void setPim(long pim) {
		this.pim = pim;
	}
	public long getPp() {
		return pp;
	}
	public void setPp(long pp) {
		this.pp = pp;
	}
	public long getSh() {
		return sh;
	}
	public void setSh(long sh) {
		this.sh = sh;
	}
	public long getGwg() {
		return gwg;
	}
	public void setGwg(long gwg) {
		this.gwg = gwg;
	}
	public long getShots() {
		return shots;
	}
	public void setShots(long shots) {
		this.shots = shots;
	}
	public long getShotpct() {
		return shotpct;
	}
	public void setShotpct(long shotpct) {
		this.shotpct = shotpct;
	}
	public long getSuspensions() {
		return suspensions;
	}
	public void setSuspensions(long suspensions) {
		this.suspensions = suspensions;
	}
	public long getGaa() {
		return gaa;
	}
	public void setGaa(long gaa) {
		this.gaa = gaa;
	}
	public long getSo() {
		return so;
	}
	public void setSo(long so) {
		this.so = so;
	}
}

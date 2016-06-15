package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Playerstats implements Serializable {
  private Long statsid;
  private Long player;
  private Long roster;
  private Long schedule;
  private Long gp;
  private Long goals;
  private Long assists;
  private Long plusminus;
  private Long pim;
  private Long pp;
  private Long sh;
  private Long gwg;
  private Long shots;
  private Double shotpct;
  private Long suspensions;
  private Double gaa;
  private Long so;

  public Long getStatsid() {
    return statsid;
  }

  public void setStatsid(Long statsid) {
    this.statsid = statsid;
  }

  public Long getPlayer() {
    return player;
  }

  public void setPlayer(Long player) {
    this.player = player;
  }

  public Long getRoster() {
    return roster;
  }

  public void setRoster(Long roster) {
    this.roster = roster;
  }

  public Long getSchedule() {
    return schedule;
  }

  public void setSchedule(Long schedule) {
    this.schedule = schedule;
  }

  public Long getGp() {
    return gp;
  }

  public void setGp(Long gp) {
    this.gp = gp;
  }

  public Long getGoals() {
    return goals;
  }

  public void setGoals(Long goals) {
    this.goals = goals;
  }

  public Long getAssists() {
    return assists;
  }

  public void setAssists(Long assists) {
    this.assists = assists;
  }

  public Long getPlusminus() {
    return plusminus;
  }

  public void setPlusminus(Long plusminus) {
    this.plusminus = plusminus;
  }

  public Long getPim() {
    return pim;
  }

  public void setPim(Long pim) {
    this.pim = pim;
  }

  public Long getPp() {
    return pp;
  }

  public void setPp(Long pp) {
    this.pp = pp;
  }

  public Long getSh() {
    return sh;
  }

  public void setSh(Long sh) {
    this.sh = sh;
  }

  public Long getGwg() {
    return gwg;
  }

  public void setGwg(Long gwg) {
    this.gwg = gwg;
  }

  public Long getShots() {
    return shots;
  }

  public void setShots(Long shots) {
    this.shots = shots;
  }

  public Double getShotpct() {
    return shotpct;
  }

  public void setShotpct(Double shotpct) {
    this.shotpct = shotpct;
  }

  public Long getSuspensions() {
    return suspensions;
  }

  public void setSuspensions(Long suspensions) {
    this.suspensions = suspensions;
  }

  public Double getGaa() {
    return gaa;
  }

  public void setGaa(Double gaa) {
    this.gaa = gaa;
  }

  public Long getSo() {
    return so;
  }

  public void setSo(Long so) {
    this.so = so;
  }
}

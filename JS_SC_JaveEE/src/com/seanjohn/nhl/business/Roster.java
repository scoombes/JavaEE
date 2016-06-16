package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Roster implements Serializable {
  private Long rosterid;
  private Long player;
  private String team;
  private String position;
  private Long jersey;

  public Long getRosterid() {
    return rosterid;
  }

  public void setRosterid(Long rosterid) {
    this.rosterid = rosterid;
  }

  public Long getPlayer() {
    return player;
  }

  public void setPlayer(Long player) {
    this.player = player;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
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

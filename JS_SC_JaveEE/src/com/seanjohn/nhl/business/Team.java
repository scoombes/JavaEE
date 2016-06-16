/*
 *   Document   : Team.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Team implements Serializable {
  private Long losses;
  private Long wins;
  private Long overtimeLosses;
  private Long points;
  private String teamid;
  private String teamname;
  private String headcoach;
  private String asstcoach;
  private String trainer;
  private String manager;

  public String getTeamid() {
    return teamid;
  }

  public void setTeamid(String teamid) {
    this.teamid = teamid;
  }

  public String getTeamname() {
    return teamname;
  }

  public void setTeamname(String teamname) {
    this.teamname = teamname;
  }

  public String getHeadcoach() {
    return headcoach;
  }

  public void setHeadcoach(String headcoach) {
    this.headcoach = headcoach;
  }

  public String getAsstcoach() {
    return asstcoach;
  }

  public void setAsstcoach(String asstcoach) {
    this.asstcoach = asstcoach;
  }

  public String getTrainer() {
    return trainer;
  }
  public void setTrainer(String trainer) {
    this.trainer = trainer;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }
  
  public Long getLosses() {
    return losses;
  }

  public void setLosses(Long losses) {
    this.losses = losses;
  }

  public Long getWins() {
    return wins;
  }

  public void setWins(Long wins) {
    this.wins = wins;
  }

  public Long getOvertimeLosses() {
    return overtimeLosses;
  }

  public void setOvertimeLosses(Long overtimeLosses) {
    this.overtimeLosses = overtimeLosses;
  }

  public Long getPoints() {
    return points;
  }

  public void setPoints(Long points) {
    this.points = points;
  }
}

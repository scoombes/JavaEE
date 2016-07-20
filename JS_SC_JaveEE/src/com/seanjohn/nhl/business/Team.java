/*
 *   Document   : Team.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team implements Serializable {	
  private static final long serialVersionUID = 1L;
  private Long losses;
  private Long wins;
  private Long overtimeLosses;
  private Long points;
  private String teamId;
  private String teamName;
  private String headCoach;
  private String asstcoach;
  private String trainer;
  private String manager;

  @Id
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

  public String getHeadcoach() {
    return headCoach;
  }

  public void setHeadcoach(String headcoach) {
    this.headCoach = headcoach;
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

package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Team implements Serializable {
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
}

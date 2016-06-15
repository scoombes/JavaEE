package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Team implements Serializable {
  private String teamid;
  private String league;
  private String sponsor;
  private String teamname;
  private Long headcoach;
  private Long asstcoach;
  private Long trainer;
  private Long manager;
  private String website;

  public String getTeamid() {
    return teamid;
  }

  public void setTeamid(String teamid) {
    this.teamid = teamid;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  public String getSponsor() {
    return sponsor;
  }

  public void setSponsor(String sponsor) {
    this.sponsor = sponsor;
  }

  public String getTeamname() {
    return teamname;
  }

  public void setTeamname(String teamname) {
    this.teamname = teamname;
  }

  public Long getHeadcoach() {
    return headcoach;
  }

  public void setHeadcoach(Long headcoach) {
    this.headcoach = headcoach;
  }

  public Long getAsstcoach() {
    return asstcoach;
  }

  public void setAsstcoach(Long asstcoach) {
    this.asstcoach = asstcoach;
  }

  public Long getTrainer() {
    return trainer;
  }

  public void setTrainer(Long trainer) {
    this.trainer = trainer;
  }

  public Long getManager() {
    return manager;
  }

  public void setManager(Long manager) {
    this.manager = manager;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }
}

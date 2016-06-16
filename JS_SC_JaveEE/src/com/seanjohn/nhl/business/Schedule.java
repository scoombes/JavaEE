/*
 *   Document   : Schedule.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Schedule implements Serializable {
  private Long scheduleid;
  private String league;
  private String season;
  private String schedulename;
  private String sponsor;

  public Long getScheduleid() {
    return scheduleid;
  }

  public void setScheduleid(Long scheduleid) {
    this.scheduleid = scheduleid;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public String getSchedulename() {
    return schedulename;
  }

  public void setSchedulename(String schedulename) {
    this.schedulename = schedulename;
  }

  public String getSponsor() {
    return sponsor;
  }

  public void setSponsor(String sponsor) {
    this.sponsor = sponsor;
  }
}

package com.seanjohn.nhl.business;

import java.io.Serializable;

public class League implements Serializable{
  private String leagueid;
  private String leaguename;
  private String leaguesponsor;

  public String getLeagueid() {
    return leagueid;
  }

  public void setLeagueid(String leagueid) {
    this.leagueid = leagueid;
  }

  public String getLeaguename() {
    return leaguename;
  }

  public void setLeaguename(String leaguename) {
    this.leaguename = leaguename;
  }

  public String getLeaguesponsor() {
    return leaguesponsor;
  }

  public void setLeaguesponsor(String leaguesponsor) {
    this.leaguesponsor = leaguesponsor;
  }
}

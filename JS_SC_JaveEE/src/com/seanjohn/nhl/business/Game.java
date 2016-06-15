package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Game implements Serializable{
  private Long gameid;
  private Long schedule;
  private java.sql.Date gamedate;
  private java.sql.Time gametime;
  private Long arena;
  private String home;
  private String visitor;
  private Long homescore;
  private Long visitorscore;
  private String ot;
  private String so;

  public Long getGameid() {
    return gameid;
  }

  public void setGameid(Long gameid) {
    this.gameid = gameid;
  }

  public Long getSchedule() {
    return schedule;
  }

  public void setSchedule(Long schedule) {
    this.schedule = schedule;
  }

  public java.sql.Date getGamedate() {
    return gamedate;
  }

  public void setGamedate(java.sql.Date gamedate) {
    this.gamedate = gamedate;
  }

  public java.sql.Time getGametime() {
    return gametime;
  }

  public void setGametime(java.sql.Time gametime) {
    this.gametime = gametime;
  }

  public Long getArena() {
    return arena;
  }

  public void setArena(Long arena) {
    this.arena = arena;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getVisitor() {
    return visitor;
  }

  public void setVisitor(String visitor) {
    this.visitor = visitor;
  }

  public Long getHomescore() {
    return homescore;
  }

  public void setHomescore(Long homescore) {
    this.homescore = homescore;
  }

  public Long getVisitorscore() {
    return visitorscore;
  }

  public void setVisitorscore(Long visitorscore) {
    this.visitorscore = visitorscore;
  }

  public String getOt() {
    return ot;
  }

  public void setOt(String ot) {
    this.ot = ot;
  }

  public String getSo() {
    return so;
  }

  public void setSo(String so) {
    this.so = so;
  }
}

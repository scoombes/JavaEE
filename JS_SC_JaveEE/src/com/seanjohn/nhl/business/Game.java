/*
 *   Document   : Game.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Game implements Serializable{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private java.sql.Date gamedate;
  private String arena;
  private String home;
  private String visitor;
  private int homescore;
  private int visitorscore;
  private String ot;
  private String so;



  public java.sql.Date getGamedate() {
    return gamedate;
  }

  public void setGamedate(java.sql.Date gamedate) {
    this.gamedate = gamedate;
  }

  public String getArena() {
    return arena;
  }

  public void setArena(String arena) {
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

  public int getHomescore() {
    return homescore;
  }

  public void setHomescore(int homescore) {
    this.homescore = homescore;
  }

  public int getVisitorscore() {
    return visitorscore;
  }

  public void setVisitorscore(int visitorscore) {
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

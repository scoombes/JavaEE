/*
 *   Document   : Roster.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Roster implements Serializable {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private String playerName;
  private String position;
  private Long jersey;


  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
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

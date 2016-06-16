package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Roster implements Serializable {
  private String playerName;
  private String position;
  private Long jersey;


  public String getPlayerName() {
    return playerName;
  }

  public void setPlayername(String playerName) {
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

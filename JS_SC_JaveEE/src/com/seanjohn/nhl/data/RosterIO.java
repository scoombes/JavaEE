/*
 *   Document   : RosterIO.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seanjohn.nhl.business.*;

public class RosterIO extends GenericIO {

	public RosterIO(String username, String password) {
		super(username, password);
	}
	
	public String getTeam(String teamId) throws SQLException{
		PreparedStatement ps = this.db
				.prepareStatement("SELECT TEAMNAME " +
								  "FROM TEAM " +
								  "WHERE TEAMID = ? ");
		ps.setString(1, teamId);
		ResultSet rs = ps.executeQuery();
		String teamName = "";
		while (rs.next()) {
			teamName = rs.getString(1);
		}
		
		return teamName;
	}
	
	public ArrayList<Roster> getRoster(String teamId) throws SQLException {
        PreparedStatement ps = this.db

                .prepareStatement("SELECT p.lastname || ', ' || p.firstname as playername, " +
                		          "r.position, r.jersey " +
                                  "FROM PLAYER p " +
                                  "    JOIN ROSTER r " +      
                                  "        ON p.playerid = r.player " +      
                                  "WHERE r.TEAM = ? ");
        ps.setString(1, teamId);
        ResultSet rs = ps.executeQuery();
        ArrayList<Roster> roster = new ArrayList<Roster>();
        
        // Read & Print records
        while (rs.next()) {
            Roster player = new Roster();
            player.setPlayerName(rs.getString(1));
            player.setPosition(rs.getString(2));
            player.setJersey(rs.getLong(3));
            roster.add(player);
        }      
        return roster;
    }
}

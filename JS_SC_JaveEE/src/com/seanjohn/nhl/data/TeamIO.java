/*
 *   Document   : Team.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seanjohn.nhl.business.*;

public class TeamIO extends GenericIO {

	public TeamIO(String username, String password) {
		super(username, password);
	}
	
	public Team getTeam(String teamID) throws SQLException {
		PreparedStatement ps = this.db.prepareStatement("SELECT TeamName FROM TEAM WHERE TEAMID = ?");
		ps.setString(0, teamID);
		ResultSet rs = ps.executeQuery();
		// Read & Print records
		while (rs.next()) {
			Team team = new Team();
			team.setTeamname(rs.getString(0));
			return team;
		}
		
		return null;
	}
	
	public ArrayList<Team> getTeams() throws SQLException {
        ResultSet rs = this.db
                .prepareStatement("SELECT t.TEAMID, t.TEAMNAME, " +
                                  "    s1.LASTNAME || ', ' || s1.FIRSTNAME as coach, " +
                                  "    s2.LASTNAME || ', ' || s2.FIRSTNAME as asstcoach, " +
                                  "    s3.LASTNAME || ', ' || s3.FIRSTNAME as trainer, " +
                                  "    s4.LASTNAME || ', ' || s4.FIRSTNAME as manager " +
                                  "FROM Team t " +
                                  "    LEFT JOIN STAFF s1 " +      
                                  "        ON t.HEADCOACH = s1.STAFFID " +      
                                  "    LEFT JOIN STAFF s2 " +      
                                  "        ON t.ASSTCOACH = s2.STAFFID " +      
                                  "    LEFT JOIN STAFF s3 " +      
                                  "        ON t.TRAINER = s3.STAFFID " +      
                                  "    LEFT JOIN STAFF s4 " +      
                                  "        ON t.MANAGER = s4.STAFFID")                                                                             
                .executeQuery();
        
        ArrayList<Team> teams = new ArrayList<Team>();
        
        // Read & Print records
        while (rs.next()) {
            Team team = new Team();
            team.setTeamid(rs.getString(1));
            team.setTeamname(rs.getString(2));
            team.setHeadcoach(rs.getString(3));
            team.setAsstcoach(rs.getString(4));
            team.setTrainer(rs.getString(5));
            team.setManager(rs.getString(6));
            teams.add(team);
        }
        
        return teams;
    }
	
	public ArrayList<Team> getStandings() throws SQLException {
        ResultSet rs = this.db
                .prepareStatement("SELECT TEAMNAME, TEAMID, SUM(POINTS) as POINTS, " +
                                  "  COUNT(case when Result = 'W' then 1 else null end) AS Wins, " +
                                  "  COUNT(case when Result = 'L' then 1 else null end) AS Losses, " +
                                  "  COUNT(case when Result = 'OL' then 1 else null end) AS \"Overtime Losses\" " +
                                  "FROM " +
                                  "  (SELECT HOME as TEAMID, 2 as Points, 'W' as Result FROM GAME WHERE HOMESCORE > VISITORSCORE " +
                                  "   UNION ALL SELECT VISITOR as TEAMID, 2 as Points, 'W' as Result FROM GAME WHERE HOMESCORE < VISITORSCORE " +
                                  "   UNION ALL SELECT HOME as TEAMID, 1 as Points, 'OL' as Result  FROM GAME WHERE HOMESCORE < VISITORSCORE AND OT = 'Y' " +
                                  "   UNION ALL SELECT VISITOR as TEAMID, 1 as Points, 'OL' as Result  FROM GAME WHERE HOMESCORE > VISITORSCORE AND OT = 'Y' " +
                                  "   UNION ALL SELECT HOME as TEAMID, 0 as Points, 'L' as Result  FROM GAME WHERE HOMESCORE < VISITORSCORE AND OT = 'N' " +
                                  "   UNION ALL SELECT VISITOR as TEAMID, 0 as Points, 'L' as Result  FROM GAME WHERE HOMESCORE > VISITORSCORE AND OT = 'N') AS s " +
                                  "  JOIN TEAM t USING(TEAMID) " +
                                  "GROUP BY TEAMNAME, TEAMID " +
                                  "ORDER BY POINTS DESC, WINS DESC")                                                                             
                .executeQuery();
        
        ArrayList<Team> teams = new ArrayList<Team>();
        
        // Read & Print records
        while (rs.next()) {
            Team team = new Team();
            team.setTeamname(rs.getString(1));
            team.setTeamid(rs.getString(2));
            team.setPoints(rs.getLong(3));
            team.setWins(rs.getLong(4));
            team.setLosses(rs.getLong(5));
            team.setOvertimeLosses(rs.getLong(6));
            teams.add(team);
        }
        
        return teams;
	}
}

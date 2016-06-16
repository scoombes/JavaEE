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
				.prepareStatement("SELECT TeamName FROM TEAM")
				.executeQuery();
		
		ArrayList<Team> teams = new ArrayList<Team>();
		
		// Read & Print records
		while (rs.next()) {
			Team team = new Team();
			team.setTeamname(rs.getString(0));
			teams.add(team);
		}
		
		return teams;
	}
	
}

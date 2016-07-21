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
import java.util.List;

import com.seanjohn.nhl.business.*;

public class TeamHIO extends HibernateIO {

	public TeamHIO() {
		super();
	}
	
	
	public List<Team> getTeams(){
		List<Team> teams = this.em.createQuery("select t from Team t", Team.class).getResultList();
		this.em.getTransaction().commit();
		
		return teams;
	}
}

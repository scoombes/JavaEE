/*
 *   Document   : GenericIO.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.derby.jdbc.ClientDataSource;

import com.seanjohn.nhl.business.Team;

/**
 * @author black
 *
 */
public class HibernateIO {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public HibernateIO() {
		emf = Persistence.createEntityManagerFactory("nhlLeagueContext");
		em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager(){		
		return em;
	}
}

/*
 *   Document   : HibernateIO.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author black
 *
 */
public class HibernateIO {
	public static EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public HibernateIO() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("nhlLeagueContext");	
		}
		em = emf.createEntityManager();
	}
}

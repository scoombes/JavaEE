/*
 *   Document   : Arena.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.SQLException;
import java.util.List;

import com.seanjohn.nhl.business.Arena;

public class ArenaHIO extends HibernateIO {

	public List<Arena> getArenas() throws SQLException {
		return em.createQuery("select a from Arena a "
					+ "ORDER BY a.arenaName ", Arena.class)
				.getResultList();
	}
}

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

public class GameHIO extends HibernateIO {

	public Game getGame(long gameId) throws SQLException {
		return em
				.createQuery(
						"SELECT G "
								+ "FROM Game g "
								+ "WHERE g.gameId = :gameId ", Game.class)
								.setParameter("gameId", gameId).getSingleResult();
	}
	
	public void updateGame(Game updatedGame) throws SQLException{
		
	}
}

/*
 *   Document   : GameHIO.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */
package com.seanjohn.nhl.data;

import java.sql.SQLException;

import com.seanjohn.nhl.business.Game;

public class GameHIO extends HibernateIO {

	public Game getGame(long gameId) throws SQLException {
		return em
				.createQuery(
						"SELECT G " + "FROM Game g "
								+ "WHERE g.gameId = :gameId ", Game.class)
				.setParameter("gameId", gameId).getSingleResult();
	}

	public void updateGame(Game updatedGame) throws SQLException {
		em.getTransaction().begin();
		em.persist(updatedGame);
		em.getTransaction().commit();
	}
}

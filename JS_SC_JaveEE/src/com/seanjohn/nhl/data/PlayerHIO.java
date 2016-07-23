/*
 *   Document   : PlayerHIO.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.data;

import java.sql.SQLException;

import com.seanjohn.nhl.business.Player;

public class PlayerHIO extends HibernateIO {
	
	public Player getPlayer(long playerId) throws SQLException{
		Player player = this.em.createQuery("select p from Player p where p.playerId = :playerId", Player.class)
				.setParameter("playerId", playerId).getSingleResult();
	
		return player;
	}
}

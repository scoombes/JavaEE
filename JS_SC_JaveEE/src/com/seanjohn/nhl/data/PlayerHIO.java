/*
 *   Document   : Team.java
 *   Created on : June 15, 2016
 *   Authors    : John Steel & Sean Coombes
 */


package com.seanjohn.nhl.data;

import com.seanjohn.nhl.business.Player;

public class PlayerHIO extends HibernateIO {
	
	
	public Player getPlayer(long playerId){
		Player player = this.em.createQuery("select p from Player p where p.playerId = :playerId", Player.class)
				.setParameter("playerId", playerId).getSingleResult();
	
		return player;
	}
}

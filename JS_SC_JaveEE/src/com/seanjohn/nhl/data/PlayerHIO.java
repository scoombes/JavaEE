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

public class PlayerHIO extends HibernateIO {
	
	
	public Player getPlayer(long playerId){
		Player player = this.em.createQuery("select p from Player p where p.playerId = :playerId", Player.class)
				.setParameter("playerId", playerId).getSingleResult();
	
		return player;
	}
}

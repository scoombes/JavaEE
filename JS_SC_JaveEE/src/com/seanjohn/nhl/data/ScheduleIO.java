/**
 * 
 */
package com.seanjohn.nhl.data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seanjohn.nhl.business.Game;


/**
 * @author black
 *
 */
public class ScheduleIO extends GenericIO {

	/**
	 * @param username
	 * @param password
	 */
	public ScheduleIO(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public class TeamIO extends GenericIO {
		public TeamIO(String username, String password) {
			super(username, password);
		}
	}
	

	public ArrayList<Game> getUpcomingGames() throws SQLException {
        ResultSet rs = this.db
                .prepareStatement("SELECT g.homescore, g.visitorscore, g.ot, g.so, " +
                		"g.gamedate, a.arenaname, t1.teamname, t2.teamname " +
                                  "FROM GAME g " +
                                  "    JOIN ARENA a " +      
                                  "        ON g.arena = a.arenaid " +      
                                  "    JOIN Team t1 " +      
                                  "        ON g.home = t1.teamid " +      
                                  "    JOIN Team t2 " +      
                                  "        ON g.visitor = t2.teamid " +      
                                  "WHERE g.homescore IS NOT null " +      
                                  "		AND g.visitorscore IS NOT null")                                                                             
                .executeQuery();
        
        ArrayList<Game> upcoming = new ArrayList<Game>();
        
        // Read & Print records
        while (rs.next()) {
        	Game game = new Game();
        	game.setHomescore(rs.getInt(1));
    		game.setVisitorscore(rs.getInt(2));
    		game.setOt(rs.getString(3));
    		game.setSo(rs.getString(4));
    		game.setGamedate(rs.getDate(5));
    		game.setArena(rs.getString(6));
    		game.setHome(rs.getString(7));
    		game.setVisitor(rs.getString(8));
            upcoming.add(game);
        }
        
        return upcoming;
    }
		
}

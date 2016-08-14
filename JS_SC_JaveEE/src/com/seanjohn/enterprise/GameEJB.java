package com.seanjohn.enterprise;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Team;

/**
 * Session Bean implementation class GameEJB
 */
@Stateless
@LocalBean
public class GameEJB {

    /**
     * Default constructor. 
     */
    public GameEJB() {
        // TODO Auto-generated constructor stub
    }

    public String getScore(Game game, Team team) throws NullAttributeException {
		String out = "";

		if (game == null) {
			throw new NullAttributeException("game", "game object is null");
		}

		if (team == null) {
			throw new NullAttributeException("team", "team object is null");
		}

		// checks that the supplied team played in the supplied game
		if (!team.getTeamName().equals(game.getHome().getTeamname())
				&& !team.getTeamname().equals(game.getVisitor().getTeamName())) {
			return "supplied team did not play this game";
		}

		// if the game has been played
		if (game.getHomeScore() != null && game.getVisitorScore() != null) {			
			String otStatus = "";
			
			// check ot status
			if (game.getSO() == 'Y') {
				otStatus = "(SO)";
			} else if (game.getOT() == 'Y') {
				otStatus = "(OT)";
			}

			if (team.getTeamName().equals(game.getHome().getTeamname())) {
				out = game.getHomeScore() + "-" + game.getVisitorScore()
						+ otStatus;
			} else {
				out = game.getVisitorScore() + "-" + game.getHomeScore()
						+ otStatus;
			}
		}

		return out;
	}
}

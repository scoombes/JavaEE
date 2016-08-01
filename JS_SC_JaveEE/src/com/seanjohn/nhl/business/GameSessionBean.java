package com.seanjohn.nhl.business;

import javax.ejb.Stateless;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

@Stateless
public class GameSessionBean {

	public String getScore(Game game, Team team) throws NullAttributeException {
		String out = "";

		if (game == null) {
			throw new NullAttributeException("game", "game object is null");
		}

		if (team == null) {
			throw new NullAttributeException("team", "team object is null");
		}

		// checks that the supplied team player in the supplied game
		if (!team.getTeamName().equals(game.getHome().getTeamname())
				&& !team.getTeamname().equals(game.getVisitor().getTeamName())) {
			out = "supplied team did not play this game";
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

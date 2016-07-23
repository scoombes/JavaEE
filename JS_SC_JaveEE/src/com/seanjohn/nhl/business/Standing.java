package com.seanjohn.nhl.business;

public class Standing implements Comparable<Standing> {
	private Team team;
	private int points;
	private int losses;
	private int wins;
	private int overtimeLosses;
	
	public Standing (Team team){
		this.team = team;
	}
	
	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param score the score to set
	 */
	public void setPoints(int p) {
		this.points = p;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @param losses the losses to set
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * @return the overtime losses
	 */
	public int getOvertimeLosses() {
		return overtimeLosses;
	}
	/**
	 * @param overtimeLosses the overtime losses to set
	 */
	public void setOvertimeLosses(int overtimeLosses) {
		this.overtimeLosses = overtimeLosses;
	}

	public void addWin() {
		this.wins += 1;
		this.points += 2;
	}
	
	public void addOvertimeLoss() {
		this.overtimeLosses += 1;
		this.points += 1;
	}

	public void addLoss() {
		this.losses += 1;
	}
	
	public int getGames() {
		return this.losses + this.wins;
	}

	@Override
	public int compareTo(Standing o) {
		if (o.getPoints() == getPoints()) {
			return Integer.compare(o.getGames(), getGames());
		} else { 
			return Integer.compare(getPoints(), o.getPoints());
		}
	}
}

package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * @author Jonathan Ayala
 * @author coce@snhu.edu
 */
public class Game extends Entity {
	
	// tracking teams assigned to this instance
	private List<Team> teams = new ArrayList<Team>();
	
	
	/**
	 * Constructor initializing parameters to the parent class
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	public Team addTeam(String name) {
		Team team = null;
		
		// Iterator will check for existing team matching target name
		Iterator<Team> teamsIterator = teams.iterator();
		
		while (teamsIterator.hasNext()) {
			Team currTeam = teamsIterator.next();
			if (currTeam.getName().equalsIgnoreCase(name)) {
				team = currTeam;
						break;
			}
		}
		
		// If no matches found
		if (team == null) {
			GameService service = GameService.getGameService();
			team = new Team(service.getNextTeamId(), name);
			teams.add(team);
		}
		
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}

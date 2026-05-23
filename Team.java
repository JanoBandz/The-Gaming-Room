package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A simple class to hold information about a team
 * 
 * @author Jonathan Ayala
 * @author coce@snhu.edu
 */
public class Team extends Entity {
	
	//tracking players assigned to this specific team instance
	private List<Player> players = new ArrayList<Player>();
	
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	public Player addPlayer(String name) {
		Player player = null;
		
		// Iterator to check for existing player matching target name
		Iterator<Player> playersIterator = players.iterator();
		
		while (playersIterator.hasNext()) {
			Player currPlayer = playersIterator.next();
			if (currPlayer.getName().equalsIgnoreCase(name)) {
				player = currPlayer;
				break;
			}
		}
		
		// If no matches found
		if (player == null) {
			GameService service = GameService.getGameService();
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
			
		}
		
		return player;
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}

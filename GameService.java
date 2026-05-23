package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator; // added import for Iterator
import java.util.List;

/*
 * A singleton service for the game engine
 * 
 * @author Jonathan Ayala
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	//Trackers utilized for generating unique IDs across teams and players
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	
	/* Singleton Pattern Reference:
	 * This static variable 'service' holds the single, unique instance of theGamerService class.
	 * If we keep it static and null, we can control its life cycle and ensure that no other part of the application
	 * can create multiple game managers.
	 */

	private static GameService service = null;
	
	/*Singleton pattern Constructor:
	 * This restricts object creation and protects the single instance rule.  
	 */
	
	// private constructor
	private GameService() {
		
	}
	
	/* Singleton Pattern Getter:
	 * This public static method acts as the sole entry point for the rest of the application
	 * to access the GameService.
	 */
	
	// method added for single game instance
	public static GameService getGameService() {
		
		if (service == null) {
			
			service = new GameService();
		}
		return service;
	}
		
	
	
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Used iterator to look for existing game with same name
		if (getGame(name) != null) {
			game = getGame(name);
		}
		else {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		for (Game currGame: games) {
			if (currGame.getId() == id) {
				game = currGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/*
		 *  Here we created an "Iterator<Game> instance. The iterator pattern decouples 
		 *  the ArrayList from our search logic.
		 */
		Iterator<Game> gamesIterator = games.iterator();
		
		while (gamesIterator.hasNext()) {
			Game currGame = gamesIterator.next();
			
			if (currGame.getName().equals(name)) {
				game = currGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	/**
	 * Increments and returns the next available unique team identifier.
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
	/**
	 * Increments and returns the next available unique player identifier
	 */
	
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
}
package com.gamingroom;

/**
 * A simple class to hold information about a player
 * 
 * @author Jonathan Ayala
 * @author coce@snhu.edu
 */
public class Player extends Entity {
	
	/*
	 * Constructor initializing parameters to parent class
	 */
	public Player(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
}

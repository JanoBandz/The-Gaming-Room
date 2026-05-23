package com.gamingroom;

/** A base class to hold common attributes and behaviors for all game entities.
 * Implements the necessary requirements to track shared identifiers and names.
 * 
 * @author Jonathan Ayala
 * @author coce@snhu.edu
 */

public class Entity {
	// Protected attributes so inheriting classes can access 
	protected long id;
	protected String name;
	
	// Hide the default constructor to prevent creating empty instances.
	
	protected Entity() {
		
	}
	
	/**
	 * Constructor with an identifier and name
	 */
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// @return the id
	public long getId() {
		return id;
	}
	
	// @return the name
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "entity [id=" + id + ", name=" + name + "]";
	}
}

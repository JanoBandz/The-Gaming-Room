package com.gamingroom;

/* Jonathan Ayala
 * CS-230
 * May 14, 2026
 */


/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// obtain reference to the singleton instance
		GameService service = GameService.getGameService(); // replaced null with GameService.getGameService()
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		Game game2 = service.addGame("Game #1");
		System.out.println(game2);
		
		// used another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}

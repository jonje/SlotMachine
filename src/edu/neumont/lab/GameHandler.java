package edu.neumont.lab;

public class GameHandler {
	private RandomNumberGenerator randomNumberGen;
	
	public GameHandler() {
		randomNumberGen = new RandomNumberGenerator();
	}
	
	public boolean playGame() {
		//RandomNumberGenerator getNumber
		int number = randomNumberGen.getNumber();
		
		/*if getNext is between 1- 8,
				return false
		else
			return true
		endif*/
		
		return (number == 0 || number == 9);
	}

}

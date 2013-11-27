package edu.neumont.lab;

public class GameHandler {
	private RandomNumberGenerator randomNumberGen;
	private int number;
	
	public GameHandler() {
		randomNumberGen = new RandomNumberGenerator();
	}
	
	//Get number
	public int getNumber() {
		//return the number
		return number;
	}
	
	public boolean playGame() {
		//RandomNumberGenerator getNumber
		number = randomNumberGen.getNumber();
		
		/*if getNext is between 1- 8,
				return false
		else
			return true
		endif*/
		
		return (number == 0 || number == 9);
	}

}

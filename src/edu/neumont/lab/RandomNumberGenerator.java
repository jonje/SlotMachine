package edu.neumont.lab;

import java.util.Random;

//RandomNumberGenerator
public class RandomNumberGenerator {
	private Random randomNumber = new Random();
	
	//GetNumber
	public int getNumber() {
		//return a random number 0-9
		return randomNumber.nextInt(10);
		
	}
	
	

}

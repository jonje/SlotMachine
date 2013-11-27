package edu.neumont.lab;

import lejos.nxt.Motor;

public class PotHandler {
	private int coinsInPot;
	private final int MAX_COINS = 4;
	/*
	Create
		Initialize CoinsInPot variable to 0
	*/
	public PotHandler()
	{
		coinsInPot = 0;
	}
	
	
	/*
	AddCoin
		increment CoinsInPot variable
	*/
	public void addCoin()
	{
		coinsInPot++;
	}
	
	
	/*
	getCoinsInPot
		return CoinsInPot variable
	*/
	public int getCoinsInPot()
	{
		return coinsInPot;
	}
	
	
	/*		
	Dispense
		Open the pot to allow coins to fall out
		Wait 1/4 second
		Close the pot
		set CoinsInPot variable to 0
	*/
	public void Dispense()
	{
		//Open the pot to allow coins to fall out
		Motor.B.rotate(60);
		
		//wait 1/4 second
		try {
			wait(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Close the pot
		Motor.B.rotate(-60);
		
		//set CoinsInPot variable to 0
		coinsInPot = 0;
	}
}

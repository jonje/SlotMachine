package edu.neumont.lab;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class CoinAcceptor {
	private final int COIN_LIGHT = 40;
	private LightSensor l;
	private TouchSensor t;
	
	/*
	Create
		Initialize LightSensor
		Initialize TouchSensor
	*/
	public CoinAcceptor()
	{
		//Initialize LightSensor
		l = new LightSensor(SensorPort.S1);
		//Initialize TouchSensor
		t = new TouchSensor(SensorPort.S2);
	}
	

	/*
	AcceptCoin
		wait for TouchSensor to be pressed
		open coin gate with static class Motor
		use LightSensor to see if a coin has been entered
		close coin gate
		return true or false based on the above 
	*/
	public boolean AcceptCoin()
	{
		boolean didCoinPass = false;
		
		//wait for TouchSensor to be pressed
		while(!t.isPressed());
		//open coin gate with static class Motor
		System.out.println(Motor.A.getSpeed());
		Motor.A.rotate(-60);
		//use LightSensor to see if a coin has been entered
		for(int i = 0; i < 100; i++)
		{
			if(l.getLightValue() > COIN_LIGHT)
			{
				didCoinPass = true;
				i = 100;
			}
		}
		//Close coin gate
		Motor.A.rotate(60);
		
		//Return true or false based on the above
		return didCoinPass;
	}

}

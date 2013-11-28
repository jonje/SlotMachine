package edu.neumont.lab;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class CoinAcceptor {
	private final int COIN_LIGHT = 45;
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
		Motor.A.setSpeed(500);
		Motor.A.rotate(-30);
		//use LightSensor to see if a coin has been entered
		for(int i = 0; i < 1000; i++)
		{
			int temp = l.getLightValue();
			if(temp > COIN_LIGHT)
			{
				didCoinPass = true;
				break;
			}
		}
		//Close coin gate
		Motor.A.rotate(30);
		
		//Return true or false based on the above
		return didCoinPass;
	}

}

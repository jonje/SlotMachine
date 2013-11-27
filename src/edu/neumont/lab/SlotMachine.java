package edu.neumont.lab;
import lejos.nxt.Button;

public class SlotMachine {
	
	private CoinAcceptor coinAcceptor;
	private PotHandler potHandler;
	private GameHandler gameHandler;
	
	private final int MAX_COINS = 4;
	
	//Initialize
	public SlotMachine() {
		/*Create CoinAcceptor
		Create PotHandler
		Create GameHandler*/
		coinAcceptor = new CoinAcceptor();
		potHandler = new PotHandler();
		gameHandler = new GameHandler();
		
	}
	
	public void run() {
		//While slot machine is not deactivated…
		while(!isDeactivated()) {
			//if CoinAcceptor’s method AcceptCoin returns true,
			if(coinAcceptor.AcceptCoin()) {
				//if CoinsInPot is greater than MaxCoins
				if(potHandler.getCoinsInPot() > MAX_COINS) {
					//Dispense winnings from PotHandler
					potHandler.dispense();
					//Else
				} else {
					//if Gamehandler’s PlayGame returns true
					if(gameHandler.playGame()) {
						//dispense winnings from PotHandler
						potHandler.dispense();
					}
					//Display the number
					System.out.println(gameHandler.getNumber());
				}
			}
		}
	}
	
	//isDeactivated
	public boolean isDeactivated() {
		//return if escape button is pushed
		return Button.ESCAPE.isDown();
	}
	

}

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
		System.out.println("Slot machine!");
		System.out.println("Place a coin in the tray and push button to play");
		System.out.println("A 0 or a 9 is a win, anything 1-8 is a loss");
		
		//While slot machine is not deactivated…
		while(!isDeactivated()) {
			System.out.println();
			//if CoinAcceptor’s method AcceptCoin returns true,
			if(coinAcceptor.AcceptCoin()) {
				//add coin to PotHandler
				potHandler.addCoin();
				//if CoinsInPot is greater than MaxCoins
				if(potHandler.getCoinsInPot() > MAX_COINS) {
					//Dispense winnings from PotHandler
					System.out.println("You win the Jackpot!!!!");
					potHandler.dispense();
					//Else
				} else {
					//if Gamehandler’s PlayGame returns true
					if(gameHandler.playGame()) {
						//dispense winnings from PotHandler
						System.out.println("You win!!!!");
						potHandler.dispense();
					}
					else
					{
						System.out.println("You lose!");
					}
					//Display the number
					System.out.println("Your number was:" + gameHandler.getNumber());
				}
			}
			else
			{
				System.out.println("No coin detected! Sorry!");
			}
		}
	}
	
	//isDeactivated
	public boolean isDeactivated() {
		//return if escape button is pushed
		return Button.ESCAPE.isDown();
	}
	

}

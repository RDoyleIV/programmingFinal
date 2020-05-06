//Raphael Doyle
//This file has all the coding for the game regarding menu interface and individual input to interact with the game.
package programmingFinal;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class WhileLoop {
		
		
		int numChoice;
		Scanner userInput = new Scanner(System.in);
		boolean exit = false; {
		
		do {
			doMenu();
			numChoice = userInput.nextInt();
			/*I chose to use the switch structure for 
			taking the user input and assigning what that input will do dependent on the user input.
			*/
			switch(numChoice) {
			case 1:
				diceRoll();
				break;
			case 0:
				exit = true;
				break;
				default:
					System.out.println("Invalid Number Input");
					System.out.println("Please try again.");
			}
			System.out.print("\n\n");
		} while(!exit);
		System.out.println("\nProgram Closed");
		userInput.close();
		
		}
		
	private void doMenu() {
			System.out.println("1. Roll Dice");
			System.out.println("0. Exit Program");
			
			System.out.print("Enter your number choice here: ");
			
		}

	private static void diceRoll() {
		int diceSize;
		int rollTimes = 1;

		
		Scanner inputSize = new Scanner(System.in);
		String lineDivider = "----------------------------------------";
		System.out.println(lineDivider);
		System.out.print("Player 1 - Enter 20 to roll a 20-sided die: ");
		
		/* I chose to use this do-while structure as it keeps the game going for multiple user input. One input
		 * for player 1 and another input for player 2. It keeps going until the roll count is <=6 and after each
		 * successful roll that happens within the game the input counter is added by 1 until the game is finished.
		 */
		do {
		diceSize = inputSize.nextInt();
		Random diceRand = new Random();
		/* I used these man if structures to produce randomized numbers for each roll the player will conduct.
		 * In addition to this it also provides a fallacy measure in which if the user puts in an improper input
		 * the game will start over and ask for a valid input number.
		 * The winner of the game is calculated by who has the biggest total of roles.
		 */
		if (diceSize == 20) {
			int outcome;
			int outcome2;
			int outcome3;
			
			outcome = diceRand.nextInt(diceSize)+1;
			System.out.print("\n1st Roll "+outcome);	
			rollTimes++;
			
			if (rollTimes >= 2) {
				diceSize = 20;
				outcome2 = diceRand.nextInt(diceSize)+1;
				rollTimes++;
				System.out.print("\n2nd Roll "+outcome2);
				rollTimes++;
				
				if (rollTimes >= 3) {
					diceSize = 20;
					outcome3 = diceRand.nextInt(diceSize)+1;
					rollTimes++;
					System.out.println("\n3rd Roll "+outcome3);

					int player1Total = outcome+outcome2+outcome3;
			
				if (rollTimes >=4) {
					System.out.println("\n"+lineDivider);
					System.out.print("Player 2 - Enter 20 to roll a 20-sided die: ");
					diceSize = inputSize.nextInt();
					Random diceRand2 = new Random();
					if (diceSize == 20) {
						int player2Outcome;
						int player2Outcome2;
						int player2Outcome3;
						
						player2Outcome = diceRand2.nextInt(diceSize)+1;
						System.out.print("\n1st Roll "+player2Outcome);	
						rollTimes++;
						
						if (rollTimes >= 5) {
							diceSize = 20;
							player2Outcome2 = diceRand2.nextInt(diceSize)+1;
							rollTimes++;
							System.out.println("\n2nd Roll " +player2Outcome2);
							
							rollTimes++;
							if (rollTimes >= 6) {
								diceSize = 20;
								player2Outcome3 = diceRand2.nextInt(diceSize)+1;
								rollTimes++;
								System.out.println("3rd Roll "+player2Outcome3);	
								
							int player2Total = player2Outcome+player2Outcome2+player2Outcome3;
							if (rollTimes >= 3) {
									int[][] displayResults = new int[][] {
										{1, outcome, outcome2, outcome3, player1Total},
										{2, player2Outcome, player2Outcome2, player2Outcome3, player2Total}
									};
													
									printHeader();				
									for (int x = 0; x < 1; x++) {
										for (int y = 0; y < 1; y++) {
											System.out.print(displayResults[0][0] + ": \t\t" + displayResults[0][1] +" "+ displayResults[0][2] +" " +displayResults[0][3] +"    \t" +displayResults[0][4]);
										}
										System.out.println();
									for (int o = 0; o < 1; o++) {
										for (int z = 0; z < 1; z++) {
											System.out.print(displayResults[1][0] + ": \t\t" + displayResults[1][1]+" "+ displayResults[1][2]+" "+displayResults[1][3]+ "    \t"+displayResults[1][4]);
										}
										System.out.println();
										
										}
									}
									
									if (player1Total > player2Total) {
										System.out.print(lineDivider);
										System.out.print("\nPlayer 1 is the winner!");
										System.out.print("\n"+lineDivider);
									}
										else if (player1Total == player2Total) {
											System.out.print(lineDivider);
											System.out.print("\nIt is a draw!");
											System.out.print("\n"+lineDivider);
										}
											else {
												System.out.print(lineDivider);
												System.out.print("\nPlayer 2 is the winner!");
												System.out.print("\n"+lineDivider);
											
											}					
										}
									}
								}
							}
						}
					}
				}
			}
			else {
			displayError();
		}
	
		} while (rollTimes <= 6);
		
		
	}
	private static void printHeader() {
		String divider = "----------------------------------------";
		System.out.println();
		System.out.print(divider);
		System.out.println("\nGame Summary");
		System.out.print(divider);
		System.out.println("\nPlayer\t\tRoles\t\tTotal");
		System.out.println(divider);
		
	}
	
	private static void displayError() {
		System.out.println("\nError: Your minimum value must be less than your maximum value.");
		System.out.println("Please try again.");
	}
}
	/* I could not get this to work.
	 * 
	 * private static void dividerLine(int linedash) {
	 *	for (int x = 1; x <= linedash; x++) {
	 *		System.out.print("-");
	 *	}
	 *	System.out.println();
	 * }
	 */ 	

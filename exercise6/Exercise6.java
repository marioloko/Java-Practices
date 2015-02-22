package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise6{	
	
	/**
	 * 
	 * @param players, Calculate if head or tail for this player
	 */
	public static void headOrTail(Player players[]){ //Store in each variable the result of the coin
		for (int ii=0;ii<players.length;ii++){
			int coin = (int)(Math.random()*2); //Generate a number zero or one
			if (coin == 0){ //If coin is 0; is a tail
				players[ii].coin = "TAIL";
			}
			else { //If coin is 1; is a head
				players[ii].coin = "HEAD";
			}
		}
	}
	
	/**
	 * 
	 * @param players Array with all the players
	 */
	public static String score(Player players[]){
		for (int ii=0; ii<players.length;ii++){
			players[ii].winner = true; //By default all players are winner
		}
		for (int ii=0; ii<players.length; ii++){
			for (int bb=0; bb<players.length; bb++){
				if (players[ii].coin == players[bb].coin && ii != bb){ //If one player's coin is equal to other player's coin, it is not a winner
					players[ii].winner = false;
				}
			}
		}
		String winner = "none";
		for (int ii=0; ii<players.length;ii++){
			if (players[ii].winner == true){ //If the player is a winner his name is stored in the winner variable and his score is incresed by one
				winner = players[ii].name; 
				players[ii].score += 1; 
			}
		}
		return winner;
	}
	
	/**
	 * 
	 * @param players Array for printing the scores
	 */
	public static void printScores(Player players[]){ //Print the players score
		for (int ii=0; ii<players.length;ii++){
			System.out.println(players[ii].name.toUpperCase()+" --> "+players[ii].score+" POINTS"); //Print the name of the user in upper case and its score
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the program and our library
		
		final int NUMBER_OF_PLAYERS = 3; //Maximum number of players
		final int NUMBER_OF_ROUNDS = 10; //Maximum number of rounds
		
		Player[] players = new Player[NUMBER_OF_PLAYERS]; //Create an array to store each player
		for (int ii=0;ii<NUMBER_OF_PLAYERS;ii++){
			players[ii] = new Player();
			players[ii].name = "Player "+(ii+1); //Asign a name to each player 
		}
		
		
		
		System.out.println("Press Enter to start the first round");
		sc.nextLine(); //Continue the game if Enter is pressed
	
		for (int ii=1;ii<=NUMBER_OF_ROUNDS;ii++){ //Print the round result and print the scores
			System.out.println("The round"+ii+"result has been: ");
			headOrTail(players); //Calculate if each player has got head or tail
			for (int bb=0; bb<NUMBER_OF_PLAYERS;bb++){
				System.out.println(players[bb].name+" has got "+players[bb].coin); //Print if the player has head or tail	
			}
			String winner = score(players); //Calculate who is the winner
			if (winner != "none"){ //If there exist a winner it will print its name
				System.out.println(winner+" has been the winner for the round "+ii);
			}
			else{ //If there is no winner it will print tie
				System.out.println("The round "+ii+" has ended in tie");
			}
			System.out.println();
			printScores(players); //Print the scores of each player
			System.out.println();
			System.out.println("Press enter to next round: ");
			System.out.println();
			sc.nextLine(); //Continue the game if Enter is pressed
		}
	}
}

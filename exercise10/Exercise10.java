package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise10{
	
	/**
	 * 
	 * @param players Array which contains the length of players to be created
	 */
	public static void createPlayers(DartPlayer []players){//Create a player for each position of the players array, and store it in the array
		for (int ii=0; ii<players.length; ii++){
			players[ii] = new DartPlayer();
			players[ii].name = "Player "+(ii+1); //Set the name of the player to Player plas the position in which has been created
		}
	}
	
	
	/**
	 * 
	 * @param players Array which contains the players created
	 * @param playerTurns Array in which store the players arranged by it turns
	 */
	public static void whoFirst(DartPlayer []players, DartPlayer []playerTurns){ //Calculate which player will throw the darts first
		int whoFirst = (int)(Math.random()*2); //Generate a random number 1 or 2
		if (whoFirst == 0){ //If whoFirst is equal 0, player1 play first
			playerTurns[0] = players[0];
			playerTurns[1] = players[1];
		}
		else { //If whoFirst is equal 1, player2 play first
			playerTurns[0] = players[1];
			playerTurns[1] = players[0];
		}
	}
	
	/**
	 * 
	 * @param array Array to be fill with values equivalents to its position multiplied by a number
	 * @param numero Is the number that multiplies the values which fill the array
	 * @param especialCase Is the value which is store in the first position of the array, it can be failed, semicircle or bulleye
	 */
	public static void fillArray(int []array, int numero, int especialCase){ //Fill the array with numbers between 1 and his length multiplied by a number
		array[0]=especialCase; //The special case is in the first array position, it can be failed, semicircle and BULLEYE
		for (int ii=1; ii<array.length; ii++){ //Store in every position of the array a number between 1 and 20
			array[ii] = ii * numero;
		}
	}
	
	/**
	 * 
	 * @return The position of the dartboard(if it is single, double or triple shot)
	 */
	public static int singleDoubleOrTriple(){//That function generate it the shot is single, double or triple
		int choice = (int)(Math.random()*100); //Generate a number between 0 and 99
		int dartBoardPosition = 0;
		if (choice < 50){ //50% Possibilities hit singles
			dartBoardPosition = 0; 
		}
		else if (choice < 50 + 30){ //30% Possibilities hit double
			dartBoardPosition = 1;
		}
		else { //20% possibilities hit triples
			dartBoardPosition = 2;
		}
		return dartBoardPosition;
	}

	/**
	 * 
	 * @param dartBoard Is the matrix which store three positions arrays, and the score of each one
	 * @return The score of the position of the matrix generated randomly
	 */
	public static int hitTheDartBoard(int [][]dartBoard){//return the score of the position of the dartboard hitted
		int dartBoardPosition = singleDoubleOrTriple(); //Calculate it is a single, double or triple hit
		int dartBoardElement = (int)(Math.random()*21); //Generate a number between 0 and 21
		int score = 0;
		score = dartBoard[dartBoardPosition][dartBoardElement]; //The dart hit the dartboard in a poin and store the score of that point
		return score; //Return the score of the dart
	}
	
	/**
	 * 
	 * @param player Player which throw the dart, and to whom is substradted the correct score
	 * @param dartBoard Matrix which have all the possible scores
	 * @param INITIAL_SCORE Is the default value if the player score is lower than 0
	 */
	public static void throwDart(DartPlayer player, int [][]dartBoard, int INITIAL_SCORE){ //Subtract the score calculated with the function hitTheDartBoard to the player total score
		int score = hitTheDartBoard(dartBoard); //Calculate the position of the dartboard where the dart has hitten
		System.out.println("The score is "+score);
		player.score -= score; //Substract the score of the dartboard to the score of the player
		System.out.println(player.score+" points left to 0");
		if (player.score < 0){ //If the score of the player is lower than 0, set the value to the INITIAL SCORE
			System.out.println("The score is below 0. It returns to the initial score: "+INITIAL_SCORE);
			player.score = INITIAL_SCORE; 
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		
		final int NUMBER_OF_PLAYERS = 2; //Set the number of players
		final int NUMBER_OF_DARTS = 3; //Set the number of darts that will be thrown in each round
		final int INITIAL_SCORE = 31;  //Set the player score if the player score is lower than 0
		
		/*CREATE THE PLAYERS*/
		DartPlayer []players = new DartPlayer[NUMBER_OF_PLAYERS];
		createPlayers(players); //Create the number of players set before with the constant NUMBER_OF_PLAYERS
		
		/*Which player play first*/
		DartPlayer []playersTurn = new DartPlayer[NUMBER_OF_PLAYERS]; //This array store the players arranged at the position of his turn
		whoFirst(players,playersTurn);
		
		/*SPECIAL CASES*/
		final int FAILED = 0; //If special case failed 0 points
		final int SEMICIRCLE = 25; //If special case SEMICIRCLE 25 points
		final int BULLEYE = 50;  //If special case BULLEYE 50 points
		
		/*CREATING THE DARTBOARD*/
		int [][]dartBoard= new int[3][]; //Create a three dimension array one for single, other for doubles and other for triples
		dartBoard[0] = new int[21];
		fillArray(dartBoard[0],1, FAILED); //Fill the array with numbers between 1 to 20, and special case failed
		dartBoard[1] = new int[21];
		fillArray(dartBoard[1], 2, SEMICIRCLE); //Fill the array with number between 1 to 20 multiplied by 2, and special case semicircle
		dartBoard[2] = new int[21];
		fillArray(dartBoard[2], 3, BULLEYE); //Fill the array with number between 1 to 20 multiplied by 3, and special case bull eye
		
		
		/*MAIN LOOP*/
		int turn = 0; //How many turns has played
		while (playersTurn[0].score != 0 && playersTurn[1].score != 0){
			System.out.println("===================");
			turn += 1; //Increase a turn before doing the turn
			for (int ii=0; ii<playersTurn.length; ii++){//Every player will throw the darts in each round
				System.out.println(playersTurn[ii].name+" Turn");
				for (int bb=0; bb<NUMBER_OF_DARTS; bb++){ //Every player will throw the number of darts setting before in the constant NUMBER_OF_DARTS
					throwDart(playersTurn[ii],dartBoard,INITIAL_SCORE);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Press enter for next turn");
			sc.nextLine(); //Pause the program until the Enter key is pressed
			System.out.println();
		}
		
		/*CHECKING THE WINNER*/
		for (int ii=0;ii<playersTurn.length;ii++){ //Check who is the winner
			if (playersTurn[ii].score == 0){ //Check if the score of this player is 0, if is this is the winner and print is name and it's turns
				System.out.println(playersTurn[ii].name+" has won in "+turn+" shots");
			}
		}
		sc.close();
	}
}

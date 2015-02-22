package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard
import java.io.*; //Import all utilities for read and write into a file

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise11{
	
	/**
	 * 
	 * @param combination Array in which store the combination saved in the combination file
	 */
	public static void readCombinationFile(char []combination){ //Read the combination file and store its colors in the combination array
		File file = null; //Create a link with the File library
		FileReader fr = null; //Create a link with the FileReader library
		BufferedReader br = null; //Create a link with the BuffererReader library
		try {
			file = new File("/home/adrian/combination.txt");  //Store the file to read the combination
			fr = new FileReader(file); //Open the file
			br = new BufferedReader(fr); //Load the file for reading
			String line; //String in which save the content of the position line
			int numLines=0;
			while ((line=br.readLine())!=null){ //The while loop will be executed untill the position line be empty
				combination[numLines] = line.charAt(0); //Store in each position of the char array the letter in each line
				numLines++; //Goes to the following line of the file
			}
		}
		catch(Exception e){ //If the file no exist or there exist and error it will report that and close the file
			e.printStackTrace();
		}finally{
			try{
				if( null != fr){
					fr.close(); //Close the file
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param line Line to write in the new file
	 * @param pw File in which print the String line defined before
	 */
	public static void saveLine(String line, PrintWriter pw){ //Print inside a file the line entered in the function
		try{
			pw.println(line); //Add a line to the pw file
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return a random color
	 */
	public static char whichColor(){ //Generate a random color
		int randomColor = (int)(Math.random()*8);//Generate a random number to decide which will be the number for storing
		char color='a';
		switch(randomColor){
		case 0: color='R';break; //If random number is 0 the color is Red
		case 1: color='B';break; //If random number is 1 the color is Blue
		case 2: color='G';break; //If random number is 2 the color is Green
		case 3: color='Y';break; //If random number is 3 the color is Yellow
		case 4: color='P';break; //If random number is 4 the color is Pink
		case 5: color='W';break; //If random number is 5 the color is White
		case 6: color='N';break; //If random number is 6 the color is Black
		case 7: color='M';break; //If random number is 7 the color is Brown
		}
		return color;
	}
	
	/**
	 * 
	 */
	public static void generateCombinationFile(){ //This method create a text file which store the colors chosen by the user
		char []combinations = new char[4]; //Create a for position array to store the right answer
		for (int ii=0;ii<combinations.length;ii++){ //Fullfill the char array with random colors
			combinations[ii] = whichColor();
		}
		
		FileWriter file = null; //Create a file to print
		PrintWriter pw = null; //Print the output in the file
		
		try {
			file = new FileWriter("/home/adrian/combination.txt"); //Name and direction of the new file
			pw = new PrintWriter(file); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			for (int ii=0;ii<combinations.length;ii++){//Store in each line of the created file one of the random colors generated
				pw.println(combinations[ii]);
			}
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
		
		try{//Close the file after write in it
			file.close();
		}
		catch(Exception e3){
			e3.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param userCombination Array with the color combination entered by the user
	 * @param pw file in which log the proposal entered by the user
	 */
	public static void chooseColors(char []userCombination,PrintWriter pw){ //Ask the user for enter a combination of colors and store it into an array
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		String position = null;
		for (int ii=0; ii<userCombination.length;ii++){
			switch(ii){ //Store in the String position the actual position of the array
			case 0: position = "first";break;
			case 1: position = "second";break;
			case 2: position = "third";break;
			case 3: position = "fourth";
			}
		System.out.println("Specify the color that you want to propose for the "+position+" position:");
		userCombination[ii] = sc.next().toUpperCase().charAt(0); //Store in each position of the array a color(the first letter of the String converted into upperCase)
		}
		printProposal(userCombination, pw); //Print the proposal entered by the user
	}
	
	/**
	 * 
	 * @param userCombination Char array which store the colors entered by the user
	 * @param pw file in which log the proposal entered by the user
	 */
	public static void printProposal(char []userCombination,PrintWriter pw){//Print the colors entered by the user, and store it in the result.txt file
		String proposalIntro = "Your proposal is:";
		String yourProposal = "";
		for (int ii=0; ii<userCombination.length;ii++){
			yourProposal += " "+userCombination[ii];
		}
		System.out.println(proposalIntro);
		System.out.println(yourProposal); //Print your proposal
		saveLine(proposalIntro, pw);
		saveLine(yourProposal, pw); //Save your proposal in the result.txt file
	}
	
	/**
	 * 
	 * @param userCombination char array with the combinations of colors entered by the user
	 * @param combination char array with the combinations of colors of the combination file
	 * @return
	 */
	public static boolean check(char []userCombination, char []combination){//Check if the colors in both arrays are equal
		int []result = new int[4];//Create a new array which store the result of the proposal combination
		for (int ii=0; ii<userCombination.length; ii++){
			boolean stop = false;
			for (int bb=0;bb<combination.length && stop==false;bb++){
				if (userCombination[ii] == combination[bb] && ii == bb){ //If the combinations arrays has the same position and the same color it will store 2
					result[ii] = 2; 
					stop = true;
				}
				else if (userCombination[ii] == combination[bb]){ //If the combinations arrays has a value contained in the other but in a different position it will store 1
					result[ii] = 1;
				}
			}
		}
		printResult(result); //Print the results of the colors entered by the user
		boolean notWin = allCorrect(result); //Check if the user has entered all the correct colors
		return notWin; //Return if the user has already win
	}
	
	/**
	 * 
	 * @param result Array which store the results of the comparison of both combination arrays
	 */
	public static void printResult(int []result){ //Print the result of your proposal colors entered
		System.out.println("Your proposal result is:");
		for (int ii=0; ii<result.length; ii++){
			System.out.print(" "+result[ii]);
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param result Array which store the results of the comparison of both combination arrays
	 * @return if the player have win the game or not yet
	 */
	public static boolean allCorrect(int []result){ //Check if all the colors entered are in the correct position
		boolean notWin = true; //By default the player not Wint
		int correct = 0; //Number of correct colors an position
		for (int ii=0; ii<result.length; ii++){
			if (result[ii] == 2){ //If the array in that position is equal two, add a number to correct
				correct +=1;
			}
		}
		if (correct == 4){ //If the forth number are correct then has won the game
			notWin = false;
		}
		return notWin;
	}
	
	
	
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in); //Create a link between our program and the Scanner library
		
		/*GENERATE COMBINATION FILE AND READ IT*/
		System.out.println("Do you want to generate a random combination file(Single Player)Y/N");
		char singlePlayer = sc.next().toUpperCase().charAt(0); //Ask the user if want to single play(random combination file)
		if (singlePlayer == 'Y'){ //If single player, the combination file will be generated randomly, else the other user must change the combination file
			generateCombinationFile(); //Generate a file with the random colors to play
		}
		
		char []combination = new char[4]; //Create an array in which store the values of the file created
		readCombinationFile(combination); //Read the combination file and store the values in the combination array
		
		/*LET WRITE INTO A FILE*/
		FileWriter file = null; //Create a link with the FileWriter library
		PrintWriter pw = null; //Create a link with the PrintWriter library
		try {
			file = new FileWriter("/home/adrian/result.txt"); //Create the file to write
			pw = new PrintWriter(file); //Let the program print lines into the file to write
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*CREATE A CHAR ARRAY WITH THE COLORS ENTER BY THE USER*/
		char []userCombination = new char[4];
		int round = 0; //Rounds that the player has play
		do {
			round++;
			chooseColors(userCombination, pw); //Store the user combination in the char array, print the proposal and save it in the result.txt file
		}while(check(userCombination, combination)); //Repeats the action until the player get the position of the colors, print the results too
		
		System.out.println("You has guessed the combination in "+round+" rounds");
		
		try{
			pw.close(); //Close the file to write to avoid data loss
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
}

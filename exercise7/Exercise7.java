package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		System.out.println("Specify a number and press Enter:");
		int topLimit = sc.nextInt();
		String number = ""; //String in which store every number lower than topLimit
		for (int ii=0; ii<topLimit; ii++){
			number = ""+ii; //Convert the number into an String for calculating his length
			int numberLength = number.length(); //Calculate the lenth of that number
			int digit[] = new int[numberLength]; //Create an array with one position for each digit
			for (int bb=0;bb<digit.length;bb++){
				digit[bb] = (ii/(int)Math.pow(10, (numberLength - 1 - bb)))%10; //Store each digit in an array position
			}
			
			boolean itPrints = true; //By default the number will print
			for (int bb=0;bb<numberLength;bb++){
				for (int aa=0;aa<numberLength;aa++){
					if (bb != aa && digit[bb] == digit[aa]){ //If the number has the same digit in different possition, itPrint=false; so it wont print
						itPrints=false;
					}
				}
			}
			if (itPrints){//If itPrint is true the program will print the number
				System.out.println("The number "+ii+" has no duplicated digits and it is lower than "+topLimit);
			}
		}
	}
}

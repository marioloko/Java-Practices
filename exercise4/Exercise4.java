package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		System.out.println("Specify a number and press Enter: ");
		int numero = sc.nextInt();
		String numeroString = ""+numero; //Convert the number entered into an String
		System.out.println("The digit number of "+numero+" is "+numeroString.length()); 
		
		int arrayNumbers[] = new int[numeroString.length()]; //Create an array which will store th numbers
		for (int ii=0;ii<numeroString.length();ii++){
			arrayNumbers[ii] = numero / (int)Math.pow(10,(numeroString.length() -1 - ii))%10; //Store each separated number in his array position
		}
		
		int sumNumbers = 0;
		for (int ii=0;ii<numeroString.length();ii++){ //Sum all the digits of the number
			sumNumbers += arrayNumbers[ii];
		}
		System.out.println("The digits addition of "+numero+" is "+ sumNumbers);
		
		System.out.print("The inverted number is ");
		for (int ii=(numeroString.length() - 1);ii>=0;ii--){ //Print the number in inverted orde
			System.out.print(arrayNumbers[ii]);
		}
	}
}

package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise3{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in); //Create a link between the program and the Scanner library
		System.out.println("Introduce the top number to generate perfect numbers and press Enter: ");
		
		int topLimit = sc.nextInt(); //The top limit to generate perfect numbers entered by the user
				
		for (int ii=1; ii<topLimit; ii++){ //We try all numbers below topLimit
			int divisorsSum = 0; //The sum of all the divisor
			for (int number=1; number<ii; number++){ //We divide the number by every lower number
				if (ii%number==0){ //If the remainder of the division is 0, it is a divisor
					divisorsSum += number;
				}
			}
			if (divisorsSum == ii){ //If the sum of the divisor is equal to the number it is a perfect number
				System.out.println("The number "+ii+" is perfect");
			}
		}
	}
}

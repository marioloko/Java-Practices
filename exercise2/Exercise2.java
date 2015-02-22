package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 */
public class Exercise2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		System.out.println("Enter your DNI number and press Enter: ");
		int dni = sc.nextInt(); //Enter the DNI number
		int dniTest = dni - (dni/23*23);
		char nif = 'a';
		switch(dniTest){ //The program will associate a letter to the NIF, in fact of his dniTest value
			case 0: nif='T';break;
			case 1: nif='R';break;
			case 2: nif='W';break;
			case 3: nif='A';break;
			case 4: nif='G';break;
			case 5: nif='M';break;
			case 6: nif='Y';break;
			case 7: nif='F';break;
			case 8: nif='P';break;
			case 9: nif='D';break;
			case 10: nif='X';break;
			case 11: nif='B';break;
			case 12: nif='N';break;
			case 13: nif='J';break;
			case 14: nif='Z';break;
			case 15: nif='S';break;
			case 16: nif='Q';break;
			case 17: nif='V';break;
			case 18: nif='H';break;
			case 19: nif='L';break;
			case 20: nif='C';break;
			case 21: nif='K';break;
			case 22: nif='E';
		}
		System.out.println("The associate NIF is: "+dni+"-"+nif);
		
	}
}

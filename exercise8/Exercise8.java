package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise8{
	
	/**
	 * 
	 * @param matrix matrix to be fill with numbers entered by the user
	 */
	public static void fill(int [][] matrix){//Fullfill every matrix with values entered by the user 
		Scanner sc = new Scanner(System.in);
		for (int ii=0; ii<matrix.length;ii++){
			for (int bb=0; bb<matrix[ii].length; bb++){
				System.out.println("Enter the term in the "+ii+", "+bb+" position and press Enter:");
				matrix[ii][bb] = sc.nextInt(); //Fill this position with the value enter by the user
			}
		}
	}
	
	/**
	 * 
	 * @param matrix matrix to have all his elements printed in the screen
	 */
	public static void print(int [][] matrix){//Print every element of the matrix
		for (int ii=0; ii<matrix.length;ii++){
			for (int bb=0; bb<matrix[ii].length;bb++){
				System.out.print(matrix[ii][bb]+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param matrix matrix for checking which is his minimum value
	 * @return the minimum value of the matrix
	 */
	public static int min(int [][]matrix){
		int minimumValue = matrix[0][0]; //first minimum value of the array
		for (int ii=0; ii<matrix.length; ii++){
			for (int bb=0; bb<matrix[ii].length; bb++){
				if (matrix[ii][bb] < minimumValue){ //If the value of the array in that position is lower than the minimum value that is the minimu value
					minimumValue = matrix[ii][bb];
				}
			}
		}
		return minimumValue ;
	}
	
	/**
	 * 
	 * @param matrix matrix for checking which is his maximum value
	 * @return the maximum value of the matrix
	 */
	public static int max(int [][]matrix){
		int maximumValue = matrix[0][0]; //first maximum value of the array
		for (int ii=0; ii<matrix.length; ii++){
			for (int bb=0; bb<matrix[ii].length; bb++){
				if (matrix[ii][bb] > maximumValue){ //If the value of the array in that position is greater than the maximum value that is the minimu value
					maximumValue = matrix[ii][bb];
				}
			}
		}
		return maximumValue ;
	}
	
	/**
	 * 
	 * @param matrixA matrix for exchanging his minimum value for the maximum value of matrixB
	 * @param matrixB matrix for exchanging his maximum value for the minimum value of matrixA
	 */
	public static void exchange(int [][]matrixA, int [][]matrixB){
		int minimumValue = min(matrixA); //Call the value calculated in the min function and store it
		int maximumValue = max(matrixB); //Call the value calculated in the max function and store it
		
		for (int ii=0; ii<matrixA.length;ii++){
			for (int bb=0; bb<matrixA[ii].length; bb++){
				if (matrixA[ii][bb] == minimumValue){ //If the value in that position of the matrixA is equal to the minimum exchange it
					matrixA[ii][bb] = maximumValue; 
				}
			}
		}
		
		for (int ii=0; ii<matrixB.length; ii++){
			for (int bb=0; bb<matrixB[ii].length; bb++){
				if (matrixB[ii][bb] == maximumValue){ //If the value in that position of the matrixB is equal to the minimum exchange it
					matrixB[ii][bb] = minimumValue;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		
		System.out.println("Specify the number of rows of the M1 matrix and press Enter:");
		int rows = sc.nextInt(); //Enter the number of rows of M1
		System.out.println("Specify the number of colums of the M1 matrix and press Enter:");
		int colums = sc.nextInt(); //Enter the number of colums of M1
		int [][]M1 = new int[rows][colums];
		fill(M1); //Fill all the position of the matrix M1
		print(M1); //Print the matrix M1
		System.out.println("The minimum value of M1 is "+min(M1));
		
		System.out.println("Specify the number of rows of the M2 matrix and press Enter:");
		rows = sc.nextInt(); //Enter the number of rows of M2
		System.out.println("Specify the number of colums of the M2 matrix and press Enter:");
		colums = sc.nextInt(); //Enter the number of colums of M2
		int [][]M2 = new int[rows][colums];
		fill(M2); //Fill all the position of the matrix M1
		print(M2); //Print the matrix M1
		System.out.println("The highest value of M2 is "+max(M2));
		
		exchange(M1,M2); //Exchange the minimun value of M1 by the maximum of M2
		System.out.println("The M1 matrix after the exchange is:");
		print(M1);
		System.out.println("The M2 matrix after the exchange is:");
		print(M2);
		
	}
}

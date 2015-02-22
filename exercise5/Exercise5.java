package practice2;
import java.util.Scanner; //Allow the user enter data from the keyboard
import java.util.ArrayList; //Create an array list to check if there exist an element in it

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 */
public class Exercise5{

	/**
	 * 
	 * @param matrix matrix in which store the elements
	 */
	public static void storeValues(int matrix[][]){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		for (int ii=0; ii<matrix.length; ii++){
			for (int bb=0; bb<matrix[0].length; bb++){ //Store every value of the matrix
				System.out.println("Introduce the term in the "+ii+", "+bb+" position and press Enter");
				matrix[ii][bb] = sc.nextInt();
			}
		}
	}

	/**
	 * 
	 * @param matrix matrix for printing
	 */
	public static void printValues(int matrix[][]){
		for (int ii=0; ii<matrix.length; ii++){//Print the elements of each matrix
			for (int bb=0; bb<matrix[ii].length; bb++){
				System.out.print(matrix[ii][bb]+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param m1 first matrix to compare
	 * @param m2 second matrix to compare with the previows one
	 */
	public static void compareMatrix(int m1[][], int m2[][]){
		ArrayList <Integer>arrList = new ArrayList<Integer>(); //Create a link between the array list and our program
		for (int ii=0; ii<m1.length; ii++){ //Compare each element of each matrixes and print if they repeat
			for (int bb=0; bb<m1[0].length; bb++){
				for (int aa=0; aa<m2.length;aa++){
					for (int cc=0;cc<m2[0].length; cc++){
						if (m1[ii][bb] == m2[aa][cc]){ //Check if the number is equal in both matrix
							if (!arrList.contains(m1[ii][bb])){ //Check if the number is contain in arrayList, if not print it and add it
								System.out.println("The term "+m1[ii][bb]+" is included in both matrixes");
								arrList.add(m1[ii][bb]); //Add the number to array list to not repeat it again
							}
						}
					}
				}
			}
		}
	}

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); //Create a link between the Scanner library and our program
		System.out.println("Specify the number of rows of the M1 matrix and press Enter: ");
		int rowsSizeM1 = sc.nextInt(); //Number of rows entered
		System.out.println("Specify the number of colums of the M1 matrix and press Enter: ");
		int columsSizeM1 = sc.nextInt(); //Number of colums entered
		int m1[][] = new int[rowsSizeM1][columsSizeM1];
		storeValues(m1); //Store the values in the M1 matrix
		printValues(m1); //Print the values of the M1 matrix

		System.out.println("Specify the number of rows of the M2 matrix and press Enter: ");
		int rowsSizeM2 = sc.nextInt(); //Number of rows entered
		System.out.println("Specify the number of colums of the M2 matrix and press Enter: ");
		int columsSizeM2 = sc.nextInt(); //Number of colums entered
		int m2[][] = new int[rowsSizeM2][columsSizeM2];
		storeValues(m2);
		printValues(m2);
		
		compareMatrix(m1,m2); //Compare if both matrixes have the same value	
	}
}

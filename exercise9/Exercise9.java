package practice2; 
import java.util.Scanner; //Allow the user enter data from the keyboard

/**
 * 
 * @author Adrián Gallego Castellanos
 * @author Juan Tafarello Fidalgo
 *
 */
public class Exercise9{
	
	/**
	 * 
	 * @param p person in which store the name(Object Person must be created before)
	 * @param name name to store in the person characteristics
	 */
	public static void setName(Person p, String name){//Store the name into the person name variable
		p.name = name;
	}
	
	/**
	 * 
	 * @param p person in which store the age(Object Person must be created before)
	 * @param age age to store in the person charactersistics
	 */
	public static void setAge(Person p, int age){//Store the age into the person age variable
		p.age = age;
	}
	
	/**
	 * 
	 * @param p person in which store the gender(Object Person must be created before)
	 * @param gender sex of the person to store in the person characteristics
	 */
	public static void setGender(Person p, char gender){//Store the gender into the person gender variable
		if (gender == 'M'){
			p.gender = p.MALE;
		}
		else if (gender == 'F'){
			p.gender = p.FEMALE;
		}
		else {
			System.out.println("Invalid gender, female by default");
		}
	}
	
	/**
	 * 
	 * @param p person in which store the age(Object Person must be created before)
	 * @param dni dni of the person to store the characteristics
	 */
	public static void setDni(Person p, int dni){ //Store the dni into the person dni variable
		String stringDni = ""+dni;
		if (stringDni.length() >= 1 && stringDni.length() <= 8){ //Only allow enter the dni if the number of digits is between 0 and 8
			p.dni = dni;
			calculateDniLetter(p);
		}
		else{ //If the lenght of the dni does not exist stablised that by default
			System.out.println("Thats dni does not exist, setting 11111 by default");
			p.dni = 11111; 
			calculateDniLetter(p);
		}
	}
	
	/**
	 * 
	 * @param p person in which store the age(Object Person must be created before)
	 * @param height height of the person to be stored in the person characteristics
	 */
	public static void setHeight(Person p, double height){ //Store the height into the person height variable
		p.height = height;
	}
	
	/**
	 * 
	 * @param p person in which store the age(Object Person must be created before)
	 * @param weight weight of the person to be stored in th person characteristics
	 */
	public static void setWeight(Person p, double weight){ //Store the weight into the person weight variable
		p.weight = weight;
	}
	
	/**
	 * 
	 * @param p person to calculate the letter of the dni and store in it
	 */
	public static void calculateDniLetter(Person p){
		int nifNumber = p.dni - (p.dni/23*23); //Use an algorithm to calculate the dni number
		char nif = 'A';
		switch(nifNumber){ //Each nifNumber has a different dniLetter
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
		p.dniLetter = nif;
	}
	
	/**
	 * 
	 * @param p person to create an String with the characteristics
	 * @return a String which store all the person characteristics
	 */
	public static String printPerson(Person p){
		String personalInfo = "Person Information:";//Create an String for each line in the response
		String name = "Name: "+p.name;
		String gender = "Gender: "+p.gender;
		String age = "Age: "+p.age+" years old";
		String dni = "DNI: "+p.dni+"-"+p.dniLetter;
		String weight = "Weight: "+p.weight+"kg";
		String height = "Height: "+p.height+" cm";
		
		String information = personalInfo+"\n"+name+"\n"+gender+"\n"+age+"\n"+dni+"\n"+weight+"\n"+height; //Join the previous Strings in one separating each one with a new line
		return information; //Return the total information
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		final int NUMBER_OF_PERSONS = 3; //Set the total number of people to print it information
		Person []people = new Person[NUMBER_OF_PERSONS]; //Create an array which store each person		
		for (int ii=0;ii<people.length;ii++){ 
			people[ii] = new Person(); //Store a person in the actual position of the array
			if (ii<2){
				System.out.println("Introduce the name: ");
				setName(people[ii], sc.next()); //Enter the name of the person
				System.out.println("Introduce the age: ");
				setAge(people[ii], sc.nextInt()); //Enter the age of the person
				System.out.println("Introduce the dni: ");
				setDni(people[ii], sc.nextInt()); //Enter the dni and calculate the letter for that number
				if (ii<1){ //Only the first person
					System.out.println("Introduce the sex: ");
					setGender(people[ii], sc.next().toUpperCase().charAt(0)); //Enter M or F and it transform into char and upper case(if not upper case). If the user enter a word it only chose the first element
					System.out.println("Introduce the weight (in kg): ");
					setWeight(people[ii], sc.nextDouble()); //Enter the weight of the person
					System.out.println("Introduce the height (in cms): ");
					setHeight(people[ii], sc.nextDouble()); //Enter the height of the person
				}
				else { //Only the second person
					setWeight(people[ii], 90); //Set the weight of the person to 90
					setHeight(people[ii], 185); //Set the height of the person to 185
				}
			}
			else { //All person afther the second
				setName(people[ii], "Adrian"); //Set the name of the person to Adrian
				setAge(people[ii], 18); //Set the age of the person to 18
				float dniNumber = 17878907.0F; //Store the dni number in a float(is out of the integer range)
				setDni(people[ii],(int)(dniNumber)); //Set the dni of the person to the dniNumber(converted into int) and calculate the nif letter
				setGender(people[ii],'M'); //Set the gender of the person to male
				setWeight(people[ii],63); //Set the weight of the perspn to 63
				setHeight(people[ii],168); //Set the height of the person to 168
			}
			System.out.println("Person"+(ii+1));
			System.out.println(printPerson(people[ii])); //Print the data of the person calling the function printPerson
			System.out.println();
		}
	}
}
	

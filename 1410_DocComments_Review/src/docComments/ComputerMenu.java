package docComments;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class ComputerMenu
 * Interactive menu to view all computers, delete, add, find, and view the amount of computers.
 * @author Landon Howa
 *
 */
public class ComputerMenu 
{
static Scanner input = new Scanner(System.in);

public static void main(String[] args)
{
int selection;
initializeArray();

do 
{
menuPrompt();
selection = input.nextInt();

switch (selection)
{
case 1:
displayComputers();
break;

case 2:
addComputer();
break;

case 3:
findComputer();
break;

case 4:
deleteComputer();
break;

case 5:
amountComputers();
break;

case 6: 
System.out.println("\nGoodbye\n");
break;

default:
System.out.println("\nEnter a selection 1-6");
break;
}
}while (selection != 6);
}
//array list
static ArrayList<Computer> computerList = new ArrayList<Computer>();

/**
* Initializes array list computerList with preset values
 * @return 
* 
* 
*/
private static void initializeArray()
{
computerList.add(new Computer(8, 500, "i5", Computer.getId()));
computerList.add(new Computer(16, 1024, "i7", Computer.getId()));
computerList.add(new Computer(32, 2048, "i9", Computer.getId()));
computerList.add(new Computer(64, 256, "i3", Computer.getId()));
}

/**
* Displays a menu for user to explore computer devices
* 
* 
*/
private static void menuPrompt() 
{
System.out.println("\nMake your selection");
System.out.println("1. Show all Computers");
System.out.println("2. Add a Computer");
System.out.println("3. Find a Computer");
System.out.println("4. Delete a Computer");
System.out.println("5. Number of Computers");
System.out.println("6. Exit");
System.out.print("Enter your selection: ");
}

/**
* Displays the computers in the Array List: computerList
* 
* 
*/
private static void displayComputers()
{
System.out.println();
for (int i = 0; i < computerList.size(); i++)
{
Computer myComputer = computerList.get(i); 
System.out.println(myComputer);
}
}

/**
* Adds a computer to the Array List: computerList
* Allows user to specify storage space, RAM size, and processor
* 
*/
private static void addComputer()
{
System.out.print("\nEnter Storage Space: ");
int storage = input.nextInt();
System.out.print("Enter RAM Amount: ");
int ram = input.nextInt();
System.out.print("Enter Processor Type: ");
input.nextLine();
String processor = input.nextLine();
computerList.add(new Computer(ram, storage, processor, Computer.getId()));
}
/**
* Finds a computer by comparing the ID chosen by user.
* 
*/
private static void findComputer()
{

	System.out.println("Please enter an ID: ");
	int findID = input.nextInt();
	for(int i = 0; i < computerList.size(); i++) {
		int compID = Computer.getId();
	if(compID == findID){
	System.out.println(computerList.get(i));
	}else{
		System.out.println("ID: " + findID + " was not found.");//end if
	}
	}//end I forLoop

}
/**
* Finds a computer by comparing the ID chosen by user, and deletes it from the ArrayList.
* 
*/
private static void deleteComputer()
{
	System.out.println("Please enter an ID to delete:  ");
	int deleteID = input.nextInt();
	for(int i = 0; i < computerList.size(); i++) {
		int compID = Computer.getId();
	if(compID == deleteID){
		computerList.remove(i);
	System.out.println("ID: " + deleteID + " was deleted.");
	}else{
		System.out.println("ID: " + deleteID + " was not found.");//end if
	}//end if
	}//end I forLoop
}

/**
* Displays the number of computers in the Array List: computerList
* 
* 
*/
private static void amountComputers()
{
System.out.printf("%nNumber of Computers: %d %n", computerList.size());
}

}



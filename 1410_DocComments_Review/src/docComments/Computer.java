package docComments;

/**
* Class Computers, contains the constructor, toString, and getters.
* @author Landon Howa
*
*/
public class Computer {
private int ram;
private int storage;
private String processor;
int id;
private static int count = 2986342;

/**
* Constructor for class Computer. Passed the Ram, Storage, Processor, and creates the next ID.
* @param ram The amount of RAM.
* @param storage The amount of Storage.
* @param processor The Processor to add.
* @param id The ID for the given unit.
*/
public Computer(int ram, int storage, String processor, int id) {
this.ram = ram;
this.storage = storage;
this.processor = processor;
this.id = count++; 
}
/**
* Returns the amount ram.
* @return the ram
*/
public int getRam() {
return ram;
}
/**
* Returns the storage space.
* @return the storage
*/
public int getStorage() {
return storage;
}
/**
* Returns the processor type.
* @return the processor
*/
public String getProcessor() {
return processor;
}
/**
* Returns the Count. 
* @return the id
*/
public static int getId() {
return count;
//This should return the ID, However, due to the static nature of the ComputersMenu passing an int that is not
//static errors out the program. Because we are returning the count we are unable to effectively query the object to get the ID.
}

/* (non-JavaDoc)
* Returns in the order: ID, Storage, Processor, RAM.
* @see java.lanf.Object#toString()
*/
@Override
public String toString() {
return "Stored Computers\nid: " + id + ", Storage amount: " + storage + "gb's, Processor: " + processor + ", amount of ram: " + ram + "gb's.";
}

}
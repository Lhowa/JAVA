package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Set;



/**
 * LabSerialization demonstrates how to serialize and deserialize
 * a custom object that references other objects on the heap.
 * Author(s): Starter Code + ........... // fill in your name
 */
public class LabSerialization {
    public static void main(String[] args) {
    	String file = "src/labSerialization/Demo.ser";
        ListVsSetDemo demo = new ListVsSetDemo(
        		
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

//                displayListAndSet(demo);
              
            	serialize(demo, file);
            	ListVsSetDemo newDemo = deserialize(file);
            	displayListAndSet(newDemo);
            	System.out.println("Done...");
               

    }

    /**
     * Serializes the pass information to the filepath given
     * @param ListVsSetDemo
     * @param filepath to serialize to.
     */
	private static void serialize(ListVsSetDemo demo, String filename) {
		try(ObjectOutputStream serializer =
				new ObjectOutputStream(new FileOutputStream(filename))){
			serializer.writeObject(demo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	/**
	 * Reads from the file at the filepath and deserializes the object.
	 * @param filepath to serialize to.
	 * @return's the List vs Set output.
	 */
	private static ListVsSetDemo deserialize(String filename) {
		Object newListVsSetDemo= null;
		try(ObjectInputStream deserializer =
				new ObjectInputStream(new FileInputStream(filename))){
			newListVsSetDemo = deserializer.readObject();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (ListVsSetDemo) newListVsSetDemo;
	}

    /**
     * Displays the elements of the list and the set.
     */
    private static void displayListAndSet(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }

}

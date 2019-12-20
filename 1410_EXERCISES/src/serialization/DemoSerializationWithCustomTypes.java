package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demonstrates how to serialize and deserialize custom types
 * as they are used in a collection
 * @author landonhowa
 *
 */
public class DemoSerializationWithCustomTypes {

	public static void main(String[] args) {
		String file = "src/serialization/BinaryFiles/Triangles.ser";
		
		List<EquilateralTriangle> triangles = new ArrayList<>();
		Collections.addAll(triangles, new EquilateralTriangle(3),
			new EquilateralTriangle(5),new EquilateralTriangle(7),
			new EquilateralTriangle(9),new EquilateralTriangle(11));
		System.out.println("Original triangles: " + triangles);

		//serialize
		try(ObjectOutputStream serializer =
				new ObjectOutputStream(new FileOutputStream(file))){
			serializer.writeObject(triangles);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//modify list to prove serialization
		triangles.removeIf(t -> t.getSide()<= 5);
		System.out.println("Modified triangles: " + triangles);
		
		//deserialize
		triangles = deserializeTriangles(file);
		System.out.println("Deserialized triangles: " + triangles);
		
		System.out.println("Done...");
	}

	@SuppressWarnings("unchecked")
	private static List<EquilateralTriangle> deserializeTriangles(String file) {
		List<EquilateralTriangle> triangleList = null;
		try(ObjectInputStream deserializer =
				new ObjectInputStream(new FileInputStream(file))){
			triangleList = (List<EquilateralTriangle>) deserializer.readObject();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return triangleList;
	}

}

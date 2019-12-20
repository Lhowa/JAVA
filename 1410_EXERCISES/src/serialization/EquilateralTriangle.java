package serialization;

import java.io.Serializable;

/**
 * Represents a equilateral triangle.
 * @author landonhowa
 *
 */
public class EquilateralTriangle implements Serializable{
	/**
	 * Version 1.0
	 */
	private static final long serialVersionUID = 1781745776982414870L;
	private int side;

	/**
	 * creates a new equilateral triangle 
	 * @param side the side length of the triangle.
	 */
	public EquilateralTriangle(int side) {
		this.side = side;
	}

	/**
	 * @return the side
	 */
	public int getSide() {
		return side;
	}

	@Override
	public String toString() {
		return "/" + side + "\\";
	}
	
		
}

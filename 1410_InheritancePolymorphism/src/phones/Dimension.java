package phones;
/**
 * Class Dimension, used to house the dimensions of the phone.
 * @author landonhowa
 *
 */
public class Dimension {
	private double height;
	private double width;
	private double depth;
	
	/**
	 * @param height of the phone.
	 * @param width of the phone.
	 * @param depth of the phone.
	 */
	public Dimension(double height, double width, double depth) {
		if(height >= 1 || width >= 1 || depth >= 1) {
			this.height = height;
			this.width = width;
			this.depth = depth;
		}else {
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		}
		
	}

	/**
	 * @return the height of the phone.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return the width of the phone.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the depth of the phone.
	 */
	public double getDepth() {
		return depth;
	}
	/**
	 * toString returns in format (HeightxWidthxDepth)
	 */
	@Override
	public String toString() {
		return "(" + height + " x " + width + " x " + depth + ")";
	}
	
	
	
}

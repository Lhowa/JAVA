package labCollection;

import java.awt.Color;

/**
 * Class Couch. This class contains
 * the constructor for a Couch, also 
 * contained is the getters, toString,
 * and overridden equals().
 *  * @author landonhowa
 *
 */
public class Couch {
	java.awt.Color color;
	Material material;
	
	/**
	 * @param color of the couch. Colors are created in Class CouchApp.
	 * @param material from Class Material's enum.
	 */
	public Couch(Color color, Material material) {
		this.color = color;
		this.material = material;
	}

	/**
	 * @return the color selected in CouchApp
	 */
	public java.awt.Color getColor() {
		return color;
	}

	/**
	 * @return the material fabric from Material.
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * Two couches are the same if both the
	 * material and color are the same.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couch other = (Couch) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material != other.material)
			return false;
		return true;
	}

	/*
	 * Prints the following:
	 * Couch: {Hash Value of The couch Color} {The Material Name in lowercase}.
	 */
	@Override
	public String toString() {
		String hash = String.format("#%06x", color.getRGB() & 0x00FFFFFF);
		return "Couch: " + hash + " " + material.name().toLowerCase();
	}
	
	
}

package nuisance;
/**
 * Class Person, contains the constructor and getters
 * for the Person class.
 * @author landonhowa
 *
 */
public class Person {

	private String name;
	private int age;
	
	/**
	 * Person Constructor, requires the name and the
	 * age of the person to be added.
	 * @param name of the Person
	 * @param age of the Person
	 */
	public Person(String name, int age) {
		this.name = name;
		if (age >= 1 && age <= 150) {
			this.age = age;
		}else {
			throw new IllegalArgumentException("Age needs to be from the range of 1-150");
		}
	}

	/**
	 * @return the name of the Person
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age of the Person
	 */
	public int getAge() {
		return age;
	}

	/**
	 * toString() returns in the following format:
	 * {name}({age})
	 */
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}

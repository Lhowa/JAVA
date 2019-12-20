package nuisance;
/**
 * Class Friend, this class builds off of Person.
 * The constructor and additional methods for Friend
 * are located here.
 * @author landonhowa
 *
 */
public class Friend extends Person{

	private Hobby hobby;

	/**
	 * Creates new friend w/ {name}{age}{hobby}
	 * Hobbies to choose from include:
	 * MUSIC, SPORTS, GAMES
	 * @param name
	 * @param age
	 * @param hobby
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		this.hobby = hobby;
	}
	
	/**
	 * method chill(), returns the following:
	 * {name} is chilling
	 * @return
	 */
	public String chill() {
		return getName() + " is chilling";
	}
	
	/**
	 * method Play(), this returns one of the following:
	 * 1 friend: playing {hobby} with {name}
	 * 2 friends: playing {hobby} with {firend1} and {friend2}
	 * 3+ friends playing {hobby} with {firend1}, {friend2},..., and {friendn}
	 * @param friends
	 * @return
	 */
	public String play(Friend[] friends) {
		if(friends.length == 1) {
			return "playing " + hobby + " with " + getName();
		}else if (friends.length == 2) {
			return "playing " + hobby + " with " + friends[0].getName() + " and " + friends[1].getName();
		}else if (friends.length > 2) {
			System.out.print("playing " + hobby + " with ");
			for (int i = 0; i == friends.length-2; i++) {
				System.out.print(friends[i].getName() + ", ");
			}return "and " + friends[-1].getName();
		}else {
			return "playing " + hobby;
		}
	}

	/**
	 * toString() returns in the following format:
	 * {name}({age}) {hobby}
	 */
	@Override
	public String toString() {
		return super.toString() + " " + hobby;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getAge();
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = super.hashCode();
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		if (hobby != other.hobby)
			return false;
		if (getAge() != other.getAge())
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}
	
	
	
}

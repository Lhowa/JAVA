package labPolymorphism;

public class Dog
{
    private final String breed;

    public Dog(String b)
    {
        breed = b;
    }

    public void communicate()
    {
        System.out.println("bark bark");
    }

    public void move()
    {
        System.out.println("run");
    }

    public String getBreed()
    {
        return breed;
    }
    
    /**
     * Returns a toString of the Class and the breed.
     * Format: {name of the class}: {breed}
     */
    @Override
    public String toString() {
    	return this.getClass().getSimpleName() + ": " + breed;
    }
}

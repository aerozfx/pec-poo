
/**
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public abstract class Persona
{
    private String name;
    private String lastName;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String givenName, String givenSurname)
    {
        this.name = givenName;
        this.lastName = givenSurname;
    }

    /**
     * 
     * 
     * @return     the full name of a given person
     */
    public String getFullName()
    {
        return this.name + " " + this.lastName;
    }
    
    public String getName() 
    {
        return this.name;
    }
    
    public String getLastName() 
    {
        return this.lastName;
    }
}

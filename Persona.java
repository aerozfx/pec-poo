
/**
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public abstract class Persona
{
    private String name;
    private String surname;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String givenName, String givenSurname)
    {
        name = givenName;
        surname = givenSurname;
    }

    /**
     * 
     * 
     * @return     the full name of a given person
     */
    public String getFullName()
    {
        return name + " " + surname;
    }
}

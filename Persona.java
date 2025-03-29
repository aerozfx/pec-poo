
/**
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public class Persona
{
    private String dni;
    private String name;
    private String lastName;
    private int coordinateX;
    private int coordinateY;
    /**
     * Constructor for objects of class Persona
     */
    public Persona(String dni, String givenName, String givenSurname)
    {
        this.dni = dni;
        this.name = givenName;
        this.lastName = givenSurname;
        this.coordinateX = 0; // TODO: Hacer coordenadas aleatorias
        this.coordinateY = 0; // TODO: Hacer coordenadas aleatorias
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
    
    public String getDni() {
        return this.dni;
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


/**
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public class Persona
{
    private String dni;
    private String nombre;
    private String apellido;
    private int coordenadaX;
    private int coordenadaY;
    /**
     * Constructor for objects of class Persona
     */
    public Persona(String dni, String nombre, String apellido)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.coordenadaX = 0; // TODO: Hacer coordenadas aleatorias
        this.coordenadaY = 0; // TODO: Hacer coordenadas aleatorias
    }

    /**
     * 
     * @return el nombre completo de la persona
     */
    public String obtenerNombreCompleto()
    {
        return this.nombre + " " + this.apellido;
    }
    
    public String obtenerDni() {
        return this.dni;
    }

    public String obtenerNombre() 
    {
        return this.nombre;
    }
    
    public String obtenerApellido() 
    {
        return this.apellido;
    }
}

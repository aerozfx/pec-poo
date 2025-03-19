
/**
 * Esta es la clase base de Trabajador.
 * 
 * @author (Fernando Mariño) 
 * @version (19/03/2025)
 */
public abstract class Trabajador extends Persona
{
    /**
     * Constructor for objects of class Funcionario
     */
    public Trabajador(String name, String surname)
    {
        // initialise instance variables
        super(name, surname);
    }
    public abstract EnumTrabajadorRol getRole();
}

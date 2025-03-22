
/**
 * Esta es la clase base de Trabajador.
 * 
 * @author (Fernando Mariño) 
 * @version (19/03/2025)
 */
public abstract class Trabajador extends Persona
{
    private EnumTrabajadorRol position;
    /**
     * Constructor for objects of class Funcionario
     */
    public Trabajador(String name, String surname, EnumTrabajadorRol role)
    {
        // initialise instance variables
        super(name, surname);
        this.position = role;
    }
    public EnumTrabajadorRol getRole() {
        return this.position;
    }
}

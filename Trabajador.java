
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
    public Trabajador(Persona person, EnumTrabajadorRol role)
    {
        // initialise instance variables
        super(person.getDni(), person.getName(), person.getLastName());
        this.position = role;
    }
    public EnumTrabajadorRol getRole() {
        return this.position;
    }
}

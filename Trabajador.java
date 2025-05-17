
/**
 * Esta es la clase base de Trabajador.
 * 
 * @author (Fernando Mariño) 
 * @version (19/03/2025)
 */
public abstract class Trabajador extends Persona
{
    private RolTrabajador rol;
    /**
     * Constructor for objects of class Funcionario
     */
    public Trabajador(Persona person, RolTrabajador rol)
    {
        // initialise instance variables
        super(person.obtenerDni(), person.obtenerNombre(), person.obtenerNombreCompleto());
        this.rol = rol;
    }
    public RolTrabajador obtenerRol() {
        return this.rol;
    }
    
    public void obtenerInformacion() {
        System.out.println("DNI: " + this.obtenerDni() + "\n"+ this.obtenerNombreCompleto() + "\n" + this.obtenerRol());
    }
}

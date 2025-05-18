import java.util.Collection;
/**
 * Write a description of class TrabajadorModelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrabajadorModelo extends TrabajadorRepositorio
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TrabajadorModelo
     */
    public TrabajadorModelo()
    {
        // initialise instance variables
        x = 0;
    }

    public void borrarTodosLosTrabajadores() {
        this.trabajadores.clear();
    }
    
    public Collection<Trabajador> obtenerTrabajadores() {
        return this.trabajadores.values();
    }
}

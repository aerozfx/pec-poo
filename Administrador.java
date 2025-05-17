import java.util.HashMap;
import java.util.Collection;
/**
 * Write a description of class SystemAdministratorWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrador extends Trabajador
{
    // instance variables - replace the example below with your own
    /**
     * Constructor para los objetos de la clase Administrador
     */
    public Administrador(Persona persona)
    {
       super(persona, RolTrabajador.ADMINISTRADOR);
    }
}

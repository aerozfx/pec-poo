
/**
 * Write a description of class MaintainerWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EncargadoDeMantenimiento extends Trabajador
{
    /**
     * Constructor for objects of class EncargadoDeMantenimiento
     */
    public EncargadoDeMantenimiento(Persona person)
    {
       super(person, RolTrabajador.ENCARGADO_DE_MANTENIMIENTO);
    }
}

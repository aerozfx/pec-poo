
/**
 * Write a description of class SystemAdministratorWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SystemAdministratorWorker extends Trabajador
{
    // instance variables - replace the example below with your own
    private EnumTrabajadorRol role;

    /**
     * Constructor for objects of class SystemAdministratorWorker
     */
    public SystemAdministratorWorker(String name, String surname, EnumTrabajadorRol givenRole)
    {
       super(name, surname);
       role = givenRole;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public EnumTrabajadorRol getRole()
    {
        return this.role;
    }
}

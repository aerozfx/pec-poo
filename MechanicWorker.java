
/**
 * Write a description of class MechanicWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MechanicWorker extends Trabajador
{
    // instance variables - replace the example below with your own
    private EnumTrabajadorRol role;

    /**
     * Constructor for objects of class MechanicWorker
     */
    public MechanicWorker(String name, String surname, EnumTrabajadorRol givenRole)
    {
       super(name, surname);
       if(!givenRole.equals(EnumTrabajadorRol.MECHANIC))
       {
           throw new Error("MechanicWorker can't be instanciated as " + givenRole);
       }
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
        return role;
    }
}

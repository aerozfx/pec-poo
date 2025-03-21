/**
 * Write a description of class movilidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class movilidad
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class movilidad
     */
    public movilidad() {}
    public static void main(String args[]) {
        Administrador admin = new Administrador("Super", "Admin");
        admin.createUser(new CreatableUsuario("Fernando", "Mariño", "aerozedits@gmail.com", EnumUsuarioRol.REGULAR));
    }
}

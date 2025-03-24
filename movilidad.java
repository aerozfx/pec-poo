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
        GestionSistema sistema = new GestionSistema();
        GestionSistema sistema2 = new GestionSistema();
        Persona adminPerson = new Persona("01231231A", "Super", "Admin");
        Administrador admin = new Administrador(adminPerson);
        Persona userPerson = new Persona("01231231C", "Fernando", "Mariño");
        admin.createUser(new CreatableUsuario(userPerson, "aerozedits@gmail.com", EnumUsuarioRol.REGULAR));
    }
}

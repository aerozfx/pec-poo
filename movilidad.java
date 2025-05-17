/**
 * Write a description of class movilidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movilidad
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class movilidad
     */
    public Movilidad() {}
    public static void main(String args[]) {
        Ciudad city = new Ciudad(100);
        Persona adminPerson = new Persona("01231231A", "Super", "Admin");
        Administrador admin = new Administrador(adminPerson);
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(admin, new UsuarioRepositorio(), new TrabajadorRepositorio());
        Persona userPerson = new Persona("01231231C", "Fernando", "Mariño");
        controladorAdministrador.crearUsuario(new Usuario(userPerson, "aerozedits@gmail.com", RolUsuario.ESTANDAR));
    }
}


/**
 * Write a description of class CreatableUsuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatableUsuario extends Usuario
{
    private String name;
    private String lastName;
    private String role;
    
    public CreatableUsuario(String name, String lastName, String email, EnumUsuarioRol role) {
        super(name, lastName, email, role);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLastName() {
        return this.lastName;
    }
}

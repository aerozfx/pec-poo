
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
    
    public CreatableUsuario(Persona person, String email, EnumUsuarioRol role) {
        super(person, email, role);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLastName() {
        return this.lastName;
    }
}

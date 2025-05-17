import java.util.Collection;


/**
 * Write a description of class ControladorUsuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControladorUsuario
{
    // instance variables - replace the example below with your own
    private UsuarioRepositorio usuarioRepositorio = null;

    /**
     * Constructor for objects of class ControladorUsuario
     */
    public ControladorUsuario(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    
        /**
     * Edita un usuario
     * @param String dni DNI del usuario a actualizar
     * @param Usuario usuario Nuevos datos del usuario
     * @return Usuario Usuario editado
     */
    public Usuario editarUsuario(String dni, Usuario usuario) {
        return this.usuarioRepositorio.editarUsuario(dni, usuario);
    }
    
    public void eliminarUsuario(String dni) {
        this.usuarioRepositorio.borrarUsuario(dni);
    }
    
    public Usuario obtenerUsuarioPorDni(String dni) {
        return this.usuarioRepositorio.obtenerUsuario(dni);
    }
    
    public Collection<Usuario> obtenerUsuarios() {
        return this.usuarioRepositorio.obtenerUsuarios();
    }
}

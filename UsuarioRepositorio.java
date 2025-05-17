import java.util.HashMap;
/**
 * Write a description of class UsuarioRepositorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsuarioRepositorio
{
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
    private UsuarioRepositorio instance = null;
    /**
     * Constructor para los objetos de UsuarioRepositorio
     */
    public UsuarioRepositorio UsuarioRepositorio() {
        if (this.instance == null) {
            this.instance = new UsuarioRepositorio();
        }
        return this.instance;
    }

    /**
     * Este método obtiene un Usuario almacenado en memoria, si es que existe, en caso contrario devuelve un error
     * @param String dni -> DNI usado para filtrar el usuario
     * @return El usuario encontrado, lanza una excepción en caso contrario
     */
    public Usuario obtenerUsuario(String dni) {
        if (!this.existeUsuario(dni)) {
            throw new Error("No existe el usuario con el DNI: " + dni);
        }
        Usuario usuarioEncontrado = this.usuarios.get(dni);
        return usuarioEncontrado;
    }
    
    public Usuario editarUsuario(String dni, Usuario nuevoUsuario) {
        if (!this.existeUsuario(dni)) {
            throw new Error("No existe el usuario con el DNI: " + dni);
        };
        this.usuarios.replace(dni, nuevoUsuario);
        return this.obtenerUsuario(dni);
    }
    
    public void borrarUsuario(String dni) {
        if(!this.existeUsuario(dni)) {
            throw new Error("No existe el usuario con el DNI: " + dni);
        }
        this.usuarios.remove(dni);
    }
    
    public Usuario crearUsuario(Usuario usuario) {
        String dni = usuario.obtenerDni();
        String nombre = usuario.obtenerNombre();
        String apellido = usuario.obtenerApellido();
        String email = usuario.obtenerCorreo();
        RolUsuario rolAsignado = usuario.obtenerRol();
        if(this.existeUsuario(dni)) {
            throw new Error("El DNI " + dni + " ya está registrado, por favor, inténtalo con otro.");
        }
        this.usuarios.put(dni, new Usuario(new Persona(dni, nombre, apellido), email, rolAsignado));
        return this.obtenerUsuario(dni);
    }
    
    public void borrarTodosLosUsuarios() {
        this.usuarios.clear();
    }    

    private boolean existeUsuario(String dni) {
        Usuario usuarioEncontrado = this.usuarios.get(dni);
        return usuarioEncontrado != null;
    }
}

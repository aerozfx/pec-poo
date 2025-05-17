import java.util.Collection;

/**
 * Write a description of class ControladorAdministrador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControladorAdministrador
{
    // instance variables - replace the example below with your own
    private UsuarioRepositorio usuarioRepositorio = null;
    private TrabajadorRepositorio trabajadorRepositorio = null;
    private VehiculoRepositorio vehiculoRepositorio = null;
    
    /**
     * Constructor for objects of class ControladorAdministrador
     */
    public ControladorAdministrador(Administrador administrador, UsuarioRepositorio usuarioRepositorio, TrabajadorRepositorio trabajadorRepositorio, VehiculoRepositorio vehiculoRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.trabajadorRepositorio = trabajadorRepositorio;
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    /**
     * Crea un usuario
     */
    public Usuario crearUsuario(Usuario usuario) {
        return this.usuarioRepositorio.crearUsuario(usuario);
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

    public Collection<Trabajador> obtenerTrabajadores() {
        return this.trabajadorRepositorio.obtenerTrabajadores();
    }
    
    public Collection<Vehiculo> obtenerVehiculos() {
        return this.vehiculoRepositorio.obtenerVehiculos();
    }
    
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return this.trabajadorRepositorio.crearTrabajador(trabajador);
    }
    
    public Trabajador editarTrabajador(String dni, Trabajador nuevoTrabajador) {
        return this.trabajadorRepositorio.editarTrabajador(dni, nuevoTrabajador);
    }
    
    public void eliminarTrabajador(String dni) {
        this.trabajadorRepositorio.borrarTrabajador(dni);
    }
    
    public Trabajador obtenerTrabajadorPorDni(String dni) {
        return this.trabajadorRepositorio.obtenerTrabajador(dni);
    }
    
    // Métodos útiles
    
    public void eliminarTodo() {
        this.usuarioRepositorio.borrarTodosLosUsuarios();
        this.trabajadorRepositorio.borrarTodosLosTrabajadores();
    }
}

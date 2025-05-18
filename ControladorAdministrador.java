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
    private UsuarioModelo usuarioModelo = null;
    private TrabajadorModelo trabajadorModelo = null;
    private VehiculoModelo vehiculoModelo = null;
    private EstacionBaseModelo estacionBaseModelo = null;
    
    /**
     * Constructor for objects of class ControladorAdministrador
     */
    public ControladorAdministrador(Administrador administrador, UsuarioModelo usuarioModelo, TrabajadorModelo trabajadorModelo, VehiculoModelo vehiculoModelo, EstacionBaseModelo estacionBaseModelo) {
        this.usuarioModelo = usuarioModelo;
        this.trabajadorModelo = trabajadorModelo;
        this.vehiculoModelo = vehiculoModelo;
        this.estacionBaseModelo = estacionBaseModelo;
    }

    /**
     * Crea un usuario
     */
    public Usuario crearUsuario(Usuario usuario) {
        return this.usuarioModelo.crearUsuario(usuario);
    }
    
    /**
     * Edita un usuario
     * @param String dni DNI del usuario a actualizar
     * @param Usuario usuario Nuevos datos del usuario
     * @return Usuario Usuario editado
     */
    public Usuario editarUsuario(String dni, Usuario usuario) {
        return this.usuarioModelo.editarUsuario(dni, usuario);
    }
    
    public void eliminarUsuario(String dni) {
        this.usuarioModelo.borrarUsuario(dni);
    }
    
    public Usuario obtenerUsuarioPorDni(String dni) {
        return this.usuarioModelo.obtenerUsuario(dni);
    }
    
    public Collection<Usuario> obtenerUsuarios() {
        return this.usuarioModelo.obtenerUsuarios();
    }

    public Collection<Trabajador> obtenerTrabajadores() {
        return this.trabajadorModelo.obtenerTrabajadores();
    }
    
    public Collection<Vehiculo> obtenerVehiculos() {
        return this.vehiculoModelo.obtenerVehiculos();
    }
    
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return this.trabajadorModelo.crearTrabajador(trabajador);
    }
    
    public Trabajador editarTrabajador(String dni, Trabajador nuevoTrabajador) {
        return this.trabajadorModelo.editarTrabajador(dni, nuevoTrabajador);
    }
    
    public void eliminarTrabajador(String dni) {
        this.trabajadorModelo.borrarTrabajador(dni);
    }
    
    public Trabajador obtenerTrabajadorPorDni(String dni) {
        return this.trabajadorModelo.obtenerTrabajador(dni);
    }
    
    public EstacionBase obtenerEstacionBase(String nombreBase) {
        return this.estacionBaseModelo.obtenerEstacionBase(nombreBase);
    }
    
    public Collection<EstacionBase> obtenerEstacionesBase() {
        return this.estacionBaseModelo.obtenerEstacionesBase();
    }
    
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return this.vehiculoModelo.crearVehiculo(vehiculo.obtenerMatricula(), vehiculo.obtenerTipoVehiculo(), vehiculo.obtenerEstacionAsignada());
    }
    
    public Vehiculo editarVehiculo(String matricula, Vehiculo vehiculoEditado) {
        return this.vehiculoModelo.editarVehiculo(matricula, vehiculoEditado);
    }
    
    public void eliminarVehiculo(String matricula) {
        this.vehiculoModelo.borrarVehiculo(matricula);
    }
    
    public EstacionBase crearEstacionBase(EstacionBase estacionBase) {
         return this.estacionBaseModelo.crearEstacionBase(estacionBase);    
    }
    
    // Métodos útiles para testing
    
    public void eliminarTodo() {
        this.usuarioModelo.borrarTodosLosUsuarios();
        this.trabajadorModelo.borrarTodosLosTrabajadores();
    }
}

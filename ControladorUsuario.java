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
    private UsuarioModelo usuarioModelo = null;
    private VehiculoModelo vehiculoModelo = null;

    /**
     * Constructor for objects of class ControladorUsuario
     */
    public ControladorUsuario(UsuarioModelo usuarioModelo, VehiculoModelo vehiculoModelo)
    {
        this.usuarioModelo = usuarioModelo;
        this.vehiculoModelo = vehiculoModelo;
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
    
    public Collection<Vehiculo> obtenerVehiculos() {
        return this.vehiculoModelo.obtenerVehiculos();
    }
    
    public void listarVehiculosDisponibles() {
        Collection<Vehiculo> vehiculos = this.vehiculoModelo.obtenerVehiculosDisponibles();
        for(Vehiculo vehiculo: vehiculos) {
            vehiculo.obtenerInformacion();
        }
    }
    
    public void listarVehiculosCercanos(Usuario usuario) {
        Collection<Vehiculo> vehiculos = this.vehiculoModelo.obtenerVehiculosDisponibles();
        for(Vehiculo vehiculo: vehiculos) {
            if(usuario.)
        }
    }
}

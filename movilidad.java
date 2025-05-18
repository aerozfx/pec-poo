/**
 * Write a description of class movilidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movilidad
{
    // instance variables - replace the example below with your own
    private static Administrador admin;
    private static UsuarioModelo usuarioModelo = new UsuarioModelo();
    private static VehiculoModelo vehiculoModelo = new VehiculoModelo();
    private static TrabajadorModelo trabajadorModelo = new TrabajadorModelo();
    private static EstacionBaseModelo estacionBaseModelo = new EstacionBaseModelo();
    private static ControladorAdministrador controladorAdministrador = new ControladorAdministrador(admin, usuarioModelo, trabajadorModelo, vehiculoModelo, estacionBaseModelo);
    private static ControladorUsuario controladorUsuario = new ControladorUsuario(usuarioModelo, vehiculoModelo);
    /**
     * Constructor for objects of class movilidad
     */
    public Movilidad() {}
    public static void main(String args[]) {
        popularMemoria();
        Ciudad city = new Ciudad(100);
        VistaUsuario vistaUsuario = new VistaUsuario(controladorUsuario);
        VistaSistema vistaSistema = new VistaSistema(new VistaAdministrador(controladorAdministrador), vistaUsuario);
        vistaSistema.mostrarMenuDeInicio();
    }
    
    /**
     * Este es un método usado para simular una "base de datos" con algunos usuarios y trabajadores creados de manera predeterminada
     */
    
    private static void popularMemoria() {
        Persona adminPerson = new Persona("01231231A", "Super", "Admin");
        Movilidad.admin = new Administrador(adminPerson);
        Persona userPerson = new Persona("01231231C", "Fernando", "Mariño");
        controladorAdministrador.crearTrabajador(admin);
        controladorAdministrador.crearUsuario(new Usuario(userPerson, "aerozedits@gmail.com", RolUsuario.ESTANDAR));
        EstacionBase estacionBase = new EstacionBase("Estacion 1", new Coordenadas(1, 1), 4);
        controladorAdministrador.crearEstacionBase(estacionBase);
        controladorAdministrador.crearVehiculo(new Vehiculo(TipoVehiculo.BICICLETA,"aada123", estacionBase));
    }
}

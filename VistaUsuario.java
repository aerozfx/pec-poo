import java.util.Collection;
import java.util.Scanner;

/**
 * Write a description of class VistaUsuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VistaUsuario
{
    // instance variables - replace the example below with your own
    ControladorUsuario controladorUsuario = null;
    private Scanner sc = new Scanner(System.in);
    private boolean vistaCerrada = false;
    /**
     * Constructor for objects of class VistaUsuario
     */
    public VistaUsuario(ControladorUsuario controladorUsuario)
    {
        // initialise instance variables
        this.controladorUsuario = controladorUsuario;
    }
    
    public void iniciarVista() {
        this.mostrarMensajeBienvenida();
        while(!vistaCerrada) {
            this.listarOpciones();
        }
    }
    
    private void listarOpciones() {
        Usuario usuarioEncontrado = this.seleccionarUsuario();
        this.log("1) Consultar vehículos disponibles");
        this.log("2) Consultar vehículo más cercano");
        this.log("3) Alquilar vehículo");
        this.log("4) Consultar saldo");
        this.log("5) Recargar saldo");
        this.log("6) Reportar incidente");
        this.log("7) Listar viajes");
        this.log("8) ");
    }
    
    private void log(String mensaje) {
        System.out.println(mensaje);
    }
    
    private void listarUsuarios() {
        Collection<Usuario> usuarios = this.controladorUsuario.obtenerUsuarios();
        for(Usuario usuario: usuarios){
            usuario.obtenerInformacion();
        }
    }
    
    private void mostrarMensajeBienvenida() {
        this.log("Este es el panel del usuario");
        this.log("Antes de nada, selecciona un usuario");
        this.listarUsuarios();
    }
    
    private Usuario seleccionarUsuario() {
        String dni = sc.nextLine();
        Usuario usuarioEncontrado = this.controladorUsuario.obtenerUsuarioPorDni(dni);
        while(usuarioEncontrado == null) {
            this.log("Ese usuario no existe");
            this.log("Por favor, selecciona un usuario que exista!");
            String nuevoDni = sc.nextLine();
            usuarioEncontrado = this.controladorUsuario.obtenerUsuarioPorDni(nuevoDni);
        }
        return usuarioEncontrado;
    }
}

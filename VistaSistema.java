import java.util.Scanner;
/**
 * Write a description of class VistaSistema here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VistaSistema
{
    Scanner sc = new Scanner(System.in);
    private boolean cerrarProceso = false;
    private VistaAdministrador vistaAdministrador = null;
    private VistaUsuario vistaUsuario = null;

    /**
     * Constructor for objects of class VistaSistema
     */
    public VistaSistema(VistaAdministrador vistaAdministrador, VistaUsuario vistaUsuario)
    {
        this.vistaAdministrador = vistaAdministrador;
        this.vistaUsuario = vistaUsuario;
        cerrarProceso = false;
    }

    public void mostrarMenuDeInicio() {
        if (cerrarProceso == true) cerrarProceso = false;
        this.log("Bienvenido/a al sistema de transporte personal");
        log("Selecciona la gestión que quieres realizar");
        while(!cerrarProceso) {
            listarOpciones();
            String opcion = sc.nextLine();
            switch(opcion) {
            case "1":
                vistaAdministrador.iniciarVista();
                break;
            case "2":
                vistaUsuario.iniciarVista();
                break;
            case "3":
                log("Gracias por usar el servicio");
                cerrarProceso = true;
                break;
            default:
                log("Esa opción no existe");
            }
        }
    }
    
    private static void log(String mensaje) {
        System.out.println(mensaje);
    }
    
    private static void listarOpciones() {
        log("1) Acceder vista administrador");
        log("2) Acceder a la lista de clientes");
        log("3) Salir");
    }
}

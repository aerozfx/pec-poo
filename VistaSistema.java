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
    boolean cerrarProceso = false;

    /**
     * Constructor for objects of class VistaSistema
     */
    public VistaSistema()
    {
    }

    public void mostrarMenuDeInicio() {
        this.log("Bienvenido/a al sistema de transporte personal");
        this.log("Selecciona la gestión que quieres realizar");
        while(!this.cerrarProceso) {
            this.listarOpciones();
        }
        String opcion = sc.nextLine();
        switch(opcion) {
            case "1":
                this.log("Esto lleva al menu admin");
                break;
            case "2":
                this.log("Esto lleva a la vista clientes");
                break;
            case "3":
                this.log("Gracias por usar el servicio");
                this.cerrarProceso = true;
                break;
            default:
                this.log("Esa opción no existe");
        }
    }
    
    private void log(String mensaje) {
        System.out.println(mensaje);
    }
    
    private void listarOpciones() {
        this.log("1) Acceder vista administrador");
        this.log("2) Acceder a la lista de clientes");
        this.log("3) Salir");
    }
}

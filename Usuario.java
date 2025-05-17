import java.util.ArrayList;
/**
 * Clase que instanciará a los distintos usuarios de la plataforma.
 * 
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public class Usuario extends Persona
{
    private RolUsuario rol;
    private String id;
    private String email;
    private float saldo;
    private ArrayList<Viaje> viajes;
    /**
     * Constructor de la clase Usuario
     * 
     * @param  name   nombre del usuario a crear
     * @return     una instancia de la clase Usuario
     */
    public Usuario(Persona persona, String email, RolUsuario rol)
    {
        super(persona.obtenerDni(), persona.obtenerNombre(), persona.obtenerApellido());
        this.saldo = 0;
        this.email = email;
        this.rol = rol;
    }
    
    public void alquilarCoche(Vehiculo vehiculo) {}
    
    public void establecerSaldo(float nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
    
    public void consultarViajes() {
        if(this.viajes.isEmpty()) return;
        
        for(Viaje viaje: viajes) {
            viaje.imprimirDetalles();
        }
    }
    
    public void comprobarVehiculosCercanos() {
        if (this.viajes.isEmpty()) return;
        
        for(Viaje viaje: viajes) {
            viaje.imprimirDetalles();
        }
    }
    
    public int crearIncidente(String vehiclePlate, String title, String description) {
        System.out.println("This is not implemented!");
        return 0;
    }
    
    public String obtenerCorreo() {
        return this.email;
    }
    
    public RolUsuario obtenerRol() {
        return this.rol;
    }
    
    public void obtenerInformacion() {
        System.out.println("DNI: " + this.obtenerDni() + " - "+ this.obtenerNombreCompleto() + " - " + this.obtenerRol());
    }
}

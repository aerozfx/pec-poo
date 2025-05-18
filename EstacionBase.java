import java.util.HashMap;
/**
 * Write a description of class EstacionBase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstacionBase
{
    // instance variables - replace the example below with your own
    private Coordenadas coordenadas;
    private String nombreBase;
    private int huecosDisponibles;
    private HashMap<String, Vehiculo> vehiculosDisponibles = new HashMap<String, Vehiculo>();
    /**
     * Constructor for objects of class EstacionBase
     */
    public EstacionBase(String nombreBase, Coordenadas coordenadas, int huecosDisponibles)
    {
        this.coordenadas = coordenadas;
        this.huecosDisponibles = huecosDisponibles;
        this.nombreBase = nombreBase;
    }
    
    public Coordenadas obtenerPosicion() {
        return this.coordenadas;
    }
    
    public int agregarVehiculo(Vehiculo vehiculo) {
        if(vehiculosDisponibles.size() >= this.huecosDisponibles) {
            throw new Error("Todos los huecos están asginados. Inténtalo de nuevo más tarde");
        }
        
        if(vehiculosDisponibles.get(vehiculo.obtenerMatricula()) != null) {
            throw new Error("Este vehículo ya está registrado en esta estación");
        }
        this.vehiculosDisponibles.put(vehiculo.obtenerMatricula() ,vehiculo);
        return 1;
    }
    
    public HashMap<String, Vehiculo> obtenerVehiculosDisponibles() {
        return this.vehiculosDisponibles;
    }
    
    public String obtenerNombreEstacion() {
        return this.nombreBase;
    }
    
    public int obtenerHuecosDisponibles() {
        return this.huecosDisponibles;
    }
    
    public void obtenerInformacion() {
        System.out.println("Nombre estación: " + this.obtenerNombreEstacion() + " - Coordenadas: "+ this.obtenerPosicion() + " - Huecos disponibles: " + this.obtenerHuecosDisponibles());
    }
    
    public void extraerVehiculo(String matricula) {
        this.vehiculosDisponibles.remove(matricula);
    }
    
    
}

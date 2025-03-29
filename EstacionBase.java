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
    private int coordinateX;
    private int coordinateY;
    private String baseName;
    private int availableChargingLots;
    private HashMap<String, Vehiculo> vehiculosDisponibles = new HashMap<String, Vehiculo>();
    /**
     * Constructor for objects of class EstacionBase
     */
    public EstacionBase(String baseName, int coordinateX, int coordinateY, int availableChargingLots)
    {
        // initialise instance variables
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.availableChargingLots = availableChargingLots;
        this.baseName = baseName;
    }
    
    public int getCoordinateX() {
        return this.coordinateX;
    }
    
    public int getCoordinateY() {
        return this.coordinateY;
    }
    
    public int agregarVehiculo(Vehiculo vehiculo) {
        if(vehiculosDisponibles.size() >= this.availableChargingLots) {
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
    
    public void extraerVehiculo(String matricula) {
        this.vehiculosDisponibles.remove(matricula);
    }
}

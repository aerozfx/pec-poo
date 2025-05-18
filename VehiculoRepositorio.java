import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Write a description of class VehiculoRepositorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VehiculoRepositorio
{
    protected HashMap<String, Vehiculo> vehiculos = new HashMap<String, Vehiculo>();
    private VehiculoRepositorio instance = null;
    /**
     * Constructor para los objetos de VehiculoRepositorio
     */
    public VehiculoRepositorio VehiculoRepositorio() {
        if (this.instance == null) {
            this.instance = new VehiculoRepositorio();
        }
        return this.instance;
    }

    /**
     * Este método obtiene un Vehiculo almacenado en memoria, si es que existe, en caso contrario devuelve un error
     * @param String matricula -> matricula usado para filtrar el Vehiculo
     * @return El Vehiculo encontrado, lanza una excepción en caso contrario
     */
    public Vehiculo obtenerVehiculo(String matricula) {
        if (!this.existeVehiculo(matricula)) {
            throw new Error("No existe el Vehiculo con el matricula: " + matricula);
        }
        Vehiculo VehiculoEncontrado = this.vehiculos.get(matricula);
        return VehiculoEncontrado;
    }
    
    public Vehiculo editarVehiculo(String matricula, Vehiculo nuevoVehiculo) {
        if (!this.existeVehiculo(matricula)) {
            throw new Error("No existe el Vehiculo con el matricula: " + matricula);
        }
        Vehiculo VehiculoEncontrado = this.vehiculos.get(matricula);
        this.vehiculos.put(matricula, nuevoVehiculo);
        return this.vehiculos.get(matricula);
    }
    
    public void borrarVehiculo(String matricula) {
        if(!this.existeVehiculo(matricula)) {
            throw new Error("No existe el Vehiculo con el matricula: " + matricula);
        }
        this.vehiculos.remove(matricula);
    }
    
    public Vehiculo crearVehiculo(String matricula, TipoVehiculo tipo, EstacionBase estacionBase) {
        if(this.existeVehiculo(matricula)) {
            throw new Error("El matricula " + matricula + " ya está registrado, por favor, inténtalo con otro.");
        }
        this.vehiculos.put(matricula, new Vehiculo(tipo, matricula, estacionBase));
        return this.vehiculos.get(matricula);
    }
    
    public Collection<Vehiculo> obtenerVehiculos() {
        return this.vehiculos.values();
    }
    
    private boolean existeVehiculo(String matricula) {
        Vehiculo VehiculoEncontrado = this.vehiculos.get(matricula);
        return VehiculoEncontrado != null;
    }
}

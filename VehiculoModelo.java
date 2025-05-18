import java.util.Collection;
import java.util.ArrayList;


/**
 * Write a description of class VehiculoModelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VehiculoModelo extends VehiculoRepositorio
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class VehiculoModelo
     */
    public VehiculoModelo()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public Collection<Vehiculo> obtenerVehiculosDisponibles() {
        Collection<Vehiculo> vehiculos = this.vehiculos.values();
        Collection<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
        for(Vehiculo vehiculo: vehiculos) {
            if(vehiculo.estaDisponible()) vehiculosDisponibles.add(vehiculo); 
        }
        return vehiculosDisponibles;
    }
}

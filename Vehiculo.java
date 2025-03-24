
/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehiculo
{
    private EnumVehiculoTipo type;
    private String plate;
    private float batteryLeft;
    private boolean isRented = false;
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehiculo(EnumVehiculoTipo vehicleType, String plate) {
        this.type = vehicleType;
        this.plate = plate;
        batteryLeft = 100;
    }
    
    public float getBattery() {
        return this.batteryLeft;
    }

    public String getPlate() {
        return this.plate;
    }
    
    public void setBatter(float newBattery) {
        this.batteryLeft = newBattery;
    }
    
    public boolean isRented() {
        return this.isRented;
    }
}


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
    /**
     * Constructor for objects of class EstacionBase
     */
    public EstacionBase(String baseName, int coordinateX, int coordinateY, int availableChargingLots)
    {
        // initialise instance variables
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.availableChargingLots = availableChargingLots;
    }
}

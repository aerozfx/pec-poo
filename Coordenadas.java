
/**
 * Write a description of class Coordenadas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordenadas
{
    // instance variables - replace the example below with your own
    private int coordenadaX;
    private int coordenadaY;

    /**
     * Constructor for objects of class Coordenadas
     */
    public Coordenadas(int coordenadaX, int coordenadaY)
    {
        // initialise instance variables
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    public int obtenerCoordenadaX() {
        return this.coordenadaX;
    }
    
    public int obtenerCoordenadaY() {
        return this.coordenadaY;
    }
    
    public void establecerCoordenadas(Coordenadas coordenadas) {
        this.coordenadaX = coordenadas.obtenerCoordenadaX();
        this.coordenadaY = coordenadas.obtenerCoordenadaX();
    }
}

import java.util.Date;
/**
 * Write a description of class Travel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viaje
{
    private String desde;
    private String hacia;
    private int precio;
    private Date timestamp;
    public Viaje(String origen, String destino, int costeViaje)
    {
        this.desde = origen;
        this.hacia = destino;
        this.precio = costeViaje;
        this.timestamp = new Date();
    }
    
    public void imprimirDetalles() {
        System.out.println(this.timestamp);
        System.out.println(this.desde + " - " + this.hacia);
        System.out.println();
        System.out.println("haciatal: " + this.precio);
    }
}

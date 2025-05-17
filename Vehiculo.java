
/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehiculo
{
    private TipoVehiculo tipo;
    private String matricula;
    private float bateriaRestante;
    private int idEstacion;
    private boolean estaAlquilado = false;
    private int coordenadaX;
    private int coordenadaY;
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehiculo(TipoVehiculo tipoVehiculo, String matricula) {
        this.tipo = tipoVehiculo;
        this.matricula = matricula;
        bateriaRestante = 100;
        this.idEstacion = idEstacion;
    }
    
    public float obtenerBateria() {
        return this.bateriaRestante;
    }

    public String obtenerMatricula() {
        return this.matricula;
    }
    
    public String obtenerPosicion() {
        return this.matricula;
    }
    
    public void establecerBateria(float nuevaBateria) {
        this.bateriaRestante = nuevaBateria;
    }
    
    public String obtenerLocalizacionVehiculo() {
        return this.coordenadaX + "-" + this.coordenadaY;
    }
    
    public void establecerLocalizacionVehiculo(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }
    
    public void alquilarVehiculo() {
        this.estaAlquilado = true; 
    }
    
    public void finalizarAlquilerVehiculo() {
        this.estaAlquilado = false; 
    }
    
    public boolean obtenerEstado() {
        return this.estaAlquilado;
    }
    
    public void obtenerInformacion() {
        System.out.println("MATRICULA: " + this.obtenerMatricula() + "\n"+ this.obtenerBateria() + "\n");
    }
}

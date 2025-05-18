
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
    private boolean estaDisponible = false;
    private Coordenadas coordenadas;
    private EstacionBase estacionBase = null;
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehiculo(TipoVehiculo tipoVehiculo, String matricula, EstacionBase estacionBase) {
        this.tipo = tipoVehiculo;
        this.matricula = matricula;
        this.estacionBase = estacionBase;
        this.estaDisponible = true;
        bateriaRestante = 100;
        this.idEstacion = idEstacion;
        Coordenadas coordenadasEstacionAsignada = estacionBase.obtenerPosicion();
        this.coordenadas = new Coordenadas(coordenadasEstacionAsignada.obtenerCoordenadaX(), coordenadasEstacionAsignada.obtenerCoordenadaY());
    }
    
    public float obtenerBateria() {
        return this.bateriaRestante;
    }

    public String obtenerMatricula() {
        return this.matricula;
    }
    
    public TipoVehiculo obtenerTipoVehiculo() {
        return this.tipo;
    }
    
    public String obtenerPosicion() {
        return this.matricula;
    }
    
    public void establecerBateria(float nuevaBateria) {
        this.bateriaRestante = nuevaBateria;
    }
    
    public Coordenadas obtenerLocalizacionVehiculo() {
        return this.coordenadas;
    }
    
    public EstacionBase obtenerEstacionAsignada() {
        return this.estacionBase;
    }
    
    public void establecerLocalizacionVehiculo(int posicionX, int posicionY) {
        this.coordenadas.establecerCoordenadas(new Coordenadas(posicionX, posicionY));
    }
    
    public void alquilarVehiculo() {
        this.estaDisponible = true; 
    }
    
    public void finalizarAlquilerVehiculo() {
        this.estaDisponible = false; 
    }
    
    public boolean estaDisponible() {
        return this.estaDisponible;
    }
    
    public void obtenerInformacion() {
        String estado = this.estaDisponible() ? "Disponible" : "Alquilado";
        System.out.println("MATRICULA: " + this.obtenerMatricula() + " - BATERÍA: "+ this.obtenerBateria() + " - ESTADO: " + estado);
    }
}

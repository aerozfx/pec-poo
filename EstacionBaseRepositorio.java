import java.util.HashMap;



/**
 * Write a description of class EstacionBaseRepositorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstacionBaseRepositorio
{
    protected HashMap<String, EstacionBase> estaciones = new HashMap<String, EstacionBase>();
    private EstacionBaseRepositorio instance= null;
    public EstacionBaseRepositorio EstacionBaseRepositorio() {
        if (this.instance == null) {
            this.instance = new EstacionBaseRepositorio();
        }
        return this.instance;
    }

    /**
     * Este método obtiene un EstacionBase almacenado en memoria, si es que existe, en caso contrario devuelve un error
     * @param String dni -> DNI usado para filtrar el EstacionBase
     * @return El EstacionBase encontrado, lanza una excepción en caso contrario
     */
    public EstacionBase obtenerEstacionBase(String nombreBase) {
        if (!this.existeBase(nombreBase)) {
            return null;
        }
        EstacionBase EstacionBaseEncontrado = this.estaciones.get(nombreBase);
        return EstacionBaseEncontrado;
    }
    
    public EstacionBase editarEstacionBase(String dni, EstacionBase nuevoEstacionBase) {
        if (!this.existeBase(dni)) {
            throw new Error("No existe el EstacionBase con el DNI: " + dni);
        };
        this.estaciones.replace(dni, nuevoEstacionBase);
        return this.obtenerEstacionBase(dni);
    }
    
    public void borrarEstacionBase(String nombreBase) {
        if(!this.existeBase(nombreBase)) {
            throw new Error("No existe la base con el nombre: " + nombreBase);
        }
        this.estaciones.remove(nombreBase);
    }
    
    public EstacionBase crearEstacionBase(EstacionBase estacionBase) {
        String nombreEstacion = estacionBase.obtenerNombreEstacion();
        if(this.existeBase(nombreEstacion)) {
            throw new Error("La base " + nombreEstacion + " ya está registrada!");
        }
        this.estaciones.put(nombreEstacion, new EstacionBase(nombreEstacion, estacionBase.obtenerPosicion(), estacionBase.obtenerHuecosDisponibles()));
        return this.obtenerEstacionBase(nombreEstacion);
    }
    
    private boolean existeBase(String dni) {
        EstacionBase EstacionBaseEncontrado = this.estaciones.get(dni);
        return EstacionBaseEncontrado != null;
    }
}

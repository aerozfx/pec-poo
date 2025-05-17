import java.util.HashMap;
import java.util.Collection;

/**
 * Write a description of class TrabajadorRepositorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrabajadorRepositorio
{
    private HashMap<String, Trabajador> trabajadores = new HashMap<String, Trabajador>();
    private TrabajadorRepositorio instance = null;
    /**
     * Constructor para los objetos de TrabajadorRepositorio
     */
    public TrabajadorRepositorio TrabajadorRepositorio() {
        if (this.instance == null) {
            this.instance = new TrabajadorRepositorio();
        }
        return this.instance;
    }

    /**
     * Este método obtiene un Trabajador almacenado en memoria, si es que existe, en caso contrario devuelve un error
     * @param String dni -> DNI usado para filtrar el trabajador
     * @return El trabajador encontrado, lanza una excepción en caso contrario
     */
    public Trabajador obtenerTrabajador(String dni) {
        if (!this.existeTrabajador(dni)) {
            throw new Error("No existe el Trabajador con el DNI: " + dni);
        }
        Trabajador trabajadorEncontrado = this.trabajadores.get(dni);
        return trabajadorEncontrado;
    }
    
    public Trabajador editarTrabajador(String dni, Trabajador nuevoTrabajador) {
        if (!this.existeTrabajador(dni)) {
            throw new Error("No existe el Trabajador con el DNI: " + dni);
        }
        this.trabajadores.put(dni, nuevoTrabajador);
        return this.trabajadores.get(dni);
    }
    
    public void borrarTrabajador(String dni) {
        if(!this.existeTrabajador(dni)) {
            throw new Error("No existe el Trabajador con el DNI: " + dni);
        }
        this.trabajadores.remove(dni);
    }
    
    public Trabajador crearTrabajador(Trabajador trabajador) {
        String dni = trabajador.obtenerDni();
        RolTrabajador rol = trabajador.obtenerRol();
        Persona persona = new Persona(dni, trabajador.obtenerNombre(), trabajador.obtenerApellido());
        if(this.existeTrabajador(dni)) {
            throw new Error("El DNI " + dni + " ya está registrado, por favor, inténtalo con otro.");
        }
        Trabajador trabajadorCreado = null;
        switch(rol) {
            case rol.ADMINISTRADOR:
                trabajadorCreado = new Administrador(persona);
                break;
            case rol.ENCARGADO_DE_MANTENIMIENTO:
                trabajadorCreado = new EncargadoDeMantenimiento(persona);
                break;    
            case rol.MECANICO:
                trabajadorCreado = new Mecanico(persona);
                break;
            default:
                throw new Error("Ese tipo de trabajador no existe");
        }
        this.trabajadores.put(dni, trabajadorCreado);
        return this.obtenerTrabajador(dni);
    }
    
    public void borrarTodosLosTrabajadores() {
        this.trabajadores.clear();
    }
    
    public Collection<Trabajador> obtenerTrabajadores() {
        return this.trabajadores.values();
    }
    
    private boolean existeTrabajador(String dni) {
        Trabajador trabajadorEncontrado = this.trabajadores.get(dni);
        return trabajadorEncontrado != null;
    }
    
}

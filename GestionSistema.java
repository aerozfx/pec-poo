import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class GestionSistema here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionSistema
{
    // instance variables - replace the example below with your own
    private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
    private static HashMap<String, Vehiculo> vehiculos = new HashMap<String, Vehiculo>();
    private static HashMap<String, Trabajador> trabajadores = new HashMap<String, Trabajador>();
    private static HashMap<String, IncidenciaVehiculo> incidenciasVehiculos = new HashMap<String, IncidenciaVehiculo>();
    private static HashMap<String, EstacionBase> estaciones = new HashMap<String, EstacionBase>();
    private static Random randomGenerator = new Random();
    private static float premiumFareRate = 1.0f;
    private static int instancias = 0;
    private static Ciudad servicioCiudad;
    /**
     * Constructor for objects of class GestionSistema
     */
    public GestionSistema(Ciudad city)
    {
        if (GestionSistema.instancias == 1) {
           throw new Error(
            "Esta clase está diseñada para que sea usada solo una vez y que todos los objetos que lo necesiten, compartan la misma instancia." +
            "\nEste patrón se conoce como Singleton."
            );
        }
        this.servicioCiudad = city;
        GestionSistema.instancias += 1;
    }

    public static HashMap<String, Usuario> obtenerUsuariosDeLaPlataforma() {
        return GestionSistema.usuarios;
    }

    public static HashMap<String, Vehiculo> obtenerVehiculosDeLaPlataforma() {
        return GestionSistema.vehiculos;
    }
    
    public static HashMap<String, Trabajador> obtenerTrabajadoresDeLaPlataforma() {
        return GestionSistema.trabajadores;
    }
    
    public static HashMap<String, EstacionBase> obtenerEstacionesDeLaPlataforma() {
        return GestionSistema.estaciones;
    }

    public static HashMap<String, IncidenciaVehiculo> obtenerIncidentesDeLaPlataforma() {
        return GestionSistema.incidenciasVehiculos;
    }
    
    /**
     * Este método añade un usuario al HashMap usuarios, cuya clave será el correo del mismo, y el valor será una instancia de la clase Usuario
     * 
     * @param  user Datos usados para instanciar la clase Usuario
     * @return     1 si el usuario ha sido creado
     */
    public static int addUser(CreatableUsuario user) {
        String userDni = user.getDni();
        if(GestionSistema.estaUsuarioCreado(userDni)) {
            throw new Error(
                "Este usuario no se puede crear. Este DNI ya está registrado!" + 
                "\n¡Comprueba los datos e inténtalo de nuevo!");
        }
        GestionSistema.usuarios.put(userDni, user);
        return 1;
    }
    
    public static int editUser(CreatableUsuario updatedUser) {
        String userDni = updatedUser.getDni();        
        if(!GestionSistema.estaUsuarioCreado(userDni)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        Usuario res = GestionSistema.usuarios.replace(userDni, updatedUser);
        return 1;
    }
    
    public static int deleteUser(String dni) {
        if(!GestionSistema.estaUsuarioCreado(dni)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        GestionSistema.usuarios.remove(dni);
        return 1;
    }
    
    // CRUD Vehiculo
    
    public static int agregarVehiculo(String matricula, Vehiculo vehiculo) {
        if(GestionSistema.estaVehiculoRegistrado(matricula)) {
            throw new Error(
            "Este vehículo ya ha sido registrado.");
        }
        GestionSistema.vehiculos.put(matricula, vehiculo);
        return 1;
    }
    
    public static int editarVehiculo(String matricula, Vehiculo updatedVehicle) {
        if(!GestionSistema.estaVehiculoRegistrado(matricula)) {
            throw new Error(
            "Este vehículo no existe. Comprueba la matrícula introducida");
        }
        GestionSistema.vehiculos.replace(matricula, updatedVehicle);
        return 1;
    }

    public static int eliminarVehiculo(String matricula) {
        if(!GestionSistema.estaVehiculoRegistrado(matricula)) {
            throw new Error(
            "Este vehículo no existe. Comprueba la matrícula introducida");
        }
        GestionSistema.vehiculos.remove(matricula);
        return 1;
    }
    
    // CRUD Trabajador
    
    public static int agregarTrabajador(Trabajador worker) {
        String workerDni = worker.getDni();
        if(GestionSistema.estaTrabajadorRegistrado(workerDni)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.trabajadores.put(workerDni, worker);
        return 1;
    }
    
    public static int editarTrabajador(Trabajador worker) {
        String workerDni = worker.getDni();
        if(GestionSistema.estaTrabajadorRegistrado(workerDni)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.trabajadores.replace(workerDni, worker);
        return 1;
    }
    
    public static int deleteWorker(String dni) {
        if(!GestionSistema.estaTrabajadorRegistrado(dni)) {
            throw new Error(
            "¡Este trabajador no existe en la plataforma!");
        }
        GestionSistema.trabajadores.remove(dni);
        return 1;
    }
    
    // CRUD Incidencias
    
    public static int agregarIncidenciaVehiculo(String matricula, IncidenciaVehiculo report) {
        if(!GestionSistema.estaVehiculoRegistrado(matricula)) {
            throw new Error(
            "Este vehículo no existe en nuestra base de datos, por lo tanto no se puede generar un reporte para el mismo");
        }
        
        if(GestionSistema.hayIncidenciaParaEsteVehiculo(matricula)) {
             throw new Error(
            "Este vehículo ya tiene asignado un incidente y nuestros técnicos están intentando solucionarlo lo más rápido posible");
        }
        GestionSistema.incidenciasVehiculos.put(matricula, report);
        return 1;
    }
    
    // CRUD Estaciones
    
    public int agregarEstaciones(EstacionBase stationToBeCreated) {
        if(!estaDentroDeLosLimitesDeLaCiudad(stationToBeCreated)) {
            throw new Error("La estación no puede estar fuera de los límites de la ciudad");
        }
        int stationCoordinateX = stationToBeCreated.getCoordinateX();
        int stationCoordinateY = stationToBeCreated.getCoordinateY();
        String coordinates = stationCoordinateX + "-" + stationCoordinateY;
        if(estaciones.get(coordinates) != null) {
            throw new Error("Ya hay una base creada en estas coordenadas." + 
            "\nRevísalas e inténtalo de nuevo.");
        }
        estaciones.put(coordinates, stationToBeCreated);
        return 1;
    }
    
    public static HashMap<String, IncidenciaVehiculo> obtenerIncidenciasVehiculos() {
        return GestionSistema.incidenciasVehiculos;
    }
    
    public void establecerTarifaBicicletas(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }

    public void establecerTarifaMotos(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }

    public void establecerTarifaPatinetes(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }
    
    // Funciones de utilidad
    
    private static boolean estaDentroDeLosLimitesDeLaCiudad(EstacionBase station) {
        int cityBoundX = GestionSistema.servicioCiudad.getOrigin();
        int cityBoundY = GestionSistema.servicioCiudad.getLimit();
        return station.getCoordinateX() >= cityBoundX && station.getCoordinateX() <= cityBoundY && station.getCoordinateY() >= cityBoundX && station.getCoordinateY() <= cityBoundY;
    }
    
    private static boolean estaUsuarioCreado(String dni) {
        return GestionSistema.usuarios.get(dni) != null;
    }
    
    private static boolean estaVehiculoRegistrado(String matricula) {
        return GestionSistema.vehiculos.get(matricula) != null;
    }
    
    private static boolean hayIncidenciaParaEsteVehiculo(String matricula) {
        return GestionSistema.incidenciasVehiculos.get(matricula) != null;
    }

    private static boolean estaTrabajadorRegistrado(String dni) {
        return GestionSistema.trabajadores.get(dni) != null;
    }
}

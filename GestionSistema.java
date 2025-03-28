import java.util.HashMap;
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
    private static HashMap<String, Usuario> users = new HashMap<String, Usuario>();
    private static HashMap<String, Vehiculo> vehicles = new HashMap<String, Vehiculo>();
    private static HashMap<String, Trabajador> workers = new HashMap<String, Trabajador>();
    private static HashMap<String, IncidenciaVehiculo> vehicleReport = new HashMap<String, IncidenciaVehiculo>();
    private static Random randomGenerator = new Random();
    private static float premiumFareRate = 1.0f;
    private static int instances = 0;
    /**
     * Constructor for objects of class GestionSistema
     */
    public GestionSistema()
    {
        if (GestionSistema.instances == 1) {
           throw new Error(
            "Esta clase está diseñada para que sea usada solo una vez y que todos los objetos que lo necesiten, compartan la misma instancia." +
            "\nEste patrón se conoce como Singleton."
            );
        }
        GestionSistema.instances += 1;
    }

    public static HashMap<String, Usuario> getPlatformUsers() {
        return GestionSistema.users;
    }

    public static HashMap<String, Vehiculo> getPlatformVehicles() {
        return GestionSistema.vehicles;
    }
    
    public static HashMap<String, Trabajador> getPlatformWorkers() {
        return GestionSistema.workers;
    }
    
    /**
     * Este método añade un usuario al HashMap users, cuya clave será el correo del mismo, y el valor será una instancia de la clase Usuario
     * 
     * @param  user Datos usados para instanciar la clase Usuario
     * @return     1 si el usuario ha sido creado
     */
    public static int addUser(CreatableUsuario user) {
        String userDni = user.getDni();
        if(GestionSistema.isUserCreated(userDni)) {
            throw new Error(
                "Este usuario no se puede crear. Este DNI ya está registrado!" + 
                "\n¡Comprueba los datos e inténtalo de nuevo!");
        }
        GestionSistema.users.put(userDni, user);
        return 1;
    }
    
    public static int editUser(CreatableUsuario updatedUser) {
        String userDni = updatedUser.getDni();        
        if(!GestionSistema.isUserCreated(userDni)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        Usuario res = GestionSistema.users.replace(userDni, updatedUser);
        return 1;
    }
    
    public static int deleteUser(String dni) {
        if(!GestionSistema.isUserCreated(dni)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        GestionSistema.users.remove(dni);
        return 1;
    }
    
    // CRUD Vehiculo
    
    public static int addVehicle(String plate, Vehiculo vehicle) {
        if(GestionSistema.isVehicleRegistered(plate)) {
            throw new Error(
            "Este vehículo ya ha sido registrado.");
        }
        GestionSistema.vehicles.put(plate, vehicle);
        return 1;
    }
    
    public static int editVehicle(String plate, Vehiculo updatedVehicle) {
        if(!GestionSistema.isVehicleRegistered(plate)) {
            throw new Error(
            "Este vehículo no existe. Comprueba la matrícula introducida");
        }
        GestionSistema.vehicles.replace(plate, updatedVehicle);
        return 1;
    }

    public static int deleteVehicle(String plate) {
        if(!GestionSistema.isVehicleRegistered(plate)) {
            throw new Error(
            "Este vehículo no existe. Comprueba la matrícula introducida");
        }
        GestionSistema.vehicles.remove(plate);
        return 1;
    }
    
    // CRUD Trabajador
    
    public static int addWorker(Trabajador worker) {
        String workerDni = worker.getDni();
        if(GestionSistema.isWorkerRegistered(workerDni)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.workers.put(workerDni, worker);
        return 1;
    }
    
    public static int editWorker(Trabajador worker) {
        String workerDni = worker.getDni();
        if(GestionSistema.isWorkerRegistered(workerDni)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.workers.replace(workerDni, worker);
        return 1;
    }
    
    public static int deleteWorker(String dni) {
        if(!GestionSistema.isWorkerRegistered(dni)) {
            throw new Error(
            "¡Este trabajador no existe en la plataforma!");
        }
        GestionSistema.workers.remove(dni);
        return 1;
    }
    
    // CRUD Incidencias
    
    public static int addVehicleReport(String plate, IncidenciaVehiculo report) {
        if(!GestionSistema.isVehicleRegistered(plate)) {
            throw new Error(
            "Este vehículo no existe en nuestra base de datos, por lo tanto no se puede generar un reporte para el mismo");
        }
        
        if(GestionSistema.isVehicleReported(plate)) {
             throw new Error(
            "Este vehículo ya tiene asignado un incidente y nuestros técnicos están intentando solucionarlo lo más rápido posible");
        }
        GestionSistema.vehicleReport.put(plate, report);
        return 1;
    }
    
    public static HashMap<String, IncidenciaVehiculo> getVehicleReports() {
        return GestionSistema.vehicleReport;
    }
    
    public void setPremiumUserFareRate(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }
    
    private static boolean isUserCreated(String dni) {
        return GestionSistema.users.get(dni) != null;
    }
    
    private static boolean isVehicleRegistered(String plate) {
        return GestionSistema.vehicles.get(plate) != null;
    }
    
    private static boolean isVehicleReported(String plate) {
        return GestionSistema.vehicleReport.get(plate) != null;
    }

    private static boolean isWorkerRegistered(String dni) {
        return GestionSistema.workers.get(dni) != null;
    }
}

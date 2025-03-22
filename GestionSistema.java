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
    private static Random randomGenerator = new Random();
    private static float premiumFareRate = 1.0f;
    /**
     * Constructor for objects of class GestionSistema
     */
    public GestionSistema()
    {}

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
        String userEmail = user.getEmail();
        if(GestionSistema.isUserCreated(userEmail)) {
            throw new Error(
                "Este usuario no se puede crear. Este correo ya está registrado!" + 
                "\n¡Comprueba los datos e inténtalo de nuevo!");
        }
        GestionSistema.users.put(userEmail, user);
        return 1;
    }
    
    public static int editUser(CreatableUsuario updatedUser) {
        String userEmail = updatedUser.getEmail();        
        if(!GestionSistema.isUserCreated(userEmail)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        Usuario res = GestionSistema.users.replace(userEmail, updatedUser);
        return 1;
    }
    
    public static int deleteUser(String email) {
        if(!GestionSistema.isUserCreated(email)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        GestionSistema.users.remove(email);
        return 1;
    }
    
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
        String workerFullname = worker.getFullName();
        if(GestionSistema.isWorkerRegistered(workerFullname)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.workers.put(worker.getFullName(), worker);
        return 1;
    }
    
    public static int editWorker(Trabajador worker) {
        String workerFullname = worker.getFullName();
        if(GestionSistema.isWorkerRegistered(workerFullname)) {
            throw new Error(
            "Este trabajador ya está registrado");
        }
        GestionSistema.workers.replace(worker.getFullName(), worker);
        return 1;
    }
    
    public static int delete(String fullName) {
        if(!GestionSistema.isWorkerRegistered(fullName)) {
            throw new Error(
            "¡Este trabajador no existe en la plataforma!");
        }
        GestionSistema.workers.remove(fullName);
        return 1;
    }
    
    public void setPremiumUserFareRate(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }
    
    private static boolean isUserCreated(String email) {
        return GestionSistema.users.get(email) != null;
    }
    
    private static boolean isVehicleRegistered(String plate) {
        return GestionSistema.vehicles.get(plate) != null;
    }
    
    private static boolean isWorkerRegistered(String fullName) {
        return GestionSistema.workers.get(fullName) != null;
    }
}

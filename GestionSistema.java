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
    private static Random randomGenerator = new Random();
    private static float premiumFareRate = 1.0f;
    /**
     * Constructor for objects of class GestionSistema
     */
    public GestionSistema()
    {}

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
                "¡Comprueba los datos e inténtalo de nuevo!");
        }
        GestionSistema.users.put(userEmail, new Usuario(user.getName(), user.getLastName(), user.getRole()));
        return 1;
    }
    
    public static void editUser(CreatableUsuario updatedUser) {
        String userEmail = updatedUser.getEmail();        
        if(!GestionSistema.isUserCreated(userEmail)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        GestionSistema.users.replace(userEmail, updatedUser);
    }
    
    public static int deleteUser(String email) {
        if(!GestionSistema.isUserCreated(email)) {
           throw new Error(
            "Este usuario no se encuentra en el sistema.");
        }
        GestionSistema.users.remove(email);
        return 1;
    }
    
    private static boolean isUserCreated(String email) {
        return GestionSistema.users.get(email) != null;
    }
    
    private static boolean isVehicleRegistered(String plate) {
        return GestionSistema.vehicles.get(plate) != null;
    }
    
    public static int addVehicle(String plate, Vehiculo vehicle) {
        if(!GestionSistema.isVehicleRegistered(plate)) {
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
    
    public void setPremiumUserFareRate(float rate) {
       GestionSistema.premiumFareRate = rate; 
    }
}

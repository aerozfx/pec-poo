import java.util.HashMap;
/**
 * Write a description of class SystemAdministratorWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrador extends Trabajador
{
    // instance variables - replace the example below with your own
    private EnumTrabajadorRol role;

    /**
     * Constructor for objects of class SystemAdministratorWorker
     */
    public Administrador(String name, String surname)
    {
       super(name, surname, EnumTrabajadorRol.ADMINISTRATOR);
       role = EnumTrabajadorRol.ADMINISTRATOR;
    }
    
    public HashMap<String, Usuario> listUsers() {
        return GestionSistema.getPlatformUsers();
    }
    
    public HashMap<String, Vehiculo> listVehicles() {
        return GestionSistema.getPlatformVehicles();
    }

    // CRUD Usuario
    
    public int createUser(CreatableUsuario usuario) {
        int createdNumber = GestionSistema.addUser(usuario);
        return createdNumber;
    }
    
    public int editUser(CreatableUsuario userUpdate) {
        GestionSistema.editUser(userUpdate);
        return 1;
    }
    
    public int deleteUser(String userEmail) {
        return GestionSistema.deleteUser(userEmail);
    }
    
    // CRUD Trabajador
    
    public int createWorker(Trabajador worker) {
        return GestionSistema.
    }
    
    // CRUD Vehículo
    
    public int registerVehicle(String plate, Vehiculo vehicle) {
        return GestionSistema.addVehicle(plate,vehicle);
    }
    
    public int editRegisteredVehicle(String plate, Vehiculo vehicle) {
        return GestionSistema.editVehicle(plate,vehicle);
    }

    public int deletedRegisteredVehicle(String plate, Vehiculo vehicle) {
        return GestionSistema.deleteVehicle(plate);
    }
}

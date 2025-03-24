import java.util.HashMap;
import java.util.Collection;
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
    public Administrador(Persona person)
    {
       super(person, EnumTrabajadorRol.ADMINISTRATOR);
       role = EnumTrabajadorRol.ADMINISTRATOR;
    }
    
    public HashMap<String, Usuario> listUsers() {
        return GestionSistema.getPlatformUsers();
    }
    
    public HashMap<String, Vehiculo> listVehicles() {
        return GestionSistema.getPlatformVehicles();
    }
    
    public HashMap<String, Trabajador> listWorkers() {
        return GestionSistema.getPlatformWorkers();
    }

    public HashMap<String, IncidenciaVehiculo> listReports() {
        return GestionSistema.getVehicleReports();
    }

    // CRUD Usuario

    public Usuario getUserById(String id) {
        return this.listUsers().get(id);
    }
    
    public int createUser(CreatableUsuario usuario) {
        int createdNumber = GestionSistema.addUser(usuario);
        return createdNumber;
    }
    
    public int editUser(CreatableUsuario userUpdate) {
        return GestionSistema.editUser(userUpdate);
    }
    
    public int deleteUser(String userEmail) {
        return GestionSistema.deleteUser(userEmail);
    }
    
    // CRUD Trabajador
    
    public Trabajador getWorkerById(String id) {
        return this.listWorkers().get(id);
    }
    
    public int createWorker(Trabajador worker) {
        return GestionSistema.addWorker(worker);
    }
    
    public int editWorker(Trabajador worker) {
        return GestionSistema.editWorker(worker);
    }

    public int deleteWorker(Trabajador worker) {
        return GestionSistema.deleteWorker(worker.getFullName());
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
    
    // CRUD Reportes Vehiculos
    
    public IncidenciaVehiculo getVehicleReportByPlate(String plate) {
        return this.listReports().get(plate);
    }
    
    public boolean assignVehicleIncident(String workerId, String vehiclePlate) {
        Mecanico workerSelected = (Mecanico)this.getWorkerById(workerId);
        IncidenciaVehiculo vehicleIncident= this.getVehicleReportByPlate(vehiclePlate);
        return workerSelected.assignIncident(vehicleIncident);
    }
    
    // Obtener información de la plataforma
    
    public void getVehicleBattery() {
        Collection<Vehiculo> platformVehicles = GestionSistema.getPlatformVehicles().values(); 
        
        for(Vehiculo vehicle: platformVehicles) {
            System.out.println("Vehículo: " + vehicle + 
            "\nBatería: " + vehicle.getBattery());
        }
    }
}

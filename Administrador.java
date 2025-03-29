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
    /**
     * Constructor for objects of class SystemAdministratorWorker
     */
    public Administrador(Persona persona)
    {
       super(persona, EnumTrabajadorRol.ADMINISTRATOR);
    }
    
    public HashMap<String, Usuario> listUsers() {
        return GestionSistema.obtenerUsuariosDeLaPlataforma();
    }
    
    public HashMap<String, Vehiculo> listVehicles() {
        return GestionSistema.obtenerVehiculosDeLaPlataforma();
    }
    
    public HashMap<String, Trabajador> listWorkers() {
        return GestionSistema.obtenerTrabajadoresDeLaPlataforma();
    }

    public HashMap<String, IncidenciaVehiculo> listReports() {
        return GestionSistema.obtenerIncidentesDeLaPlataforma();
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
        return GestionSistema.agregarTrabajador(worker);
    }
    
    public int editWorker(Trabajador worker) {
        return GestionSistema.editarTrabajador(worker);
    }

    public int deleteWorker(Trabajador worker) {
        return GestionSistema.deleteWorker(worker.getFullName());
    }

    // CRUD Vehículo
    
    public int registrarVehiculo(String matricula, Vehiculo vehiculo, EstacionBase estacion) {
        estacion.agregarVehiculo(vehiculo);
        return GestionSistema.agregarVehiculo(matricula,vehiculo);
    }
    
    public int editarVehiculoRegistrado(String plate, Vehiculo vehicle) {
        return GestionSistema.editarVehiculo(plate,vehicle);
    }

    public int eliminarVehiculoRegistrado(String plate, Vehiculo vehicle) {
        return GestionSistema.eliminarVehiculo(plate);
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
    
    public void obtenerBateriaVehiculos() {
        Collection<Vehiculo> vehiculosDeLaPlataforma = GestionSistema.obtenerVehiculosDeLaPlataforma().values(); 
        
        for(Vehiculo vehicle: vehiculosDeLaPlataforma) {
            // TODO: Implement this method
        }
    }
}

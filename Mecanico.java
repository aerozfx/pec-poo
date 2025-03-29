import java.util.ArrayList;
/**
 * Write a description of class MechanicWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mecanico extends Trabajador
{
    // instance variables - replace the example below with your own
    private EnumTrabajadorRol role;
    private ArrayList<IncidenciaVehiculo> assignedIncidents = new ArrayList<IncidenciaVehiculo>();
    /**
     * Constructor for objects of class MechanicWorker
     */
    public Mecanico(Persona person)
    {
       super(person, EnumTrabajadorRol.MECHANIC);
       this.role = EnumTrabajadorRol.MECHANIC;
    }
    
    public boolean assignIncident(IncidenciaVehiculo incident) {
        return assignedIncidents.add(incident);
    }
    
    public void checkAssignedIncidents() {
        if(this.assignedIncidents.isEmpty()) return;
        for(IncidenciaVehiculo incident : this.assignedIncidents) {
            System.out.println(incident);
        }
    }
}

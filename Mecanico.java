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
    private ArrayList<IncidenciaVehiculo> incidentesAsignados = new ArrayList<IncidenciaVehiculo>();
    /**
     * Constructor for objects of class MechanicWorker
     */
    public Mecanico(Persona person)
    {
       super(person, RolTrabajador.MECANICO);
    }
    
    public boolean asignarIncidente(IncidenciaVehiculo incident) {
        return incidentesAsignados.add(incident);
    }
    
    public void listarIncidentesAsignados() {
        if(this.incidentesAsignados.isEmpty()) return;
        for(IncidenciaVehiculo incident : this.incidentesAsignados) {
            System.out.println(incident);
        }
    }
}

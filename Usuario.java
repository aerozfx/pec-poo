import java.util.ArrayList;
/**
 * Clase que instanciará a los distintos usuarios de la plataforma.
 * 
 * @author (Fernando Mariño) 
 * @version (25/02/2025)
 */
public class Usuario extends Persona
{
    private EnumUsuarioRol role;
    private String id;
    private String email;
    private float balance;
    private ArrayList<Travel> travels;
    /**
     * Constructor de la clase Usuario
     * 
     * @param  name   nombre del usuario a crear
     * @return     una instancia de la clase Usuario
     */
    public Usuario(String name, String surname, String email, EnumUsuarioRol role)
    {
        super(name, surname);
        balance = 0;
        this.email = email;
        this.role = role;
    }
    
    public void checkAvailableVehicles() {}
    public void rentCar() {}
    
    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }
    
    public void consultRecentTravels() {
        if(this.travels.isEmpty()) return;
        
        for(Travel travel: travels) {
            travel.printDetails();
        }
    }
    
    public void checkClosestVehicle() {
        if(this.travels.isEmpty()) return;
        
        for(Travel travel: travels) {
            travel.printDetails();
        }
    }
    
    public int generateReport(String vehiclePlate, String title, String description) {
        System.out.println("This is not implemented!");
        return 0;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public EnumUsuarioRol getRole() {
        return this.role;
    }
}

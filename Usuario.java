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
     * Constructor for objects of class Usuario
     */
    public Usuario(String name, String surname)
    {
        super(name, surname);
        balance = 0;
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
}

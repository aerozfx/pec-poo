import java.util.HashMap;
import java.util.Collection;


/**
 * Write a description of class EstacionBaseModelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstacionBaseModelo extends EstacionBaseRepositorio
{
    public EstacionBaseModelo () {}
    
    public Collection<EstacionBase> obtenerEstacionesBase() {
        return this.estaciones.values();
    }
}

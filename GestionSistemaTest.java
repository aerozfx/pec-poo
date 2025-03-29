

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The test class GestionSistemaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GestionSistemaTest
{
    private Ciudad ciudadTest;
    private GestionSistema testSistema;
    /**
     * Default constructor for test class GestionSistemaTest
     */
    public GestionSistemaTest()
    {
        this.ciudadTest = new Ciudad(1000);
        this.testSistema = new GestionSistema(ciudadTest);
    }
    
    @Test
    @DisplayName("Debería crear un sistema dentro de los límites de la ciudad")
    public void createChargingPoint() {
        EstacionBase estacionACrear = new EstacionBase("Base Test",1, 32, 5);
        int res = testSistema.agregarEstaciones(estacionACrear);
        String coordenadas = 1 + "-" + 32;
        EstacionBase createdStation = GestionSistema.obtenerEstacionesDeLaPlataforma().get(coordenadas);
        assertEquals(createdStation.getCoordinateX(), 1);
        assertEquals(createdStation.getCoordinateY(), 32);
        assertEquals(res, 1);
    }
    
    @Test
    @DisplayName("Debería tirar un error cuando las coordenadas estén fuera de los límites de la ciudad")
    public void crearBaseConCoordenadasInvalidas() {
        EstacionBase estacionACrear = new EstacionBase("Base Test", -1, 10000, 5);
        assertThrows(Error.class, () -> {
            testSistema.agregarEstaciones(estacionACrear);
        });
    }
    
    @Test
    @DisplayName("Debería tirar un error cuando las coordenadas estén fuera de los límites de la ciudad")
    public void crearBaseConCoordenadasInvalidas1() {
        EstacionBase estacionACrear = new EstacionBase("Base Test", 10000, -1, 5);
        assertThrows(Error.class, () -> {
            testSistema.agregarEstaciones(estacionACrear);
        });
    }
    
    @Test
    @DisplayName("Debería tirar un error cuando se crea una base cuyas coordenadas ya existen")
    public void crearPuntosDeCargaDuplicados() {
        EstacionBase estacionACrear = new EstacionBase("Base Test", 1, 1, 5);
        testSistema.agregarEstaciones(estacionACrear);
        EstacionBase estacionCreadaEnLasMismasCoordenadas = new EstacionBase("Base Test", 1, 1, 5);
        assertThrows(Error.class, () -> {
            testSistema.agregarEstaciones(estacionCreadaEnLasMismasCoordenadas);
        });
    }
}

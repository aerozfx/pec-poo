import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
/**
 * The test class VehiculoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VehiculoTest
{
    private EstacionBase estacionTest;
    /**
     * Default constructor for test class VehiculoTest
     */
    public VehiculoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        Coordenadas coordenadas = new Coordenadas(1, 1);
        this.estacionTest = new EstacionBase("Base Test", coordenadas, 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        this.estacionTest.obtenerVehiculosDisponibles().clear();
    }
    
    @Test
    @DisplayName("Debería añadir vehículos a una estación existente")
    public void crearEstacionBase() {
        Vehiculo vehiculo1 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-1", estacionTest);
        Vehiculo vehiculo2 = new Vehiculo(TipoVehiculo.PATINETE, "matricula-test-2", estacionTest);
        Vehiculo vehiculo3 = new Vehiculo(TipoVehiculo.MOTO, "matricula-test-3", estacionTest);
        Vehiculo vehiculo4 = new Vehiculo(TipoVehiculo.PATINETE, "matricula-test-4", estacionTest);
        Vehiculo vehiculo5 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-5", estacionTest);
        estacionTest.agregarVehiculo(vehiculo1);
        estacionTest.agregarVehiculo(vehiculo2);
        estacionTest.agregarVehiculo(vehiculo3);
        estacionTest.agregarVehiculo(vehiculo4);
        estacionTest.agregarVehiculo(vehiculo5);
        assertEquals(estacionTest.obtenerVehiculosDisponibles().size(), 5);
    }
    
    @Test
    @DisplayName("Debería tirar error cuando se añaden más vehículos")
    public void crearMasVehiculosDeLosAceptadosPorLaEstacionBase() {
        Vehiculo vehiculo1 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-1", estacionTest);
        Vehiculo vehiculo2 = new Vehiculo(TipoVehiculo.PATINETE, "matricula-test-2", estacionTest);
        Vehiculo vehiculo3 = new Vehiculo(TipoVehiculo.MOTO, "matricula-test-3", estacionTest);
        Vehiculo vehiculo4 = new Vehiculo(TipoVehiculo.PATINETE, "matricula-test-4", estacionTest);
        Vehiculo vehiculo5 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-5", estacionTest);
        Vehiculo vehiculo6 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-6", estacionTest);
        estacionTest.agregarVehiculo(vehiculo1);
        estacionTest.agregarVehiculo(vehiculo2);
        estacionTest.agregarVehiculo(vehiculo3);
        estacionTest.agregarVehiculo(vehiculo4);
        estacionTest.agregarVehiculo(vehiculo5);
        assertThrows(Error.class, () -> {
            estacionTest.agregarVehiculo(vehiculo6);
        });
    }
    
    @Test
    @DisplayName("Debería tirar error cuando se añaden más vehículos")
    public void añadirVehiculosDuplicados() {
        Vehiculo vehiculo1 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-1", estacionTest);
        Vehiculo vehiculo2 = new Vehiculo(TipoVehiculo.BICICLETA, "matricula-test-1", estacionTest);
        estacionTest.agregarVehiculo(vehiculo1);
        assertThrows(Error.class, () -> {
            estacionTest.agregarVehiculo(vehiculo2);
        });
    }
}

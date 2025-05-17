import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.HashMap;

/**
 * The test class AdministradorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ControladorAdministradorTest
{
    private Persona adminUser = new Persona("01213123C", "Admin", "Test");
    private Administrador admin = new Administrador(adminUser);
    private ControladorAdministrador sut = new ControladorAdministrador(admin, new UsuarioRepositorio(), new TrabajadorRepositorio(), new VehiculoRepositorio());
    /**
     * Default constructor for test class AdministradorTest
     */
    public ControladorAdministradorTest() {}

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        this.sut.eliminarTodo();
    }
    
    // CRUD Usuario
    
    @Test
    @DisplayName("Esto debería crear un usuario")
    public void crearUsuarioTest() {
        Persona personaTest = new Persona("testTEST","test", "user");
        Usuario usuarioCreado = this.sut.crearUsuario(new Usuario(personaTest, "test@test.test", RolUsuario.ESTANDAR));
        Usuario usuarioEncontrado = this.sut.obtenerUsuarioPorDni(usuarioCreado.obtenerDni());
        assertEquals(usuarioEncontrado.obtenerCorreo(), "test@test.test");
    }
    
    @Test
    @DisplayName("Esto debería editar un usuario existente")
    public void editarUsuarioTest() {
        Persona personaTest = new Persona("testTEST","test", "user");
        Usuario usuarioCreado = this.sut.crearUsuario(new Usuario(personaTest, "test@test.test", RolUsuario.ESTANDAR));
        Persona personaEditada = new Persona("testTEST","edited-test", "edited-test");
        Usuario usuarioEditado = new Usuario(personaEditada, "test@test.test", RolUsuario.PREMIUM);
        Usuario resultadoEdicionUsuario = this.sut.editarUsuario(usuarioCreado.obtenerDni(), usuarioEditado);
        assertEquals(resultadoEdicionUsuario.obtenerNombre(), "edited-test");
    }
    
    @Test
    @DisplayName("Esto debería lanzar una excepción cuando el usuario no existe")
    public void lanzaErrorCuandoSeEditaUnUsuarioQueNoExisteTest() {
        Persona persona = new Persona("non-existent","test", "user");
        Usuario usuarioEditado = new Usuario(persona, "non-existing@test.test", RolUsuario.PREMIUM);
        assertThrows(Error.class, () -> {
            this.sut.editarUsuario(persona.obtenerDni(), usuarioEditado);
        });
    }
    
    @Test
    @DisplayName("Debería eliminar un usuario")
    public void eliminarUsuarioTest() {
        Persona personaTest = new Persona("testTEST","test", "user");
        this.sut.crearUsuario(new Usuario(personaTest, "test@test.test", RolUsuario.ESTANDAR));
        this.sut.eliminarUsuario("testTEST");
        assertEquals(this.sut.obtenerUsuarioPorDni("testTEST"), null);
    }
    
    @Test
    @DisplayName("Debería lanzar un error borrando un usuario que no existe")
    public void lanzaErrorCuandoSeEliminaUnUsuarioInexistenteTest() {
        assertThrows(Error.class, () -> {
            this.sut.eliminarUsuario("test@test.test");
        });
    }
    
    // CRUD Trabajador
    
    @Test
    @DisplayName("Debería crear un trabajador de Mantenimiento")
    public void createMaintainer() {
        Persona personaTest = new Persona("testTEST","test", "user");
        Trabajador trabajador = this.sut.crearTrabajador(new EncargadoDeMantenimiento(personaTest));
        assertEquals(trabajador.obtenerRol(), RolTrabajador.ENCARGADO_DE_MANTENIMIENTO);
    }
}

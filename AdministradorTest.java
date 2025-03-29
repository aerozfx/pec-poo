

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
public class AdministradorTest
{
    private Persona adminUser = new Persona("01213123C", "Admin", "Test");
    private Administrador admin = new Administrador(adminUser);
    /**
     * Default constructor for test class AdministradorTest
     */
    public AdministradorTest()
    {}

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        this.admin.listUsers().clear();
        this.admin.listVehicles().clear();
        this.admin.listWorkers().clear();
    }
    
    // CRUD Usuario
    
    @Test
    @DisplayName("This should create a user")
    public void createUser() {
        Persona testPerson = new Persona("testTEST","test", "user");
        int res = this.admin.createUser(new CreatableUsuario(testPerson, "test@test.test", EnumUsuarioRol.REGULAR));
        Usuario result = this.admin.getUserById("testTEST");
        assertEquals(result.getEmail(), "test@test.test");
        assertEquals(res, 1);
    }
    
    @Test
    @DisplayName("This should edit an existing user")
    public void editUser() {
        Persona testPerson = new Persona("testTEST","test", "user");
        this.admin.createUser(new CreatableUsuario(testPerson, "test@test.test", EnumUsuarioRol.REGULAR));
        Persona editedPerson = new Persona("testTEST","edited-test", "edited-test");
        CreatableUsuario editedUser = new CreatableUsuario(editedPerson, "test@test.test", EnumUsuarioRol.PREMIUM);
        int editedResult = this.admin.editUser(editedUser);
        HashMap<String, Usuario> users = this.admin.listUsers();
        assertEquals(editedResult, 1);
        assertEquals(users.get("testTEST").getRole(), EnumUsuarioRol.PREMIUM);
    }
    
    @Test
    @DisplayName("This should throw an error when editting a non-existing user")
    public void throwErrorWhenEdittingAUserDoesNotExist() {
        Persona testPerson = new Persona("non-existent","test", "user");
        CreatableUsuario editedUser = new CreatableUsuario(testPerson, "non-existing@test.test", EnumUsuarioRol.PREMIUM);
        assertThrows(Error.class, () -> {
            this.admin.editUser(editedUser);
        });
    }
    
    @Test
    @DisplayName("This should delete a user")
    public void deleteUser() {
        Persona testPerson = new Persona("testTEST","test", "user");
        this.admin.createUser(new CreatableUsuario(testPerson, "test@test.test", EnumUsuarioRol.REGULAR));
        HashMap<String, Usuario> users = this.admin.listUsers();
        this.admin.deleteUser("testTEST");
        assertEquals(users.get("testTEST"), null);
    }
    
    @Test
    @DisplayName("This should throw an error when deleting a non-existing user")
    public void throwErrorWhenDeletingAUserDoesNotExist() {
        HashMap<String, Usuario> users = this.admin.listUsers();
        assertThrows(Error.class, () -> {
            this.admin.deleteUser("test@test.test");
        });
    }
    
    // CRUD Trabajador
    
    @Test
    @DisplayName("This should create a maintainer worker")
    public void createMaintainer() {
        Persona testPerson = new Persona("testTEST","test", "user");
        int res = this.admin.createWorker(new EncargadoDeMantenimiento(testPerson));
        assertEquals(res, 1);
    }
}

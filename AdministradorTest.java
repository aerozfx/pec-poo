

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
    private Administrador admin = new Administrador("Admin", "Test");
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
    }
    
    // CRUD Usuario
    
    @Test
    @DisplayName("This should create a user")
    public void createUser() {
        int res = this.admin.createUser(new CreatableUsuario("test", "user", "test@test.test", EnumUsuarioRol.REGULAR));
        assertEquals(res, 1);
    }
    
    @Test
    @DisplayName("This should edit an existing user")
    public void editUser() {
        this.admin.createUser(new CreatableUsuario("test", "user", "test@test.test", EnumUsuarioRol.REGULAR));
        CreatableUsuario editedUser = new CreatableUsuario("edited-test", "edited-user", "test@test.test", EnumUsuarioRol.PREMIUM);
        int editedResult = this.admin.editUser(editedUser);
        HashMap<String, Usuario> users = this.admin.listUsers();
        assertEquals(editedResult, 1);
        assertEquals(users.get("test@test.test").getRole(), EnumUsuarioRol.PREMIUM);
    }
    
    @Test
    @DisplayName("This should throw an error when editting a non-existing user")
    public void throwErrorWhenEdittingAUserDoesNotExist() {
        CreatableUsuario editedUser = new CreatableUsuario("edited-test", "edited-user", "non-existing@test.test", EnumUsuarioRol.PREMIUM);
        assertThrows(Error.class, () -> {
            this.admin.editUser(editedUser);
        });
    }
    
    @Test
    @DisplayName("This should delete a user")
    public void deleteUser() {
        this.admin.createUser(new CreatableUsuario("test", "user", "test@test.test", EnumUsuarioRol.REGULAR));
        HashMap<String, Usuario> users = this.admin.listUsers();
        this.admin.deleteUser("test@test.test");
        assertEquals(users.get("test@test.test"), null);
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
        int res = this.admin.createUser(new EncargadoDeMantenimiento("test", "user", EnumTrabajadorRol.MAINTAINER));
        assertEquals(res, 1);
    }
}

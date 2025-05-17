import java.util.Collection;
import java.util.Scanner;
/**
 * Write a description of class VistaAdministrador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VistaAdministrador
{
    // instance variables\nreplace the example below with your own
    ControladorAdministrador controladorAdministrador = null;
    Scanner sc = new Scanner(System.in);
    boolean procesoCerrado = false;
    /**
     * Constructor for objects of class VistaAdministrador
     */
    public VistaAdministrador(ControladorAdministrador controladorAdministrador)
    {
        this.controladorAdministrador = controladorAdministrador;
    }

    public void iniciarVista() {
        while(!procesoCerrado) {
            this.listarOpcionesAdministrador();
            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    this.log("\nEstos son los usuarios que están registrados actualmente en el sistema:\n");
                    this.listarUsuarios();
                    break;
                case "2":
                    this.log("\nEstos son los vehiculos que están registrados actualmente en el sistema:\n");
                    this.listarVehiculos();
                    break;
                case "3":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionUsuarios();
                    break;
                case "4":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionVehiculos();
                    break;
                case "5":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionTrabajador();
                    break;
                case "6":
                    this.log("\n¿Qué tarifa quieres modificar?:\n");
                    this.gestionarModificacionTarifas();
                    break;
                case "7":
                    this.log("Volver al menú anterior");
                    this.procesoCerrado = true;
                default:
                    this.log("Esa opción no existe!");
                    
            }
        }
 
        
    }
    
    private void listarOpcionesAdministrador() {
        this.log("MENÚ ADMINISTRADOR");
        this.log("1) Listar usuarios");
        this.log("2) Listar información de vehículos");
        this.log("3) Gestión usuarios");
        this.log("4) Gestión vehículos");
        this.log("5) Gestión trabajadores");
        this.log("6) Modificar tarifas");
        this.log("7) Volver al menú anterior");
    }
    
    private void gestionarOpcionesGestionUsuarios() {
        boolean listaMostrada = false;
        while(!listaMostrada) {
            this.log("1) Crear usuario");
            this.log("2) Editar usuario");
            this.log("3) Borrar usuario");
            this.log("4) Volver a atrás");
            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    this.log("Introduce los datos del nuevo usuario:\n");
                    Usuario usuarioCreado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.crearUsuario(usuarioCreado);
                    break;
                case "2":
                    this.log("Introduce el DNI del usuario a editar:\n");
                    String dni = sc.nextLine();
                    Usuario usuarioEditado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.editarUsuario(dni, usuarioEditado);
                    break;
                case "3":
                    this.log("Introduce el DNI del usuario a eliminar:\n");
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarUsuario(dniBorrado);
                    break;
                case "4":
                    listaMostrada = true;
                    break;
                default:
                    this.log("Esa opción no existe!");
            }
        }

    }
    
    private void gestionarOpcionesGestionVehiculos() {
        boolean mostrarLista = false;
        while(!mostrarLista) {
            this.log("1) Añadir vehiculo");
            this.log("2) Editar vehiculo");
            this.log("3) Borrar vehiculo");
            this.log("4) Volver a atrás");
            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    this.log("Introduce los datos del nuevo vehiculo:\n");
                    Usuario usuarioCreado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.crearUsuario(usuarioCreado);
                    break;
                case "2":
                    this.log("Introduce la matricula del vehiculo a editar:\n");
                    String dni = sc.nextLine();
                    Usuario usuarioEditado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.editarUsuario(dni, usuarioEditado);
                    break;
                case "3":
                    this.log("Introduce el DNI del usuario a eliminar:\n");
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarUsuario(dniBorrado);
                    break;
                case "4":
                    mostrarLista = true;
                    break;
                default:
                    this.log("Esa opción no existe!");
            }
        }
    }
    
    private void gestionarOpcionesGestionTrabajador() {
        boolean mostrarLista = false;
        while(!mostrarLista) {
            this.log("1) Añadir trabajador");
            this.log("2) Editar trabajador");
            this.log("3) Borrar trabajador");
            this.log("4) Volver a atrás");
            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    this.log("Introduce los datos del nuevo trabajador:\n");
                    Usuario usuarioCreado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.crearUsuario(usuarioCreado);
                    break;
                case "2":
                    this.log("Introduce el DNI del trabajador a editar:\n");
                    String dni = sc.nextLine();
                    Trabajador trabajadorEditado = this.obtenerDatosTrabajador();
                    this.controladorAdministrador.editarTrabajador(dni, trabajadorEditado);
                    break;
                case "3":
                    this.log("Introduce el DNI del trabajador a eliminar:\n");
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarTrabajador (dniBorrado);
                    break;
                case "4":
                    mostrarLista = true;
                    break;
                default:
                    this.log("Esa opción no existe!");
            }
        }
    }
    
    private void gestionarModificacionTarifas() {
        boolean mostrarOpciones = false;
        while(!mostrarOpciones) {
            this.log("1) Modificar tarifa patinete");
            this.log("2) Modificar tarifa bicicleta");
            this.log("3) Modificar tarifa moto");
            this.log("4) Volver a atrás");
            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    this.log("Introduce la nueva tarifa para patinetes");
                    break;
                case "2":
                    this.log("Introduce la nueva tarifa para bicicletas:\n");
                    String dni = sc.nextLine();
                    Trabajador trabajadorEditado = this.obtenerDatosTrabajador();
                    this.controladorAdministrador.editarTrabajador(dni, trabajadorEditado);
                    break;
                case "3":
                    this.log("Introduce la nueva tarifa para motos:\n");
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarTrabajador (dniBorrado);
                    break;
                case "4":
                    mostrarOpciones = true;
                    break;
                default:
                    this.log("Esa opción no existe!");
            }
        }
    }
    
    private void listarUsuarios() {
        Collection<Usuario> usuarios = this.controladorAdministrador.obtenerUsuarios();
        for(Usuario usuario: usuarios) {
            usuario.obtenerInformacion();
        }
    }

    private void listarTrabajadores() {
        Collection<Trabajador> trabajadores = this.controladorAdministrador.obtenerTrabajadores();
        for(Trabajador trabajador: trabajadores) {
            trabajador.obtenerInformacion();
        }
    }
    
    private void listarVehiculos() {
        Collection<Vehiculo> vehiculos = this.controladorAdministrador.obtenerVehiculos();
        for(Vehiculo vehiculo: vehiculos) {
            vehiculo.obtenerInformacion();
        }
    }
    
    private void log(String mensaje) {
        System.out.println(mensaje);
    }
    
    private Usuario obtenerDatosUsuario() {
        this.log("Nombre Usuario: ");
        String nombreUsuario = sc.nextLine();
        this.log("Apellido Usuario: ");
        String apellidoUsuario = sc.nextLine();
        this.log("DNI Usuario: ");
        String dniUsuario = sc.nextLine();
        this.log("Correo Usuario: ");
        String correoUsuario = sc.nextLine();
        return new Usuario(new Persona(dniUsuario, nombreUsuario, apellidoUsuario), correoUsuario, RolUsuario.ESTANDAR);
    }
    
    private Trabajador obtenerDatosTrabajador() {
        boolean rolTrabajadorValido = false;
        this.log("Nombre trabajador: ");
        String nombreUsuario = sc.nextLine();
        this.log("Apellido trabajador: ");
        String apellidoUsuario = sc.nextLine();
        this.log("DNI trabajador: ");
        String dniUsuario = sc.nextLine();
        this.log("Rol trabajador: ");
        Trabajador trabajadorCreado = null;
        while(!rolTrabajadorValido) {
            String rolTrabajador = sc.nextLine().toUpperCase();
            switch(rolTrabajador) {
                case "ADMINISTRADOR":
                    trabajadorCreado = new Administrador(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    break;
                case "MANTENIMIENTO":
                    trabajadorCreado = new EncargadoDeMantenimiento(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    break;
                case "MECANICO":
                    trabajadorCreado = new Mecanico(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    break;
                default:
                    this.log("Los únicos tipos aceptados son: ADMINISTRADOR, MANTENIMIENTO o MECANICO");
            }
        }
        return trabajadorCreado;
    }
    
    private Vehiculo obtenerDatosVehiculo() {
        boolean vehiculoTipoValido = false;
        TipoVehiculo tipo = null;
        this.log("Matricula vehiculo: ");
        String matricula = sc.nextLine();
        this.log("Tipo vehiculo: ");
        while(!vehiculoTipoValido) {
            String rolTrabajador = sc.nextLine().toUpperCase();
            switch(rolTrabajador) {
                case "BICICLETA":
                    tipo = TipoVehiculo.BICICLETA;
                    break;
                case "PATINETE":
                    tipo = TipoVehiculo.PATINETE;
                    break;
                case "MOTO":
                    tipo = TipoVehiculo.MOTO;
                    break;
                default:
                    this.log("Los únicos tipos aceptados son: BICICLETA, PATINETE o MOTO");
            }
        }
        return new Vehiculo(tipo, matricula);
    }
}

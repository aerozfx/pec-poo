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
        this.procesoCerrado = false;
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
                    this.log("\nEstos son los trabajadores registrados en el sistema\n");
                    this.listarTrabajadores();
                    break;
                case "4":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionUsuarios();
                    break;
                case "5":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionVehiculos();
                    break;
                case "6":
                    this.log("\n¿Qué operación quieres realizar?:\n");
                    this.gestionarOpcionesGestionTrabajador();
                    break;
                case "7":
                    this.log("\n¿Qué tarifa quieres modificar?:\n");
                    this.gestionarModificacionTarifas();
                    break;
                case "8":
                    this.procesoCerrado = true;
                    break;
                default:
                    this.log("Esa opción no existe!");
                    
            }
        }
 
        
    }
    
    private void listarOpcionesAdministrador() {
        this.log("MENÚ ADMINISTRADOR");
        this.log("1) Listar usuarios");
        this.log("2) Listar información de vehículos");
        this.log("3) Listar trabajadores");
        this.log("4) Gestión usuarios");
        this.log("5) Gestión vehículos");
        this.log("6) Gestión trabajadores");
        this.log("7) Modificar tarifas");
        this.log("8) Volver al menú anterior");
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
                    this.log("El usuario con DNI: " + usuarioCreado.obtenerDni() + " ha sido creado");
                    break;
                case "2":
                    this.log("Introduce el DNI del usuario a editar:\n");
                    String dni = sc.nextLine();
                    Usuario usuarioEditado = this.obtenerDatosUsuario();
                    this.controladorAdministrador.editarUsuario(dni, usuarioEditado);
                    this.log("El usuario con DNI: " + usuarioEditado.obtenerDni() + " ha sido editado");
                    break;
                case "3":
                    this.log("Introduce el DNI del usuario a eliminar:\n");
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarUsuario(dniBorrado);
                    this.log("El usuario con DNI: " + dniBorrado + " ha sido eliminado");
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
                    Vehiculo vehiculoCreado = this.obtenerDatosVehiculo();
                    this.controladorAdministrador.crearVehiculo(vehiculoCreado);
                    this.log("El vehículo con matrícula " + vehiculoCreado.obtenerMatricula() + " ha sido creado y asignado a la base: " + vehiculoCreado.obtenerEstacionAsignada().obtenerNombreEstacion());
                    break;
                case "2":
                    this.log("Introduce la matricula del vehiculo a editar:\n");
                    this.listarVehiculos();
                    String dni = sc.nextLine();
                    Vehiculo vehiculoEditado = this.obtenerDatosVehiculo();
                    this.controladorAdministrador.editarVehiculo(dni, vehiculoEditado);
                    this.log("Vehículo con matrícula: " + vehiculoEditado.obtenerMatricula() + " ha sido actualizado!.");
                    break;
                case "3":
                    this.log("Introduce la matrícula del vehículo a eliminar:\n");
                    this.listarVehiculos();
                    String matriculaBorrada = sc.nextLine();
                    this.controladorAdministrador.eliminarVehiculo(matriculaBorrada);
                    this.log("Vehículo con matrícula: " + matriculaBorrada + " ha sido eliminado.");
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
                    Trabajador trabajadorCreado = this.obtenerDatosTrabajador();
                    this.controladorAdministrador.crearTrabajador(trabajadorCreado);
                    this.log("El trabajador con DNI: " + trabajadorCreado.obtenerDni() + " ha sido creado");
                    break;
                case "2":
                    this.log("Introduce el DNI del trabajador a editar:\n");
                    this.listarTrabajadores();
                    String dni = sc.nextLine();
                    Trabajador trabajadorEditado = this.obtenerDatosTrabajador();
                    this.controladorAdministrador.editarTrabajador(dni, trabajadorEditado);
                    this.log("El trabajador con DNI: " + trabajadorEditado.obtenerDni() + " ha sido editado");
                    break;
                case "3":
                    this.log("Introduce el DNI del trabajador a eliminar:\n");
                    this.listarTrabajadores();
                    String dniBorrado = sc.nextLine();
                    this.controladorAdministrador.eliminarTrabajador (dniBorrado);
                    this.log("El trabajador con DNI: " + dniBorrado + " ha sido eliminado");
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
                    break;
                case "3":
                    this.log("Introduce la nueva tarifa para motos:\n");
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
    
    private void listarEstacionesBase() {
        Collection<EstacionBase> estaciones = this.controladorAdministrador.obtenerEstacionesBase();
        for(EstacionBase estacion: estaciones) {
            estacion.obtenerInformacion();
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
        this.log("Rol trabajador: \n" + "Posibles opciones; ADMINISTRADOR, MANTENIMIENTO, MECANICO");
        Trabajador trabajadorCreado = null;
        while(!rolTrabajadorValido) {
            String rolTrabajador = sc.nextLine().toUpperCase();
            switch(rolTrabajador) {
                case "ADMINISTRADOR":
                    trabajadorCreado = new Administrador(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    rolTrabajadorValido = true;
                    break;
                case "MANTENIMIENTO":
                    trabajadorCreado = new EncargadoDeMantenimiento(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    rolTrabajadorValido = true;
                    break;
                case "MECANICO":
                    trabajadorCreado = new Mecanico(new Persona(dniUsuario, nombreUsuario, apellidoUsuario));
                    rolTrabajadorValido = true;
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
        this.log("Tipo vehiculo: \n" + "Posibles opciones: BICICLETA, PATINETE, MOTO");
        while(!vehiculoTipoValido) {
            String rolTrabajador = sc.nextLine().toUpperCase();
            switch(rolTrabajador) {
                case "BICICLETA":
                    tipo = TipoVehiculo.BICICLETA;
                    vehiculoTipoValido = true;
                    break;
                case "PATINETE":
                    tipo = TipoVehiculo.PATINETE;
                    vehiculoTipoValido = true;
                    break;
                case "MOTO":
                    tipo = TipoVehiculo.MOTO;
                    vehiculoTipoValido = true;
                    break;
                default:
                    this.log("Los únicos tipos aceptados son: BICICLETA, PATINETE o MOTO");
            }
        }
        this.log("Seleccione la base a la que se asignará el vehículo");
        this.listarEstacionesBase();
        String estacionBase = sc.nextLine();
        EstacionBase estacionElegida = this.controladorAdministrador.obtenerEstacionBase(estacionBase);
        return new Vehiculo(tipo, matricula, estacionElegida);
    }
    
}

package main.java.cl.awakelab.asesorias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import main.java.cl.awakelab.asesorias.models.Administrativo;
import main.java.cl.awakelab.asesorias.models.Capacitacion;
import main.java.cl.awakelab.asesorias.models.Cliente;
import main.java.cl.awakelab.asesorias.models.Contenedor;
import main.java.cl.awakelab.asesorias.models.Profesional;

/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 *
 *          clase principal del sistema contiene el menu principal
 */
public class Main {

	static Scanner sc = new Scanner(System.in);
	static Contenedor contenedor = new Contenedor();
	static int sistemaSalud, edad, antiguedadLaboral, cantidadAsistentes;
	static String identificador, opcionMenu;
	static String rut, nombres, apellidos, telefono, fechaNacimiento, afp, sisSalud, direccion, comuna, edadParaMostrar,
			nombreCompleto, titulo, fechaIngreso, area, experienciaPrevia, dia, hora, lugar, duracion,
			numeroDeAsistentes;

	/**
	 * metodo principal sistema
	 * 
	 * @param args los argumentos de la linea de comandos
	 */
	public static void main(String[] args) {

		do {
			Menu();
			try {
				metodoOpcion();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		} while (!opcionMenu.equals("9"));

	}

	/**
	 * metodo que despliega el menu principal
	 * 
	 */
	public static void Menu() {

		System.out.println("\n**********************************");
		System.out.println("*       BIENVENIDO A LA APP      *");
		System.out.println("**********************************");
		System.out.println("*         MENU PRINCIPAL         *");
		System.out.println("**********************************");
		System.out.println("* 1- Almacenar Cliente           *");
		System.out.println("* 2- Almacenar Profesional       *");
		System.out.println("* 3- Almacenar Administrativo    *");
		System.out.println("* 4- Almacenar Capacitacion      *");
		System.out.println("* 5- Eliminar Usuario            *");
		System.out.println("* 6- Listar Usuarios             *");
		System.out.println("* 7- Listar Usuarios por tipo    *");
		System.out.println("* 8- Listar Capacitaciones       *");
		System.out.println("* 9- Salir                       *");
		System.out.println("**********************************");
		System.out.print("\nElija una opcion : ");

	}

	/**
	 * Método que procesa la opción seleccionada por el usuario.
	 * 
	 * @throws InterruptedException Si ocurre una interrupción durante la ejecución.
	 */

	public static void metodoOpcion() throws InterruptedException {
		// aca solicitamos una opcion y ejecutamos la funcion del menu
		opcionMenu = sc.nextLine();
		System.out.println("");
		switch (opcionMenu) {
		case "1":
			casoAlmacenarCliente();
			break;
		case "2":
			casoAlmacenarProfesional();
			break;
		case "3":
			casoAlmacenarAdministrativo();
			break;
		case "4":
			casoAlmacenarCapacitacion();
			break;
		case "5":
			casoEliminarUsuario();
			break;
		case "6":
			contenedor.listarUsuarios();
			break;
		case "7":
			casoListarUsuariosPorTipo();
			break;
		case "8":
			contenedor.listarCapacitaciones();
			break;
		case "9":
			ValidacionesYExtras.salida();
			break;
		default:
			ValidacionesYExtras.imprimirMensajeEnRojo("     OPCION   NO   VALIDA     ");
		}
	}

	/**
	 * metodo que crea una nueva instancia para almacenar los datos de cliente
	 */
	public static void casoAlmacenarCliente() {
		Cliente cliente = new Cliente();

		// Acá ingresamos y validamos el rut
		System.out.print("Ingrese rut (sin puntos ni guion): ");
		rut = sc.nextLine();
		while (!ValidacionesYExtras.validarRut(rut)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡EL RUT INGRESADO NO ES VALIDO!");
			System.out.print("Ingrese rut (sin puntos ni guion): ");
			rut = sc.nextLine();
		}
		// Acá almacenamos el valor rut y deplegamos el valor almacenado
		cliente.setRut(rut);
		rut = ValidacionesYExtras.formatearRut(rut);
		ValidacionesYExtras.imprimirMensajeEnVerde(rut + " Se agregó correctamente.");

		// Acá ingresamos y validamos los nombres
		System.out.print("Ingrese sus nombres : ");
		nombres = sc.nextLine();
		while (!ValidacionesYExtras.validarNombres(nombres)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre debe contener de 5 a 30 caracteres!");
			System.out.print("Ingrese sus nombres: ");
			nombres = sc.nextLine();
		}
		nombres = ValidacionesYExtras.convertirInicialMayuscula(nombres);
		ValidacionesYExtras.imprimirMensajeEnVerde(nombres + " Se agregó correctamente.");

		// Acá almacenamos el valor nombres
		cliente.setNombres(nombres);

		// Acá ingresamos y validamos los apellidos
		System.out.print("Ingrese apellidos : ");
		apellidos = sc.nextLine();
		while (!ValidacionesYExtras.validarNombres(apellidos)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo apellidos debe contener de 5 a 30 caracteres!");
			System.out.print("Ingrese sus apellidos: ");
			apellidos = sc.nextLine();
		}
		apellidos = ValidacionesYExtras.convertirInicialMayuscula(apellidos);
		ValidacionesYExtras.imprimirMensajeEnVerde(apellidos + " Se agregó correctamente.");

		// Acá almacenamos el valor apellidos
		cliente.setApellidos(apellidos);

		// Acá ingresamos y validamos la fecha de nacimiento
		boolean fechaValida = false;
		do {
			while (!fechaValida) {
				System.out.print("Ingrese fecha de nacimiento (DD/MM/AAAA): ");
				fechaNacimiento = sc.nextLine();
				if (!fechaNacimiento.isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate.parse(fechaNacimiento, formatter);
						fechaValida = true; // Salir del bucle
					} catch (Exception e) {
						ValidacionesYExtras.imprimirMensajeEnRojo("¡Formato incorrecto!");
						fechaValida = false;
					}
				} else {
					fechaValida = false;
					ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo no puede estar vacío!");
				}

			}
			// Acá calculamos la edad a traves de la fecha de nacimiento
			edad = ValidacionesYExtras.calcularEdad(fechaNacimiento);
			if (edad < 0 || edad > 150) {
				fechaValida = false;
				edad = 0;
				ValidacionesYExtras.imprimirMensajeEnRojo("¡El rango de edad debe se entre 0 y 150 años!");
			}
		} while (!fechaValida);

		// Aca mostramnos edad
		System.out.println("\nSu edad es : " + edad + " años\n");

		// Acá almacenamos edad
		cliente.setEdad(edad);
		edad = 0;

		// Acá almacenamos la fecha de nacimiento
		cliente.setFechaNacimiento(fechaNacimiento);
		ValidacionesYExtras.imprimirMensajeEnVerde(fechaNacimiento + " Se agregó correctamente.");

		// Aca ingresamos y validamos el numero de telefono
		System.out.print("Ingrese teléfono (Ej.56912345678) : ");
		telefono = sc.nextLine();
		while (!ValidacionesYExtras.validarTelefono(telefono)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo telefono debe contener este formato (56912345678)!");
			System.out.print("Ingrese teléfono (Ej.56912345678) : ");
			telefono = sc.nextLine();
		}
		ValidacionesYExtras.imprimirMensajeEnVerde(telefono + " Se agregó correctamente.");

		// aca almacenamos el numero de telefono
		cliente.setTelefono(telefono);

		// Acá ingresamos y validamos la AFP
		System.out.print("Ingrese nombre de su AFP : ");
		afp = sc.nextLine();
		while (!ValidacionesYExtras.validarAfp(afp)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("El campo AFP debe contener de 4 a 30 caracteres!");
			System.out.print("Ingrese nombre de su AFP: ");
			afp = sc.nextLine();
		}
		afp = ValidacionesYExtras.convertirInicialMayuscula(afp);
		ValidacionesYExtras.imprimirMensajeEnVerde(afp + " Se agregó correctamente.");

		// Acá almacenamos el valor AFP
		cliente.setAfp(afp);

		// Acá ingresamos y validamos el sistema de salud
		System.out.print("Ingrese sistema de salud 1 (Fonasa) o 2 (Isapre) : ");
		sistemaSalud = ValidacionesYExtras.obtenerRangoValido(sc);
		if (sistemaSalud == 1) {
			sisSalud = "FONASA";
			ValidacionesYExtras.imprimirMensajeEnVerde(sisSalud + " Se agregó correctamente.");
		} else {
			sisSalud = "ISAPRE";
			ValidacionesYExtras.imprimirMensajeEnVerde(sisSalud + " Se agregó correctamente.");
		}

		// Acá almacenamos el valor sistemasalud
		cliente.setSistemaSalud(sisSalud);

		// Acá ingresamos y validamos que la direccion no este vacía
		System.out.print("Ingrese dirección : ");
		direccion = sc.nextLine();

		while (!ValidacionesYExtras.validarLargoDeCadena(direccion, 0, 70)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo direccion debe contener de maximo 70 caracteres!");
			System.out.print("Ingrese direccion: ");
			direccion = sc.nextLine();
		}
		direccion = ValidacionesYExtras.convertirInicialMayuscula(direccion);
		ValidacionesYExtras.imprimirMensajeEnVerde(direccion + " Se agregó correctamente.");

		// Acá almacenamos el valor direccion
		cliente.setDireccion(direccion);

		// Acá ingresamos y validamos que la comuna no este vacía
		System.out.print("Ingrese comuna : ");
		comuna = sc.nextLine();

		while (!ValidacionesYExtras.validarLargoDeCadena(comuna, 0, 50)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo comuna debe contener de maximo 50 caracteres!");
			System.out.print("Ingrese comuna: ");
			comuna = sc.nextLine();
		}
		comuna = ValidacionesYExtras.convertirInicialMayuscula(comuna);
		ValidacionesYExtras.imprimirMensajeEnVerde(comuna + " Se agregó correctamente.");

		// Acá almacenamos el valor comuna
		cliente.setComuna(comuna);

		// Acá guardamos el nombre completo en nombre del usuario
		cliente.setNombre(cliente.getNombres() + " " + cliente.getApellidos());

		// Acá guardamos la instancia cliente y desplegamos mensaje de registro exitoso
		contenedor.almacenarCliente(cliente);
		ValidacionesYExtras.imprimirMensajeEnVerde("El cliente ha sido registrado con éxito");
	}

	/**
	 * metodo que permite almacenar una nueva instancia profesional
	 */
	public static void casoAlmacenarProfesional() {

		Profesional profesional = new Profesional();

		// Acá ingresamos y validamos el rut
		System.out.print("Ingrese rut (sin puntos ni guion): ");
		rut = sc.nextLine();
		while (!ValidacionesYExtras.validarRut(rut)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡EL RUT INGRESADO NO ES VALIDO!");
			System.out.print("Ingrese rut (sin puntos ni guion): ");
			rut = sc.nextLine();
		}
		profesional.setRut(rut);
		rut = ValidacionesYExtras.formatearRut(rut);

		// Acá almacenamos el valor rut
		ValidacionesYExtras.imprimirMensajeEnVerde(rut + " Se agregó correctamente.");

		System.out.print("Ingrese nombre completo: ");
		nombreCompleto = sc.nextLine();
		while (!ValidacionesYExtras.validarNombreCompleto(nombreCompleto)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre completo debe contener de 10 a 50 caracteres!");
			System.out.print("Ingrese su nombre completo: ");
			nombreCompleto = sc.nextLine();
		}
		nombreCompleto = ValidacionesYExtras.convertirInicialMayuscula(nombreCompleto);
		profesional.setNombre(nombreCompleto);
		ValidacionesYExtras.imprimirMensajeEnVerde(nombreCompleto + " Se agregó correctamente.");

		// Acá ingresamos y validamos la fecha de nacimiento
		boolean fechaValida = false;
		do {
			while (!fechaValida) {
				System.out.print("Ingrese fecha de nacimiento (DD/MM/AAAA): ");
				fechaNacimiento = sc.nextLine();
				if (!fechaNacimiento.isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate.parse(fechaNacimiento, formatter);
						fechaValida = true; // Salir del bucle
					} catch (Exception e) {
						ValidacionesYExtras.imprimirMensajeEnRojo("¡Formato incorrecto!");
						fechaValida = false;
					}
				} else {
					fechaValida = false;
					ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo no puede estar vacío!");
				}

			}

			// Acá calculamos la edad a traves de la fecha de nacimiento
			edad = ValidacionesYExtras.calcularEdad(fechaNacimiento);
			if (edad < 0 || edad > 150) {
				fechaValida = false;
				edad = 0;
				ValidacionesYExtras.imprimirMensajeEnRojo("¡El rango de edad debe se entre 0 y 150 años!");
			}
		} while (!fechaValida);

		// Aça mostramnos edad
		System.out.println("\nSu edad es : " + edad + " años\n");
		edad = 0;

		// Acá almacenamos la fecha de nacimiento
		profesional.setFechaNacimiento(fechaNacimiento);
		ValidacionesYExtras.imprimirMensajeEnVerde(fechaNacimiento + " Se agregó correctamente.");

		System.out.print("Ingrese su titulo : ");
		titulo = sc.nextLine();
		while (!ValidacionesYExtras.validarLargoDeCadena(titulo, 10, 50)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre debe contener de 10 a 50 caracteres!");
			System.out.print("Ingrese su titulo : ");
			titulo = sc.nextLine();
		}
		titulo = ValidacionesYExtras.convertirInicialMayuscula(titulo);
		ValidacionesYExtras.imprimirMensajeEnVerde(titulo + " Se agregó correctamente.");

		// Acá almacenamos el valor area
		profesional.setTitulo(titulo);

		fechaValida = false;
		do {
			while (!fechaValida) {
				System.out.print("Ingrese fecha de ingreso (DD/MM/AAAA): ");
				fechaIngreso = sc.nextLine();
				if (!fechaIngreso.isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate.parse(fechaIngreso, formatter);
						fechaValida = true; // Salir del bucle
					} catch (Exception e) {
						ValidacionesYExtras.imprimirMensajeEnRojo("¡Formato incorrecto!");
						fechaValida = false;
					}
				} else {
					fechaValida = false;
					ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo no puede estar vacío!");
				}
			}

			// Acá calculamos la antiguedad laboral a traves de la fecha de ingreso
			antiguedadLaboral = ValidacionesYExtras.calcularEdad(fechaIngreso);
			if (antiguedadLaboral < 0) {
				fechaValida = false;
				antiguedadLaboral = 0;
				ValidacionesYExtras.imprimirMensajeEnRojo("¡La fecha de ingreso debe ser anterior a la fecha actual!");
			}
		} while (!fechaValida);

		// Acá almacenamos el valor fecha de ingreso
		profesional.setFechaIngreso(fechaIngreso);
		ValidacionesYExtras.imprimirMensajeEnVerde(fechaIngreso + " Se agregó correctamente.");

		// Acá almacenamos la instancia profesional
		contenedor.almacenarProfesional(profesional);
	}

	/**
	 * metodo utilizado para almacenar una instancia de clase administrativo
	 * 
	 */
	public static void casoAlmacenarAdministrativo() {
		Administrativo administrativo = new Administrativo();

		// Acá ingresamos y validamos el rut
		System.out.print("Ingrese rut (sin puntos ni guion): ");
		rut = sc.nextLine();
		while (!ValidacionesYExtras.validarRut(rut)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡EL RUT INGRESADO NO ES VALIDO!");
			System.out.print("Ingrese rut (sin puntos ni guion): ");
			rut = sc.nextLine();
		}
		administrativo.setRut(rut);
		rut = ValidacionesYExtras.formatearRut(rut);

		// Acá almacenamos el valor rut
		ValidacionesYExtras.imprimirMensajeEnVerde(rut + " Se agregó correctamente.");

		// aca ingresamos y validamos el nombre completo
		System.out.print("Ingrese nombre completo: ");
		nombreCompleto = sc.nextLine();
		while (!ValidacionesYExtras.validarNombreCompleto(nombreCompleto)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre completo debe contener de 10 a 50 caracteres!");
			System.out.print("Ingrese su nombre completo: ");
			nombreCompleto = sc.nextLine();
		}
		nombreCompleto = ValidacionesYExtras.convertirInicialMayuscula(nombreCompleto);

		// aca almacenamos el nombre completo
		administrativo.setNombre(nombreCompleto);
		ValidacionesYExtras.imprimirMensajeEnVerde(nombreCompleto + " Se agregó correctamente.");

		// Acá ingresamos y validamos la fecha de nacimiento
		boolean fechaValida = false;
		do {
			while (!fechaValida) {
				System.out.print("Ingrese fecha de nacimiento (DD/MM/AAAA): ");
				fechaNacimiento = sc.nextLine();
				if (!fechaNacimiento.isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate.parse(fechaNacimiento, formatter);
						fechaValida = true; // Salir del bucle
					} catch (Exception e) {
						ValidacionesYExtras.imprimirMensajeEnRojo("¡Formato incorrecto!");
						fechaValida = false;
					}
				} else {
					fechaValida = false;
					ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo no puede estar vacío!");
				}

			}

			// Acá calculamos la edad a traves de la fecha de nacimiento
			edad = ValidacionesYExtras.calcularEdad(fechaNacimiento);
			if (edad < 0 || edad > 150) {
				fechaValida = false;
				edad = 0;
				ValidacionesYExtras.imprimirMensajeEnRojo("¡El rango de edad debe se entre 0 y 150 años!");
			}
		} while (!fechaValida);

		// Aca mostramnos edad almcenada
		System.out.println("\nSu edad es : " + edad + " años\n");
		edad = 0;

		// Acá almacenamos la fecha de nacimiento
		administrativo.setFechaNacimiento(fechaNacimiento);
		ValidacionesYExtras.imprimirMensajeEnVerde(fechaNacimiento + " Se agregó correctamente.");

		// aca ingresamos y validamos el area de trabajo
		System.out.print("Ingrese área o departamento : ");
		area = sc.nextLine();
		while (!ValidacionesYExtras.validarLargoDeCadena(area, 5, 20)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre debe contener de 5 a 20 caracteres!");
			System.out.print("Ingrese área o departamento : ");
			area = sc.nextLine();
		}
		area = ValidacionesYExtras.convertirInicialMayuscula(area);
		ValidacionesYExtras.imprimirMensajeEnVerde(area + " Se agregó correctamente.");

		// Acá almacenamos el area de trabajo
		administrativo.setArea(area);

		// aca ingresamos y validamos la experiencia previa
		System.out.print("Experiencia previa : ");
		experienciaPrevia = sc.nextLine();
		while (!ValidacionesYExtras.validarLargoDeCadena(experienciaPrevia, 0, 100)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo nombre debe contener máximo 100 caracteres!");
			System.out.print("Experiencia previa : ");
			experienciaPrevia = sc.nextLine();
		}
		experienciaPrevia = ValidacionesYExtras.convertirInicialMayuscula(experienciaPrevia);
		ValidacionesYExtras.imprimirMensajeEnVerde(experienciaPrevia + " Se agregó correctamente.");

		// Acá almacenamos el valor experiencia previa
		administrativo.setExperienciaPrevia(experienciaPrevia);

		// Acá almacenamos la instancia Administrativo
		contenedor.almacenarAdministrativo(administrativo);
	}

	/**
	 * metodo que almacena una nueva instancia de capacitacion
	 */
	public static void casoAlmacenarCapacitacion() {
		Capacitacion capacitacion = new Capacitacion();

		// aca ingresamos y validamos el numero identificador
		System.out.print("Ingrese identificador : ");
		identificador = sc.nextLine();
		while (!ValidacionesYExtras.validarIdentificador(identificador)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡Solo puedes ingresar números!");
			System.out.print("Ingrese identificador : ");
			identificador = sc.nextLine();
		}

		// aca almacenamos el valor del numero identificador
		capacitacion.setIdentificador(Long.parseLong(identificador));
		ValidacionesYExtras.imprimirMensajeEnVerde(identificador + " Se agregó correctamente.");

		// aca ingresamos y validamos el rut
		System.out.print("Ingrese rut (sin puntos ni guion): ");
		rut = sc.nextLine();
		while (!ValidacionesYExtras.validarRut(rut)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡EL RUT INGRESADO NO ES VALIDO!");
			System.out.print("Ingrese rut (sin puntos ni guion): ");
			rut = sc.nextLine();
		}

		// aca almacenamos el valor rut
		capacitacion.setRutCliente(rut);
		rut = ValidacionesYExtras.formatearRut(rut);
		ValidacionesYExtras.imprimirMensajeEnVerde(rut + " Se agregó correctamente.");

		// aca ingresamos y validamos el dia
		System.out.print("Ingrese día (Ej. lunes) : ");
		dia = ValidacionesYExtras.obtenerDiaValido(sc);

		// aca almacenamos el dia
		capacitacion.setDia(dia);
		ValidacionesYExtras.imprimirMensajeEnVerde(dia + " Se agregó correctamente.");

		// aca ingresamos y validamos la hora
		do {
			System.out.print("Ingrese una hora en formato 24 horas (HH:mm): ");
			hora = sc.nextLine();
		} while (!ValidacionesYExtras.validarHora(hora));

		ValidacionesYExtras.imprimirMensajeEnVerde(hora + " Se agregó correctamente.");

		// aca almacenamos la hora
		capacitacion.setHora(hora);

		// aca ingresamos y validamos el lugar
		System.out.print("Ingrese lugar : ");
		lugar = sc.nextLine();
		while (!ValidacionesYExtras.validarLargoDeCadena(lugar, 10, 50)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo lugar debe contener de 10 a 50 caracteres!");
			System.out.print("Ingrese lugar: ");
			lugar = sc.nextLine();
		}
		lugar = ValidacionesYExtras.convertirInicialMayuscula(lugar);
		ValidacionesYExtras.imprimirMensajeEnVerde(lugar + " Se agregó correctamente.");

		// Acá almacenamos el valor lugar
		capacitacion.setLugar(lugar);

		// aca ingresamos y validamos la duracion
		System.out.print("Ingrese duración : ");
		duracion = sc.nextLine();
		while (!ValidacionesYExtras.validarLargoDeCadena(duracion, 0, 70)) {
			ValidacionesYExtras.imprimirMensajeEnRojo("¡El campo duración debe contener máximo 70 caracteres!");
			System.out.print("Ingrese duración: ");
			duracion = sc.nextLine();
		}
		duracion = ValidacionesYExtras.convertirInicialMayuscula(duracion);
		ValidacionesYExtras.imprimirMensajeEnVerde(duracion + " Se agregó correctamente.");

		// Acá almacenamos el valor duración
		capacitacion.setDuracion(duracion);

		// Acá ingresamos y validamos el numero de asistentes
		System.out.print("Ingrese cantidad de asistentes (Max 999) : ");
		cantidadAsistentes = ValidacionesYExtras.validarNumeroAsistentes(sc);

		// aca almacenamos el valor cantidad de asistentes
		capacitacion.setCantidadAsistentes(cantidadAsistentes);
		ValidacionesYExtras.imprimirMensajeEnVerde(cantidadAsistentes + " Se agregó correctamente.");

		// Acá almacenamos la instancia capacitación
		contenedor.almacenarCapacitacion(capacitacion);

	}

	/**
	 * metodo utilizado para eliminar registros de usuario segun su rut
	 */
	public static void casoEliminarUsuario() {

		// mediante este ciclo solicitamos y validamos el rut del usuario a eliminar
		if (contenedor.contadorDeRegistros() == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN REGISTROS PARA ELIMINAR");
		} else {
			String rutAEliminar;
			System.out.println("5- Eliminar Usuario\n");
			System.out.print("Ingrese rut de usuario a eliminar (sin puntos ni guión) : ");
			rutAEliminar = sc.nextLine();
			contenedor.eliminarUsuario(rutAEliminar);// aca se elimina el usuario
		}
	}

	/**
	 * metodo utilizado para mostrar los registros segun el tipo de usuario al que
	 * pertenecen
	 */
	public static void casoListarUsuariosPorTipo() {
		// solicitamos y validamos el tipo de usuario a listar
		if (contenedor.contadorDeRegistros() == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN REGISTROS PARA MOSTRAR");
		} else {
			int opcionTipoUsuario;
			do {
				System.out.print("Ingrese tipo de usuario\n(1 = Cliente | 2 = Profesional | 3 = Administrativo) : ");
				opcionTipoUsuario = sc.nextInt();
				sc.nextLine();
				switch (opcionTipoUsuario) { // aca mostramos los datos segun el tipo de usurio seleccionado
				case 1:
					contenedor.listarUsuariosPorTipo("Cliente");
					break;
				case 2:
					contenedor.listarUsuariosPorTipo("Profesional");
					break;
				case 3:
					contenedor.listarUsuariosPorTipo("Administrativo");
					break;
				default:
					ValidacionesYExtras.imprimirMensajeEnRojo("     OPCION   NO   VALIDA     ");
					break;
				}
			} while (opcionTipoUsuario < 1 || opcionTipoUsuario > 3);
		}

	}

}

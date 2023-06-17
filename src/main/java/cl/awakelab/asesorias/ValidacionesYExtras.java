package main.java.cl.awakelab.asesorias;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 *
 *          clase validaciones y extras contiene las validaciones de los datos
 *          ingresados al sistema y elementos visuales
 */
public class ValidacionesYExtras {

	/**
	 * Metodo para imprimir los mensajes en rojo
	 * 
	 * @param texto recibe un texto para luego darle un diseño dentro de un recuadro
	 */
	public static void imprimirMensajeEnRojo(String texto) {
		int anchoCaja = texto.length() + 4; // Ancho de la caja (texto + márgenes)

		// Imprimir borde superior
		System.out.println("\u001B[31m*" + "*".repeat(anchoCaja - 2) + "*\u001B[0m");

		// Imprimir línea de texto con fondo y color

		System.out.print("\u001B[31m\u001B[40m* \u001B[37m" + texto + " \u001B[31m\u001B[40m*\u001B[0m");
		System.out.println();

		// Imprimir borde inferior
		System.out.println("\u001B[31m*" + "*".repeat(anchoCaja - 2) + "*\u001B[0m");
		System.out.println("");
	}

	/**
	 * Metodo para imprimir los mensajes en verde
	 * 
	 * @param texto recibe un texto para luego darle un diseño dentro de un recuadro
	 */
	public static void imprimirMensajeEnVerde(String texto) {
		int anchoCaja = texto.length() + 4; // Ancho de la caja (texto + márgenes)

		// Imprimir borde superior
		System.out.println("\u001B[32m*" + "*".repeat(anchoCaja - 2) + "*\u001B[0m");

		// Imprimir línea de texto con fondo y color verde
		System.out.print("\u001B[32m\u001B[40m* \u001B[37m" + texto + " \u001B[32m\u001B[40m*\u001B[0m");
		System.out.println();

		// Imprimir borde inferior
		System.out.println("\u001B[32m*" + "*".repeat(anchoCaja - 2) + "*\u001B[0m");
		System.out.println("");
	}

	/**
	 * metodo para imprimir los mensajes en amarillo
	 * 
	 * @param texto recibe un texto para luego darle un diseño dentro de un recuadro
	 */
	public static void imprimirTextoAmarillo(String texto) {

		// Imprimir texto en color amarillo intenso, letras en negrita y fondo negro
		System.out.println("\u001B[33;1m\u001B[40m" + texto + "\u001B[0m");
	}

	/**
	 * Método para el mensaje de salida
	 */
	public static void salida() {
		String mensajeGrande = " ::::::::  :::::::::  :::    ::: :::::::::   ::::::::    ::::::::  \n"
				+ ":+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:    :+: \n"
				+ "+:+        +:+    +:+ +:+    +:+ +:+    +:+ +:+    +:+         +:+ \n"
				+ ":#:        +#++:++#:  +#+    +:+ +#++:++#+  +#+    +:+      +#++:  \n"
				+ "+#+   +#+# +#+    +#+ +#+    +#+ +#+        +#+    +#+         +#+ \n"
				+ "#+#    #+# #+#    #+# #+#    #+# #+#        #+#    #+#  #+#    #+# \n"
				+ " ########  ###    ###  ########  ###         ########    ########  \n";
		ValidacionesYExtras.imprimirTextoAmarillo(mensajeGrande);
		String texto = "¡AGUANTE EL GRUPO 3!";
		String[] colores = { "\u001B[101m", "\u001B[102m", "\u001B[103m", "\u001B[104m", "\u001B[105m", "\u001B[106m" };
		String[] coloresTexto = { "\u001B[30;1m", "\u001B[30;1m", "\u001B[30;1m", "\u001B[30;1m", "\u001B[30;1m",
				"\u001B[30;1m" };

		for (int i = 0; i < texto.length(); i++) {
			System.out.print(
					colores[i % colores.length] + coloresTexto[i % coloresTexto.length] + " " + texto.charAt(i) + " ");
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("\u001B[0m");
		}
		System.out.println("");
		System.out.println("\n---------------------------INTEGRANTES------------------------");
		ValidacionesYExtras.imprimirTextoAmarillo("Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton.");
	}

	/**
	 * Método para validar el nombre
	 * 
	 * @param nombres recibe un nombre como texto y valida si son solo letras con un
	 *                largo especifico
	 * @return devuelve falso si la validacion es negativa y verdadero en caso de
	 *         ser positiva
	 */
	public static boolean validarNombres(String nombres) {
		if (nombres.length() < 5 || nombres.length() > 30) {
			return false;
		}
		if (!nombres.matches("[a-zA-ZñÑ\\s]+")) {
			return false;
		}
		return true;
	}

	/**
	 * Método para cambiar a mayuscula la inicial de los nombres
	 * 
	 * @param nombres recibe un nombre como texto y convierte a mayusculas todas las
	 *                iniciales
	 * @return devuelve un string con las iniciales en mayusculas
	 */
	public static String convertirInicialMayuscula(String nombres) {
		String[] palabras = nombres.split("\\s+");
		StringBuilder resultado = new StringBuilder();
		for (String palabra : palabras) {
			if (!palabra.isEmpty()) {
				resultado.append(palabra.substring(0, 1).toUpperCase());
				resultado.append(palabra.substring(1)).append(" ");
			}
		}
		return resultado.toString().trim();
	}

	/**
	 * Método para validar el rut
	 * 
	 * @param rut recibe un rut como texto y valida numeros y caracteres permitidos
	 * @return devuelve el rut validado
	 */
	public static boolean validarRut(String rut) {
		return rut.matches("[0-9]{1,2}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9kK]{1}");
	}

	/**
	 * metodo que da formato al rut
	 * 
	 * @param rut recibe un rut como texto y le da formato (12.345.678-9)
	 * @return devuelve el rut formateado
	 */
	public static String formatearRut(String rut) {
		rut = rut.replaceAll("[^0-9kK]", "").toUpperCase();
		if (rut.length() > 1) {
			rut = rut.substring(0, rut.length() - 1) + "-" + rut.charAt(rut.length() - 1);
		}
		rut = rut.replaceAll("([0-9])(?=([0-9]{3})+(?![0-9]))", "$1.");
		return rut;
	}

	/**
	 * metodo que valida el valor ingresado para sistema de salud
	 * 
	 * @param scanner recibe un valor por teclado
	 * @return devuelve un numero validado
	 */
	public static int obtenerRangoValido(Scanner scanner) {
		int numero = 0;
		boolean valido = false;

		while (!valido) {
			String entrada = scanner.nextLine();

			if (entrada.matches("[1-2]")) {
				numero = Integer.parseInt(entrada);
				valido = true;
			} else {
				imprimirMensajeEnRojo("¡Entrada inválida!");
				System.out.print("Ingrese nuevamente: ");
			}
		}
		System.out.println(numero);
		return numero;
	}

	/**
	 * metodo utilizado para validar la string afp ingresada
	 * 
	 * @param afp recibe nombre de afp
	 * @return verdadero o falso en caso de estar validado o no
	 */
	public static boolean validarAfp(String afp) {
		if (afp.length() < 4 || afp.length() > 30) {
			return false;
		}
		if (!afp.matches("[a-zA-Z\\s]+")) {
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para validar el nombre completo de usuario
	 * 
	 * @param nombreCompleto recibe un nombre completo
	 * @return *
	 */
	public static boolean validarNombreCompleto(String nombreCompleto) {
		if (nombreCompleto.length() < 10 || nombreCompleto.length() > 50) {
			return false;
		}
		if (!nombreCompleto.matches("[a-zA-ZñÑ\\s]+")) {
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para calcular edad del usuario segun la fecha de nacimiento
	 * 
	 * @param fechaNacimiento recibe fecha de nacimiento como string
	 * @return *
	 */
	public static int calcularEdad(String fechaNacimiento) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimientoDate = LocalDate.parse(fechaNacimiento, formatter);
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimientoDate, fechaActual);
		int edad = periodo.getYears();
		return edad;
	}

	/**
	 * metodo utilizado para validar el numero identificador de la capacitacion
	 * 
	 * @param id recibe un ID como string
	 * @return *
	 */
	public static boolean validarIdentificador(String id) {

		if (!id.matches("^\\d{1,18}$")) {
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para validar el numero de Telefono
	 * 
	 * @param telefono recibe un telefono como string
	 * @return *
	 */
	public static boolean validarTelefono(String telefono) {

		if (!telefono.matches("\\d{11}")) {
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para validar el dia ingresado
	 * 
	 * @param scanner recibe un valor por teclado
	 * @return devuelve un numero validado
	 */
	public static String obtenerDiaValido(Scanner scanner) {
		String dia = null;
		boolean valido = false;
		String listadoDeDias = "(?i)lunes|martes|miercoles|jueves|viernes|sabado|domingo";

		while (!valido) {
			String diaIngresado = scanner.nextLine();

			if (Pattern.matches(listadoDeDias, diaIngresado)) {
				dia = convertirInicialMayuscula(diaIngresado.toLowerCase());
				valido = true;
			} else {
				imprimirMensajeEnRojo("¡Entrada inválida!");
				System.out.print("Ingrese nuevamente: ");
				valido = false;
			}
		}
		return dia;
	}

	/**
	 * metodo utilizado para validar un rango especifico de caracteres en la string
	 * ingresada
	 * 
	 * @param cadena      recibe una cadena
	 * @param largoMinimo recibe el larmo minimo que debe tener el texto validado
	 * @param largoMaximo recibe el larmo maximo que debe tener el texto validado
	 * @return confirma que la string ingresada esta en el rango correcto, dentro de
	 *         los parametros ingresados.
	 */
	public static boolean validarLargoDeCadena(String cadena, int largoMinimo, int largoMaximo) {
		if (cadena.length() == 0 && largoMinimo == 0) {
			return true;
		}
		if (cadena.length() < largoMinimo || cadena.length() > largoMaximo) {
			return false;
		}
		if (!cadena.matches("[0-9a-zA-Z\\s]+")) {
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para validar la hora ingresada
	 * 
	 * @param hora recibe una hora como string
	 * @return *
	 * 
	 */
	public static boolean validarHora(String hora) {
		if (hora.isEmpty()) {
			imprimirMensajeEnRojo("La hora no puede estar vacía.");
			return false;
		}
		String[] partes = hora.split(":");
		if (partes.length != 2) {
			imprimirMensajeEnRojo("La hora debe tener el formato HH:mm");
			return false;
		}
		try {
			int horas = Integer.parseInt(partes[0]);
			int minutos = Integer.parseInt(partes[1]);

			if (horas < 0 || horas > 23) {
				imprimirMensajeEnRojo("Las horas deben estar entre 0 y 23.");
				return false;
			}
			if (minutos < 0 || minutos > 59) {
				imprimirMensajeEnRojo("Los minutos deben estar entre 0 y 59.");
				return false;
			}
		} catch (NumberFormatException e) {
			imprimirMensajeEnRojo("La hora debe ser un número válido.");
			return false;
		}
		return true;
	}

	/**
	 * metodo utilizado para validar el numero de asistentes ingresado
	 * 
	 * @param scanner recibe un valor por teclado
	 * @return devuelve un numero validado
	 */
	public static int validarNumeroAsistentes(Scanner scanner) {

		int asistentes = 0;
		boolean valido = false;
		String asistentesPermitidos = "^(?:[1-9]|[1-9][0-9]|[1-9][0-9]{2}|999)$";

		while (!valido) {
			String numeroAsistentesIngresado = scanner.nextLine();
			if (Pattern.matches(asistentesPermitidos, numeroAsistentesIngresado)) {
				asistentes = Integer.parseInt(numeroAsistentesIngresado);
				valido = true;
			} else {
				imprimirMensajeEnRojo("¡Entrada fuera de rango!");
				System.out.print("Ingrese nuevamente: ");
				valido = false;
			}
		}
		return asistentes;
	}
}

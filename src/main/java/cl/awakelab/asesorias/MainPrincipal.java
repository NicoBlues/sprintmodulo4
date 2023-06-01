package main.java.cl.awakelab.asesorias;

import java.util.Scanner;

import main.java.cl.awakelab.asesorias.models.Cliente;
import main.java.cl.awakelab.asesorias.models.Contenedor;

public class MainPrincipal {
	static Scanner sc = new Scanner(System.in);
	static int opcionMenu;
	static boolean opcionValidador = false;
	static Contenedor contenedor = new Contenedor();

	public static void main(String[] args) {

		do {
			Menu();
			opcionMenu = sc.nextInt();
			sc.nextLine();
			if (opcionMenu < 1 || opcionMenu > 9) {
				System.out.println("Ingrese otro");
				opcionValidador = false;
			} else {
				metodoOpcion();
				opcionValidador = true;
			}
		} while (!opcionValidador);
	}

	public static void Menu() {

		System.out.println("╔════════════════════════════════╗");
		System.out.println("║       BIENVENIDO A LA APP      ║");
		System.out.println("╠════════════════════════════════╣");
		System.out.println("║          MENU PRINCIPAL        ║");
		System.out.println("╠════════════════════════════════╣");
		System.out.println("║ 1- Almacenar Cliente           ║");
		System.out.println("║ 2- Almacenar Profesional       ║");
		System.out.println("║ 3- Almacenar Administrativo    ║");
		System.out.println("║ 4- Almacenar Capacitacion      ║");
		System.out.println("║ 5- Eliminar Usuario            ║");
		System.out.println("║ 6- Listar Usuarios             ║");
		System.out.println("║ 7- Listar Usuarios por tipo    ║");
		System.out.println("║ 8- Listar Capacitaciones       ║");
		System.out.println("║ 9- Salir                       ║");
		System.out.println("╚════════════════════════════════╝");
		System.out.print("\nElija una opcion : ");

	}

	public static void metodoOpcion() {
		boolean volverAlMenu = false;
		boolean ingresoUsuario = false;
		int respuesta;
		switch (opcionMenu) {
		case 1:
			do {
				Cliente cliente = new Cliente();
				System.out.print("Ingrese rut : ");
				cliente.setRut(sc.nextLine());

				System.out.print("Ingrese nombres : ");
				cliente.setNombres(sc.nextLine());

				System.out.print("Ingrese apellidos : ");
				cliente.setApellidos(sc.nextLine());

				System.out.print("Ingrese teléfono : ");
				cliente.setTelefono(sc.nextLine());

				System.out.print("Ingrese AFP : ");
				cliente.setAfp(sc.nextLine());

				System.out.print("Ingrese sistema de salud 1 (Fonasa) o 2 (Isapre) : ");
				cliente.setSistemaSalud(sc.nextInt());
				sc.nextLine();

				System.out.print("Ingrese dirección : ");
				cliente.setDireccion(sc.nextLine());

				System.out.print("Ingrese comuna : ");
				cliente.setComuna(sc.nextLine());

				System.out.print("Ingrese edad : ");
				cliente.setEdad(sc.nextInt());
				sc.nextLine();

				contenedor.almacenarCliente(cliente);
				System.out.println("Clientes almacenados: ");
				/*
				 * for(Cliente clienteAlmacenado : contenedor.getClientes()) {
				 * System.out.println(contenedor); }
				 */
				System.out.println(
						"╔═════════════════════════════════════════════════════════════════════════════════════╗");
				System.out.println(
						"║                        LISTA DE CLIENTES                                            ║");
				System.out.println(
						"╠═════════════════════════════════════════════════════════════════════════════════════╣");
				System.out.printf("║ %-13s | %-20s | %-20s | %-5s | %-10s | %-10s | %-10s | %-20s | %-10s ║%n", "RUN",
						"NOMBRES", "APELLIDOS", "EDAD", "TELÉFONO", "AFP", "SIS. SALUD", "DIRECCIÓN", "COMUNA");
				System.out.println("╠══════════════════════════════════════════════════════════╣");

				for (Cliente clienteAlmacenado : contenedor.getClientes()) {
					System.out.printf("║ %-13s | %-20s | %-20s | %-5d | %-10s | %-10s | %-10s | %-20s | %-10s ║%n",
							clienteAlmacenado.getRut(), clienteAlmacenado.getNombres(),
							clienteAlmacenado.getApellidos(), clienteAlmacenado.getEdad(),
							clienteAlmacenado.getTelefono(), clienteAlmacenado.getAfp(),
							clienteAlmacenado.getSistemaSalud(), clienteAlmacenado.getDireccion(),
							clienteAlmacenado.getComuna());
				}

				System.out.println("╚══════════════════════════════════════════════════════════╝");

				System.out.println("1-Volver al menu principal.\n2-Agregar otro cliente.\n3-Salir");
				System.out.print("Ingrese su opcion: ");
				respuesta = sc.nextInt();
				sc.nextLine();
				if (respuesta == 1) {
					ingresoUsuario = true;
					Menu();
					opcionMenu = sc.nextInt();
					sc.nextLine();
				} else if (respuesta == 2) {
					ingresoUsuario = false;
				} else if (respuesta == 3) {
					System.exit(0);
				}
			} while (!ingresoUsuario);
			break;
		case 2:
			System.out.println("Paso 2");
			break;
		case 3:
			System.out.println("Paso 3");
			break;
		case 4:
			System.out.println("Paso 4");
			break;
		case 5:
			System.out.println("Paso 5");
			break;
		case 6:
			System.out.println("Paso 6");
			break;
		case 7:
			System.out.println("Paso 7");
			break;
		case 8:
			System.out.println("Paso 8");
			break;
		case 9:
			System.out.println("Saliste");
			break;

		}
	}

}
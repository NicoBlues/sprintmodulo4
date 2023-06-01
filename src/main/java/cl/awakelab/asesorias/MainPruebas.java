package main.java.cl.awakelab.asesorias;

import java.util.Scanner;

import main.java.cl.awakelab.asesorias.models.Administrativo;
import main.java.cl.awakelab.asesorias.models.Cliente;
import main.java.cl.awakelab.asesorias.models.Contenedor;
import main.java.cl.awakelab.asesorias.models.Profesional;

public class MainPruebas {

	static Scanner sc = new Scanner(System.in);
	static int opcionMenu;
	static Contenedor contenedor = new Contenedor();

	public static void main(String[] args) {

		do {
			Menu();
			metodoOpcion();
		} while (opcionMenu != 9);

	}

	public static void Menu() {

		System.out.println("\n╔════════════════════════════════╗");
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

		opcionMenu = sc.nextInt();
		sc.nextLine();
		System.out.println("");
		switch (opcionMenu) {
		case 1:
			metodoCaso1();
			break;
		case 2:
			metodoCaso2();
			break;
		case 3:
			metodoCaso3();
			break;
		case 4:
			System.out.println("Caso 4");
			break;
		case 5:
			System.out.println("Caso 5");
			contenedor.eliminarUsuario("222");
			break;
		case 6:
			contenedor.listarUsuarios();
			break;
		case 7:
			metodoCaso7();
			break;
		case 8:
			System.out.println("Caso 8");
			break;
		case 9:
			System.out.println("Saliste");
			break;
		default:
			System.out.println("------------------");
			System.out.println(" Opcion no valida");
			System.out.println("------------------");
		}
	}

	public static void metodoCaso1() {
		Cliente cliente = new Cliente();

		System.out.print("Ingrese rut : ");
		cliente.setRut(sc.nextLine());

		System.out.print("Ingrese nombres : ");
		cliente.setNombres(sc.nextLine());

		System.out.print("Ingrese apellidos : ");
		cliente.setApellidos(sc.nextLine());

		System.out.print("Ingrese fecha de nacimiento : ");
		cliente.setFechaNacimiento(sc.nextLine());

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
		cliente.setNombre(cliente.getNombres() + " " + cliente.getApellidos());

		contenedor.almacenarCliente(cliente);
	}

	public static void metodoCaso2() {
		Profesional profesional = new Profesional();

		System.out.print("Ingrese rut : ");
		profesional.setRut(sc.nextLine());

		System.out.print("Ingrese nombre completo : ");
		profesional.setNombre(sc.nextLine());

		System.out.print("Ingrese fecha de nacimiento : ");
		profesional.setFechaNacimiento(sc.nextLine());

		System.out.print("Ingrese titulo : ");
		profesional.setTitulo(sc.nextLine());

		System.out.print("Ingrese fecha de ingreso : ");
		profesional.setFechaIngreso(sc.nextLine());

		contenedor.almacenarProfesional(profesional);
	}

	public static void metodoCaso3() {
		Administrativo administrativo = new Administrativo();

		System.out.print("Ingrese rut : ");
		administrativo.setRut(sc.nextLine());

		System.out.print("Ingrese nombre completo : ");
		administrativo.setNombre(sc.nextLine());

		System.out.print("Ingrese fecha de nacimiento : ");
		administrativo.setFechaNacimiento(sc.nextLine());

		System.out.print("Ingrese área : ");
		administrativo.setArea(sc.nextLine());

		System.out.print("Experiencia previa : ");
		administrativo.setExperienciaPrevia(sc.nextLine());

		contenedor.almacenarAdministrativo(administrativo);
	}

	public static void metodoCaso4() {

	}

	public static void metodoCaso5() {

	}

	public static void metodoCaso6() {

	}

	public static void metodoCaso7() {
		int opcionTipoUsuario;
		do {
			System.out.print("Ingrese tipo de usuario\n(1 = Cliente | 2 = Profesional | 3 = Administrativo) : ");
			opcionTipoUsuario = sc.nextInt();
			sc.nextLine();
			switch (opcionTipoUsuario) {
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
				System.out.println("------------------");
				System.out.println(" Opcion no valida");
				System.out.println("------------------");
				break;
			}
		} while (opcionTipoUsuario < 1 || opcionTipoUsuario > 3);

	}

}
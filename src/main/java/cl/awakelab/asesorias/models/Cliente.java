package main.java.cl.awakelab.asesorias.models;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

public class Cliente extends Usuario implements IAsesoria {

	private String rut = null;
	private String nombres = null;
	private String apellidos = null;
	private String telefono = null;
	private String afp = null;
	private int sistemaSalud = 0;
	private String direccion = null;
	private String comuna = null;
	private int edad = 0;

	// Constructor
	public Cliente() {

	}

	public Cliente(String nombre, String fechaNacimiento, String rut, String nombres, String apellidos, String telefono,
			String afp, int sistemaSalud, String direccion, String comuna, int edad) {

		super(nombre, fechaNacimiento, rut);

		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;

	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;

	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void obtenerNombre() {
		System.out.println(nombres + " " + apellidos);
	}

	public void obtenerSistemaSalud() {
		if (sistemaSalud == 1) {
			System.out.println("Su sistema de salud es FONASA");
		} else {
			System.out.println("Su sistema de salud es ISAPRE");
		}
	}

	@Override
	public String toString() {
		return "\nCliente:\n---------\nRut: " + rut + "\nNombres: " + nombres + "\nApellidos: " + apellidos
				+ "\nTelefono: " + telefono + "\nAfp: " + afp + "\nSistema Salud: " + sistemaSalud + "\nDireccion: "
				+ direccion + "\nComuna: " + comuna + "\nEdad: " + edad + "\nNombre usuario: " + this.getNombre()
				+ "\n\n";
	}

	@Override
	public void analizarUsuario() {
		System.out.println("Datos de usuario : \n");
		super.analizarUsuario();
		System.out.println("--------------------");
		System.out.println(direccion);
		System.out.println(comuna);
	}
}

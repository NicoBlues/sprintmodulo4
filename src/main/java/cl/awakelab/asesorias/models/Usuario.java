package main.java.cl.awakelab.asesorias.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

public class Usuario implements IAsesoria {

	private String nombre;
	private String fechaNacimiento;
	private String rut;

	// Constructor
	public Usuario() {

	}

	public Usuario(String nombre, String fechaNacimiento, String rut) {

		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", rut=" + rut + "]";
	}

	public void mostrarEdad(String fechaNacimiento) {

		// 01/01/2000
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		System.out.printf("Tu edad es: %s años, %s meses y %s días", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
	}

	@Override
	public void analizarUsuario() {
		System.out.println("Nombre : " + nombre);
		System.out.println("Rut : " + rut);
	}
}

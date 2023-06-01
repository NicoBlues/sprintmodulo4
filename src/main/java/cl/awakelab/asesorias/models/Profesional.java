package main.java.cl.awakelab.asesorias.models;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

public class Profesional extends Usuario implements IAsesoria {

	private String titulo;
	private String fechaIngreso;

	// Constructor
	public Profesional() {

	}

	public Profesional(String nombre, String fechaNacimiento, String rut, String titulo, String fechaIngreso) {

		super(nombre, fechaNacimiento, rut);

		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "\nProfesional:\n------------\nRut : " + this.getRut() + "\nNombre : " + this.getNombre()
				+ "\nFecha de nacimiento : " + this.getFechaNacimiento() + "\nTitulo : " + titulo
				+ "\nFecha de ingreso: " + fechaIngreso + "\n\n";
	}

	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Titulo: " + titulo);
		System.out.println("Fecha ingreso: " + fechaIngreso);
	}
}

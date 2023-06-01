package main.java.cl.awakelab.asesorias.models;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

public class Administrativo extends Usuario implements IAsesoria {

	private String area;
	private String experienciaPrevia;

	// Constructor
	public Administrativo() {

	}

	public Administrativo(String nombre, String fechaNacimiento, String rut, String area, String experienciaPrevia) {

		super(nombre, fechaNacimiento, rut);

		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return "\nAdministrativo:\n---------------\nRut : " + this.getRut() + "\nNombre : " + this.getNombre()
				+ "\nFecha de nacimiento : " + this.getFechaNacimiento() + "\nÁrea : " + area
				+ "\nExperiencia previa : " + experienciaPrevia + "\n\n";
	}

	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Area: " + area);
		System.out.println("Experiencia previa: " + experienciaPrevia);
	}
}

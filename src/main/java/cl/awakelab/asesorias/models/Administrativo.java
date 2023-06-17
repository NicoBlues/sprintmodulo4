package main.java.cl.awakelab.asesorias.models;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 * 
 *          clase administrativo se extiende de usurio e implementa la
 *          IAsesoria, y contiene el constructor para crear sus instancias.
 */
public class Administrativo extends Usuario implements IAsesoria {

	private String area;
	private String experienciaPrevia;

	// Constructor vacio
	public Administrativo() {

	}

	// constructor con parametros aptos para nuevos datos
	public Administrativo(String nombre, String fechaNacimiento, String rut, String area, String experienciaPrevia) {

		super(nombre, fechaNacimiento, rut);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	// getters and setters
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

	// metodo utilizado para desplegar los datos por pantalla
	@Override
	public String toString() {
		return "\nAdministrativo:\n---------------\nRut : " + this.getRut() + "\nNombre : " + this.getNombre()
				+ "\nFecha de nacimiento : " + this.getFechaNacimiento() + "\nArea : " + area
				+ "\nExperiencia previa : " + experienciaPrevia + "\n\n";
	}

	// metodo utilizado para desplegar la instancia administrativo en pantalla
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Area: " + area);
		System.out.println("Experiencia previa: " + experienciaPrevia);
	}
}

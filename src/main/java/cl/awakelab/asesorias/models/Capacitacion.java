package main.java.cl.awakelab.asesorias.models;
/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 *
 * clase capacitacion contiene el constructor para crear sus instancias.
 * 
 */
public class Capacitacion {

	private Long identificador;
	private String rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;

	//constructor vacio
	public Capacitacion() {
	}
	//constructor con parametros aptos para nuevos datos
	public Capacitacion(Long identificador, String rutCliente, String dia, String hora, String lugar, String duracion,
			int cantidadAsistentes) {

		this.identificador = identificador;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}
	//getters and setters
	public Long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}
	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}
	//metodo utilizado para mostrar los detalles de la capacitacion por pantalla
	public void mostrarDetalles() {
		System.out.println("La capacitacion sera en " + lugar + ", a las " + hora + ", el dia " + dia + " y durará "
				+ duracion + " minutos.");
	}
	//metodo utilizado para desplegar los datos por pantalla 
	@Override
	public String toString() {
		return "\nCapacitacion : \n-------------\nidentificador : " + identificador + "\nrutCliente : " + rutCliente
				+ "\ndia:" + dia + "\nhora: " + hora + "\nlugar : " + lugar + "\nduracion : " + duracion
				+ "\ncantidadAsistentes : " + cantidadAsistentes + "\n\n";
	}
}

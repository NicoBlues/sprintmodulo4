package main.java.cl.awakelab.asesorias.models;

import java.sql.Date;
import java.sql.Time;
/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 *
 *clase visita en terreno con sus parametros 
 */
public class VisitaTerreno {

	private int identificador;
	private String rut;
	private Date fecha;
	private Time hora;
	private String lugar;
	private String comentarios;

	// cosntructor vacio
	public VisitaTerreno() {
		super();
	}

	//constructor con parametros aptos para nuevos datos
	public VisitaTerreno(int identificador, String rut, Date fecha, Time hora, String lugar, String comentarios) {
		super();
		this.identificador = identificador;
		this.rut = rut;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

	//getters and setters
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	//metodo utilizado para desplegar los datos por pantalla 
	@Override
	public String toString() {
		return "VisitaTerreno [identificador=" + identificador + ", rut=" + rut + ", fecha=" + fecha + ", hora=" + hora
				+ ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
	}

}

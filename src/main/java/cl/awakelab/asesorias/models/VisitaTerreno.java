package main.java.cl.awakelab.asesorias.models;

import java.sql.Date;
import java.sql.Time;

public class VisitaTerreno {

	private int identificador;
	private String rut;
	private Date fecha;
	private Time hora;
	private String lugar;
	private String comentarios;

	public VisitaTerreno() {
		super();
	}

	public VisitaTerreno(int identificador, String rut, Date fecha, Time hora, String lugar, String comentarios) {
		super();
		this.identificador = identificador;
		this.rut = rut;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

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

	@Override
	public String toString() {
		return "VisitaTerreno [identificador=" + identificador + ", rut=" + rut + ", fecha=" + fecha + ", hora=" + hora
				+ ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
	}

}

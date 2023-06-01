package main.java.cl.awakelab.asesorias.models;

import java.sql.Time;
import java.util.Date;

public class Accidente {

	private int identificador;
	private String rut;
	private Date fecha;
	private Time hora;
	private String lugar;
	private String origen;
	private String consecuencias;

	public Accidente() {

	}

	public Accidente(int identificador, String rut, Date fecha, Time hora, String lugar, String origen,
			String consecuencias) {
		this.identificador = identificador;
		this.rut = rut;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.origen = origen;
		this.consecuencias = consecuencias;
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

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getConsecuencias() {
		return consecuencias;
	}

	public void setConsecuencias(String consecuencias) {
		this.consecuencias = consecuencias;
	}

	@Override
	public String toString() {
		return "Accidente [identificador=" + identificador + ", rut=" + rut + ", fecha=" + fecha + ", hora=" + hora
				+ ", lugar=" + lugar + ", origen=" + origen + ", consecuencias=" + consecuencias + "]";
	}

}

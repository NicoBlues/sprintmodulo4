package main.java.cl.awakelab.asesorias.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;

public class Contenedor {
	private List<IAsesoria> asesorias;
	private List<Capacitacion> capacitaciones;

	public Contenedor() {
		asesorias = new ArrayList<>();
		capacitaciones = new ArrayList<>();
	}

	public void almacenarCliente(Cliente cliente) {
		asesorias.add(cliente);
	}

	public void almacenarProfesional(Profesional profesional) {
		asesorias.add(profesional);
	}

	public void almacenarAdministrativo(Administrativo administrativo) {
		asesorias.add(administrativo);
	}

	public void almacenarCapacitacion(Capacitacion capacitacion) {
		capacitaciones.add(capacitacion);
	}

	public void mostrarAsesorias() {
		System.out.println("Asesorias: ");
		for (IAsesoria asesoria : asesorias) {
			asesoria.analizarUsuario();
		}
	}

	public void listarCapacitaciones() {
		System.out.println("Capacitaciones: ");
		for (Capacitacion capacitacion : capacitaciones) {
			capacitacion.mostrarDetalles();
		}
	}

	public void listarUsuarios() {
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				// System.out.println(asesoria.getClass());
				System.out.println(asesoria);
				System.out.println("----------------");
			}
		}

	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Cliente) {
				clientes.add((Cliente) asesoria);
			}
		}
		return clientes;
	}
	/*
	 * public void eliminarUsuario(String rut) {
	 * 
	 * for (IAsesoria asesoria : asesorias) { if (asesoria instanceof Usuario &&
	 * rut.equals(((Usuario) asesoria).getRut())) { asesorias.remove();
	 * System.out.println(asesoria.toString()); } } }
	 */

	public void eliminarUsuario(String rut) {

		Iterator<IAsesoria> posicionEliminarInstancia = asesorias.iterator();
		while (posicionEliminarInstancia.hasNext()) {
			IAsesoria asesoria = posicionEliminarInstancia.next();
			if (asesoria instanceof Usuario && rut.equals(((Usuario) asesoria).getRut())) {
				posicionEliminarInstancia.remove();
				System.out.println(asesoria.toString() + " eliminado");

			}
		}
	}

	public void listarUsuariosPorTipo(String tipoUsuario) {
		int contadorInstancia;
		contadorInstancia = 0;
		for (IAsesoria asesoria : asesorias) {

			if (asesoria instanceof Usuario && tipoUsuario.equals(((Usuario) asesoria).getClass().getSimpleName())) {
				System.out.println(asesoria.toString());
				contadorInstancia++;
			}

		}
		if (contadorInstancia == 0) {
			System.out.println("No existe usuario tipo" + tipoUsuario);
		}
	}

}

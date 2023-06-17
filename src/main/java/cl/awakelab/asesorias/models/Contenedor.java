package main.java.cl.awakelab.asesorias.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.cl.awakelab.asesorias.ValidacionesYExtras;
import main.java.cl.awakelab.asesorias.interfaces.IAsesoria;
/**
 * 
 *  @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 *  @version 1.0.0
 *
 * clase contenedor que contiene 2 listas para almacenar instancias, 
 * y los metodos utilizados por el menu principal 
 */
public class Contenedor {
	private List<IAsesoria> asesorias;
	private List<Capacitacion> capacitaciones;
//contenedor con listas para almacenar instancias 
	public Contenedor() {
		asesorias = new ArrayList<>();
		capacitaciones = new ArrayList<>();
	}
/**
 * metodo utilizado para almacenar una instancia de clientes 
 */
	public void almacenarCliente(Cliente cliente) {
		asesorias.add(cliente);
	}
/**
 * metodo utilizado para almacenar una instancia de profesionales 
 */
	public void almacenarProfesional(Profesional profesional) {
		asesorias.add(profesional);
	}
	/**
	 * metodo utilizado para almacenar una instancia de administrativo
	 */
	public void almacenarAdministrativo(Administrativo administrativo) {
		asesorias.add(administrativo);
	}
	/**
	 * metodo utilizado para almacenar una nueva instancia de capacitacion
	 */
	public void almacenarCapacitacion(Capacitacion capacitacion) {
		capacitaciones.add(capacitacion);
	}
	
	/**
	 * metodo utilizado para mostra por consola las capacitaciones almacenadas 
	 */
	public void listarCapacitaciones() {
		int contadorInstancia;
		contadorInstancia = 0;
		for (Capacitacion capacitacion : capacitaciones) {
			System.out.print("\u001B[33;1m" + capacitacion + "\u001B[0m");
			contadorInstancia++;

		}
		if (contadorInstancia == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN CAPACITACIONES AGENDADAS");
		}
	}

	/**
	 * metodo utilizado para poder ciclar entre los datos almacenados en las funciones de eliminar usuario y listar por tipo 
	 * @return
	*/ 
	public int contadorDeRegistros() {
		int contadorInstancia;
		contadorInstancia = 0;
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				contadorInstancia++;
			}
		}
		return contadorInstancia;
	}
	
	/**
	 * metodo utilizado para mostrar en consola los usuarios registrados 
	 */
	public void listarUsuarios() {
		int contadorInstancia;
		contadorInstancia = 0;
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				System.out.print("\u001B[33;1m" + asesoria + "\u001B[0m");
				contadorInstancia++;
			}
		}
		if (contadorInstancia == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN REGISTROS PARA MOSTRAR");
		}
	}
	
	/**
	 * metodo utilizado para eliminar instancias de usuario segun el valor de rut 
	 * @param rut valor relacionado a la instancia almacenada a eliminar 
	 */
	public void eliminarUsuario(String rut) {
		int contadorInstancia;
		contadorInstancia = 0;
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				contadorInstancia++;
			}
		}
		if (contadorInstancia == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN REGISTROS PARA ELIMINAR");
		} else {
			contadorInstancia = 0;
			Iterator<IAsesoria> posicionEliminarInstancia = asesorias.iterator();
			while (posicionEliminarInstancia.hasNext()) {
				IAsesoria asesoria = posicionEliminarInstancia.next();
				if (asesoria instanceof Usuario && rut.equals(((Usuario) asesoria).getRut())) {
					posicionEliminarInstancia.remove();
					System.out.println(asesoria.toString());
					ValidacionesYExtras.imprimirMensajeEnRojo("ELIMINADO");
					contadorInstancia++;
				}
			}
			if (contadorInstancia == 0) {
				ValidacionesYExtras.imprimirMensajeEnRojo("RUT INGRESADO NO EXISTE");
			}
		}
	}
/**
 * metodo utilizado para mostrar en consola los usuarios almacenados segun el tipo seleccionado
 * @param tipoUsuario
 */
	public void listarUsuariosPorTipo(String tipoUsuario) {
		int contadorInstancia;
		contadorInstancia = 0;
		for (IAsesoria asesoria : asesorias) {

			if (asesoria instanceof Usuario && tipoUsuario.equals(((Usuario) asesoria).getClass().getSimpleName())) {
				System.out.print("\u001B[33;1m" + asesoria.toString() + "\u001B[0m");
				contadorInstancia++;
			}
		}
		if (contadorInstancia == 0) {
			ValidacionesYExtras.imprimirMensajeEnRojo("NO EXISTEN USUARIOS DE ESTE TIPO");
		}
	}
}
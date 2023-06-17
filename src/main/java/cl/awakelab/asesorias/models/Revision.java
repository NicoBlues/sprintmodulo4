package main.java.cl.awakelab.asesorias.models;
/**
 * 
 * @author Aldo Pino, Sebastian Hernandez, Freddy Yevenes, Nestor Leyton
 * @version 1.0.0
 *
 * clase revision y sus parametros 
 *
 */
public class Revision {

	private int identificadorRevision;
	private int identificadorVisitaTerreno;
	private String nombreRevision;
	private String detalleParaRevisar;
	private int estado;

	//constructor vacio 
	public Revision() {

	}

	//constructor con parametros aptos para nuevos datos
	public Revision(int identificadorRevision, int identificadorVisitaTerreno, String nombreRevision,
			String detalleParaRevisar, int estado) {

		this.identificadorRevision = identificadorRevision;
		this.identificadorVisitaTerreno = identificadorVisitaTerreno;
		this.nombreRevision = nombreRevision;
		this.detalleParaRevisar = detalleParaRevisar;
		this.estado = estado;
	}

	//getters and setters
	public int getIdentificadorRevision() {
		return identificadorRevision;
	}

	public void setIdentificadorRevision(int identificadorRevision) {
		this.identificadorRevision = identificadorRevision;
	}

	public int getIdentificadorVisitaTerreno() {
		return identificadorVisitaTerreno;
	}

	public void setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
		this.identificadorVisitaTerreno = identificadorVisitaTerreno;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalleParaRevisar() {
		return detalleParaRevisar;
	}

	public void setDetalleParaRevisar(String detalleParaRevisar) {
		this.detalleParaRevisar = detalleParaRevisar;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	//metodo utilizado para desplegar los datos por pantalla 
	@Override
	public String toString() {
		return "Revision [identificadorRevision=" + identificadorRevision + ", identificadorVisitaTerreno="
				+ identificadorVisitaTerreno + ", nombreRevision=" + nombreRevision + ", detalleParaRevisar="
				+ detalleParaRevisar + ", estado=" + estado + "]";
	}

}

package main.java.cl.awakelab.asesorias.models;

public class Revision {

	private int identificadorRevision;
	private int identificadorVisitaTerreno;
	private String nombreRevision;
	private String detalleParaRevisar;
	private int estado;

	public Revision() {

	}

	public Revision(int identificadorRevision, int identificadorVisitaTerreno, String nombreRevision,
			String detalleParaRevisar, int estado) {

		this.identificadorRevision = identificadorRevision;
		this.identificadorVisitaTerreno = identificadorVisitaTerreno;
		this.nombreRevision = nombreRevision;
		this.detalleParaRevisar = detalleParaRevisar;
		this.estado = estado;
	}

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

	@Override
	public String toString() {
		return "Revision [identificadorRevision=" + identificadorRevision + ", identificadorVisitaTerreno="
				+ identificadorVisitaTerreno + ", nombreRevision=" + nombreRevision + ", detalleParaRevisar="
				+ detalleParaRevisar + ", estado=" + estado + "]";
	}

}

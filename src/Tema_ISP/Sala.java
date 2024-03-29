package Tema_ISP;

public class Sala {

	private String zi;
	private String oraInceput;
	private String oraSfarsit;
	private String numeSala;
	private boolean disponibilitate = true;

	public void eliberareDisponibilitate() {
		if (this.disponibilitate)
			this.disponibilitate = false;

	}

	public Sala() {
		super();
	}

	public Sala(String zi, String oraInceput, String numeSala) {
		super();
		this.zi = zi;
		this.oraInceput = oraInceput;
		this.numeSala = numeSala;
	}

	public String getZi() {
		return zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	public String getOraInceput() {
		return oraInceput;
	}

	public void setOraInceput(String oraInceput) {
		this.oraInceput = oraInceput;
	}

	public String getOraSfarsit() {
		return oraSfarsit;
	}

	public void setOraSfarsit(String oraSfarsit) {
		this.oraSfarsit = oraSfarsit;
	}

	public String getNumeSala() {
		return numeSala;
	}

	public void setNumeSala(String numeSala) {
		this.numeSala = numeSala;
	}

	public void setareDisponibilitate(boolean disponibilitate) {
		this.disponibilitate = disponibilitate;
	}

	public void adaugareZi(String zi) {
		this.zi = zi;
	}

	public void setareOra(String oraInceput, String oraSfarsit) {
		this.oraInceput = oraInceput;
		this.oraSfarsit = oraSfarsit;
	}

	public void adaugareNumeSala(String numeSala) {
		this.numeSala = numeSala;
	}

	public boolean isDisponibilitate() {
		return disponibilitate;
	}

};

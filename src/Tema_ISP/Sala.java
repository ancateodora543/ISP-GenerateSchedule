package Tema_ISP;

public class Sala {

	private String zi;
	private String oraInceput;
	private String oraSfarsit;
	private String numeSala;
	private boolean disponibilitate;

	public void eliberareDisponibilitate() {
		if (this.disponibilitate)
			this.disponibilitate = false;

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

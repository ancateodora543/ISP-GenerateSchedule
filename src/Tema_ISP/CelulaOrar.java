package Tema_ISP;

public class CelulaOrar {

	private Sala sala;
	private Materie materie;

	public CelulaOrar(Sala sala, Materie materie) {
		this.sala = sala;
		this.materie = materie;
	}
	
	public CelulaOrar(Materie materie) {
		this.materie = materie;
	}
	

	public CelulaOrar() {
		super();
	}



	public void adaugareMaterie(Materie materie) {
		this.materie = materie;
	}

	public void adaugareSala(Sala sala) {
		this.sala = sala;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Materie getMaterie() {
		return materie;
	}

	public void setMaterie(Materie materie) {
		this.materie = materie;
	}

	public void afisare() {
		System.out.println("Materie: " + materie.getNumeMaterie().toUpperCase());
		System.out.println("Sala: " + sala.getNumeSala().toUpperCase());
		System.out.println("Profesor: " + materie.getProfesor().getNume());
		System.out.println("Zi: " + sala.getZi());
		System.out.println("Ora: " + sala.getOraInceput() + "--" + sala.getOraSfarsit());
	}

	public boolean verificareCelulaOrar() {
		return sala.isDisponibilitate() && materie.getProfesor().isDisponibilitate()&& materie.getGrupa().isDispobilitate();
	}
	
};

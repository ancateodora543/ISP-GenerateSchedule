// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema_ISP;

import java.util.ArrayList;
import java.util.HashMap;

public class Grupa {

	private String nume;
	private String serie;
	private String user;
	private String parola;
	private boolean logat =  false;
	private ArrayList <String> listaMaterii = new ArrayList<String>();
	private ArrayList <Materie> materii = new ArrayList<Materie>();

	public void afisareStudent() {
		System.out.println("Student: " + nume);
	}


	public String getNume() {
		return nume;
	}



	public void setNume(String nume) {
		this.nume = nume;
	}



	public void logare(String nume, String parola) {
		HashMap<String, String> hm = Aplicatie.getConturi();
		if (!logat && hm.get(this.parola) != null) {
			System.out.println("Buna, " + nume);
			logat = true;
		} else if (logat)
			System.out.println("Sunteti deja logat");
		else
			System.out.println("Nu aveti cont");
	}
	

	public void delogare() {
		if (logat) {
			System.out.println("La revedere, " + nume);
			logat = false;
		} else
			System.out.println("Nu sunteti inca logat");
	}


	public void vizualizareOrarZilnic(String zi) {
	}

	public void vizualizareOrarSaptamana() {
	}


	public void vizualizareOrarGrupaStudent(Tema_ISP.Grupa grupa) {
	}
	
	/*
	public void adaugareMaterie(Materie materie) {
		this.materii.add(materie);	
	}

	public void stergereMaterie(Materie materie) {
		if(materii.contains(materie))
			materii.remove(materie);
	}

	 */
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getParola() {
		return parola;
	}


	public void setParola(String parola) {
		this.parola = parola;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public ArrayList<Materie> getMaterii() {
		return materii;
	}


	public void setMaterii(ArrayList<Materie> materii) {
		this.materii = materii;
	}


	public ArrayList<String> getListaMaterii() {
		return listaMaterii;
	}


	public void setListaMaterii(ArrayList<String> listaMaterii) {
		this.listaMaterii = listaMaterii;
	}
	
	
	
	
	
};

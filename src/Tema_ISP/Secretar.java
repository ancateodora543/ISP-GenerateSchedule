package Tema_ISP;

import java.util.ArrayList;

public class Secretar {

	
	public void creareOrar(CelulaOrar orarCelula, Orar orarFinal) {
	}


	public void creareContGrupa(Grupa grupa) {
		
		String u = null;
		String p = "parolaGrupa";
		
		if(grupa.getUser() == null) {
			u = grupa.getNume().replaceAll(" ", "").toLowerCase();
			if(Aplicatie.getConturi().containsKey(u))
				u = u + u.charAt(u.length() - 1);
		}
		
		Aplicatie.getConturi().put(u, p);
	}


	public void stergereContGrupa(Grupa grupa) {
		
		String user = grupa.getUser();
		if(user == null)
			System.out.println("Nu exista cont");
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
		}
	}


	public void modificareContStudent(Grupa grupa, String criteriu, String valoareNoua) {
		switch(criteriu){
			case "nume": {
				grupa.setNume(valoareNoua);
				System.out.println("Nume modificat");
				break;
			}
			case "serie": {
				grupa.setSerie(valoareNoua);
				System.out.println("Serie modificata");
				break;
			}
			default: {
				System.out.println("Camp inexistent");
				break;
			}
		}
	}


	public void creareContProfesor(Profesor prof) {
		String u = null;
		String p = "parolaGrupa";
		
		if(prof.getUser() == null) {
			u = prof.getNume().replaceAll(" ", "").toLowerCase();
			if(Aplicatie.getConturi().containsKey(u))
				u = u + u.charAt(u.length() - 1);
		}
		
		Aplicatie.getConturi().put(u, p);
		
	}


	public void stergereContProfesor(Profesor profesor) {
		String user = profesor.getUser();
		if(user == null)
			System.out.println("Nu exista cont");
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
		}
	}


	public void modificareContProfesor(Profesor profesor, String criteriu, String valoareNoua) {
		switch(criteriu){
		case "nume": {
			profesor.setNume(valoareNoua);
			System.out.println("Nume modificat");
			break;
		}
		default: {
			System.out.println("Camp inexistent");
			break;
		}
	}
	}

	public void adaugareMaterieGrupa(Grupa grupa, String materie) {
		ArrayList<String> materiiGrupa = grupa.getListaMaterii();
		
		if(materiiGrupa.contains(materie))
			System.out.println("Materia exista deja");
		else {
			materiiGrupa.add(materie);
			System.out.println("Materie adaugata");
		}		
	}
	
	
	public void salvareOrar() {
	}

	public void afisareOrar() {
	}
};

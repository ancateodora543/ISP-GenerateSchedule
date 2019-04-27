package Tema_ISP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Secretar {
	 Map<String, Map<String, List<CelulaOrar>>> orarGrupa = new HashMap<String, Map<String, List<CelulaOrar>>>();
	 
	 
	 ArrayList <Profesor> profi = new ArrayList <Profesor>();
	 
	 //toate obiectele Materie create
	 ArrayList <Materie> materii = new ArrayList <Materie>();
	 
	//toate obiectele Materie create
	 ArrayList <Sala> sali = new ArrayList <Sala>();
		 
	 
	 
	 
	 
	 ArrayList <String> materiiPredefinite = new ArrayList <String>();
	 ArrayList <String> numeSali = new ArrayList <String>();
	 String[] zileSaptamana = {"Luni", "Marti", "Miercuri", "Joi", "Vineri"};
	 
	 public void creareOrar(Orar orarFinal, Grupa grupa) {
		orarGrupa.put(grupa.getNume(), orarFinal.getOrarZi());
		
	}

	public void creareContGrupa(Grupa grupa) {

		String u = null;
		String p = "parolaGrupa";

		if (grupa.getUser() == null) {
			u = grupa.getNume().replaceAll(" ", "").toLowerCase();
			if (Aplicatie.getConturi().containsKey(u))
				u = u + u.charAt(u.length() - 1);
		}

		Aplicatie.getConturi().put(u, p);
	}

	public void stergereContGrupa(Grupa grupa) {

		String user = grupa.getUser();
		if (user == null)
			System.out.println("Nu exista cont");
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
		}
	}

	public void modificareContStudent(Grupa grupa, String criteriu, String valoareNoua) {
		switch (criteriu) {
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
		String p = "parolaProf";

		if (prof.getUser() == null) {
			u = prof.getNume().replaceAll(" ", "").toLowerCase();
			if (Aplicatie.getConturi().containsKey(u))
				u = u + u.charAt(u.length() - 1);
		}

		Aplicatie.getConturi().put(u, p);

	}

	public void stergereContProfesor(Profesor profesor) {
		String user = profesor.getUser();
		if (user == null)
			System.out.println("Nu exista cont");
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
		}
	}

	public void modificareContProfesor(Profesor profesor, String criteriu, String valoareNoua) {
		switch (criteriu) {
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

		if (materiiGrupa.contains(materie))
			System.out.println("Materia exista deja");
		else {
			materiiGrupa.add(materie);
			System.out.println("Materie adaugata");
		}
	}
	
	public void adaugareMateriePredefinita(String materie) {
		if(!materiiPredefinite.contains(materie))
			materiiPredefinite.add(materie);
		else
			System.out.println("Materia exista deja");
	}
	
	public void adaugareNumeSala(String sala) {
		if(!numeSali.contains(sala))
			materiiPredefinite.add(sala);
		else
			System.out.println("Sala exista deja");
	}
	
	//parcurgem lista cu materiile create si pentru fiecare materie de acolo o sa creem o celula de orar
	public void creareCelulaOrar(Materie m) {
		CelulaOrar celulaNoua = null;
		for (String numeSala : numeSali) {
			Sala salaNoua = new Sala();
			salaNoua.adaugareNumeSala(numeSala);
			for (Sala sala : sali) 
				if(sala.getNumeSala().equals(numeSala)) {
					//aici voiam sa vad cand sala asta e ocupata (exista mai multe obiecte de tip Sala pentru acelasi
					// nume de sala => dar nu stiu cum sa fac asta
					
				}
			
				
					
			}
	

	}
	

	
	public void creareMaterie(Grupa grupa, DesfasurareMaterie desf) {
		ArrayList<String> materiiGrupa = grupa.getListaMaterii();
		Materie materieNoua = null;
		
		for(String materiePredefinita : materiiPredefinite) {
			if(materiiGrupa.contains(materiePredefinita)) {
				//verificam daca exista deja o materia cu acest nume pt grupa respectiva
				boolean ok = true;
				for(CelulaOrar celula : Orar.getCeluleOrar()) {
					Materie m = celula.getMaterie();
					if( m.getNumeMaterie().equals(materiePredefinita)){
						ok = false;
						break;
					}
				}
				if(ok) {
					materieNoua = new Materie(grupa, materiePredefinita, desf);
					for (Profesor prof : profi)
						if(prof.getMaterii().contains(materiePredefinita)) {
							materieNoua.adaugareProfesor(prof);
							break;
						}
				}						
			}
			if(materieNoua != null)
				materii.add(materieNoua);
		}
	}
	
	

	public void salvareOrar() {
	}

	public void afisareOrar() {
	}
};

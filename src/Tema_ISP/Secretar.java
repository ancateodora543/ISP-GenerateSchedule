package Tema_ISP;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Secretar {
	Map<String, Map<String, List<CelulaOrar>>> orarGrupa = new HashMap<String, Map<String, List<CelulaOrar>>>();

	ArrayList<Profesor> profi = new ArrayList<Profesor>();
	String[] serii = {"AA", "AB", "AC", "CA", "CB", "CC", "CD"};

	
	ArrayList<Materie> materii = new ArrayList<Materie>();

	
	ArrayList<Sala> sali = new ArrayList<Sala>();
	ArrayList<CelulaOrar> celuleOrar;

	static ArrayList<String> numeMateriiPredefinite = new ArrayList<String>();
	ArrayList<String> numeSali = new ArrayList<String>();
	String[] zileSaptamana = { "Luni", "Marti", "Miercuri", "Joi", "Vineri" };
	
	

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
			if(validareGrupa(criteriu,valoareNoua)) {
				grupa.setNume(valoareNoua);
				System.out.println("Nume modificat");
				break;
			}
			else {
				System.out.println("Nume invalid");
				break;
			}
				
		}
		case "serie": {
			if(validareGrupa(criteriu,valoareNoua)) {
				grupa.setSerie(valoareNoua);
				System.out.println("Serie modificata");
				break;
			}
			else {
				System.out.println("Serie invalida");
				break;
			}
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
			if(validareProf(criteriu,valoareNoua)) {
				profesor.setNume(valoareNoua);
				System.out.println("Nume modificat");
				break;
			}
			else {
				System.out.println("Nume invalid");
				break;	
			}
		}
		default: {
			System.out.println("Camp inexistent");
			break;
		}
		}
	}
	
	public boolean validareGrupa(String camp, String valoare) {
		boolean rezultat = true;
		boolean ok = false;
		
		if(camp.equals("nume"))
			if(valoare.contains("[a-zA-Z]"))
				rezultat = false;
		
		if(camp.equals("serie")) {
			for(String serie : serii)
				if(valoare.equals(serie))
					ok = true;
		}
		if(ok == false)
			rezultat = false;
				
		return rezultat;
	}

	public boolean validareProf(String camp, String valoare) {
		boolean rezultat = true;
		
		if(camp.equals("nume"))
			if(!valoare.contains("[a-zA-Z]"))
				rezultat = false;
		
		return rezultat;
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

	public void adaugareNumeMateriePredefinita(String materie) {
		if (!numeMateriiPredefinite.contains(materie))
			numeMateriiPredefinite.add(materie);
		else
			System.out.println("Materia exista deja");
	}

	public void adaugareNumeSala(String sala) {
		if (!numeSali.contains(sala))
			numeMateriiPredefinite.add(sala);
		else
			System.out.println("Sala exista deja");
	}

	// parcurgem lista cu materiile create si pentru fiecare materie de acolo o sa
	// creem o celula de orar
	public void creareSalaOrar() {

		for (String numeSala : numeSali) {
			Sala salaNoua = new Sala();
			salaNoua.adaugareNumeSala(numeSala);
			boolean ok = true;
			for (Sala sala : sali) {
				if (sala.getNumeSala().equals(numeSala)) {
					// aici voiam sa vad cand sala asta e ocupata (exista mai multe obiecte de tip
					// Sala pentru acelasi
					// nume de sala => dar nu stiu cum sa fac asta
					System.out.println("Sala este deja folosita!");
					ok = false;
					break;
				}
				else
				{
					
				}

			}
			if (ok) {
				sali.add(salaNoua);
			}
		}

	}

	public void creareCelulaOrar(Sala sala) {
		int ora = 0;
		for (Materie m : materii) {
			CelulaOrar celula = new CelulaOrar(m);
			if (celuleOrar == null) {
				celuleOrar = new ArrayList<CelulaOrar>();
				celuleOrar.add(celula);
			} else {
				if (!celuleOrar.contains(celula)) {
					celuleOrar.add(celula);
				}
			}
			for (CelulaOrar c : celuleOrar) {
				if(c.equals(celuleOrar.get(0))) {
					Sala s = new Sala("Luni", "8", "EC105");
					ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
					s.setOraSfarsit(Integer.toString(ora));
				}
				else
				{
					
				}

			}

		}

	}
 void creareMaterie(Grupa grupa, DesfasurareMaterie desf) {
		ArrayList<String> materiiGrupa = grupa.getListaMaterii();
		Materie materieNoua = null;
		
		for (String materiePredefinita : numeMateriiPredefinite) {
			if (materiiGrupa.contains(materiePredefinita)) {
				boolean ok = true;
				for (CelulaOrar celula : Orar.getCeluleOrar()) {
					Materie m = celula.getMaterie();
					if (m.getNumeMaterie().equals(materiePredefinita)) {
						ok = false;
						break;
					}
				}
				if (ok) {
					materieNoua = new Materie(grupa, materiePredefinita, desf);
					for (Profesor prof : profi)
						if (prof.getMaterii().contains(materiePredefinita)) {
							materieNoua.adaugareProfesor(prof);
							break;
						}
				}
			}
			if (materieNoua != null)
				materii.add(materieNoua);
		}
	}

	public void salvareOrar() {
	}

	public void afisareOrar() {
	}
};

package Tema_ISP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Secretar {
	ArrayList<Profesor> profi = new ArrayList<Profesor>();
	String[] serii = { "AA", "AB", "AC", "CA", "CB", "CC", "CD" };

	ArrayList<Materie> materii = new ArrayList<Materie>();

	ArrayList<Sala> sali = new ArrayList<Sala>();
	public static ArrayList<CelulaOrar> celuleOrar;

	static ArrayList<String> numeMateriiPredefinite = new ArrayList<String>();
	ArrayList<String> numeSali = new ArrayList<String>();
	String[] zileSaptamana = { "Luni", "Marti", "Miercuri", "Joi", "Vineri" };

	public boolean creareContGrupa(Grupa grupa) {

		String u = null;
		String p = "parolaGrupa";
		boolean okay = false;
		if (grupa.getUser() == null) {
			u = grupa.getNume().replaceAll(" ", "").toLowerCase();
			if (Aplicatie.getConturi().containsKey(u)) {
				System.out.println("Contul exista deja");
				okay = false;
			}else {
				Aplicatie.getConturi().put(u, p);
				okay = true;
			}
		} else {
			u = grupa.getUser();
			if (Aplicatie.getConturi().containsKey(u)) {
				System.out.println("Contul exista deja");
				okay = false;
			}
			else {
				Aplicatie.getConturi().put(u, p);
				okay = true;
			}

		}
		return okay;
	}

	public boolean stergereContGrupa(Grupa grupa) {

		String user = grupa.getUser();
		String pass = grupa.getParola();
		boolean okay = false;
		if (user == null) {
			System.out.println("Nu exista cont");
		}
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
			user = null;
			pass = null;
			okay = true;
		}
		return okay;
	}

	public void modificareContStudent(Grupa grupa, String criteriu, String valoareNoua) {
		switch (criteriu) {
		case "nume": {
			if (validareGrupa(criteriu, valoareNoua)) {
				grupa.setNume(valoareNoua);
				System.out.println("Nume modificat");
				break;
			} else {
				System.out.println("Nume invalid");
				break;
			}

		}
		case "serie": {
			if (validareGrupa(criteriu, valoareNoua)) {
				grupa.setSerie(valoareNoua);
				System.out.println("Serie modificata");
				break;
			} else {
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

	public boolean creareContProfesor(Profesor prof) {
		String u = null;
		String p = "parolaProf";
		boolean okay = false;
		if (prof.getUser() == null) {
			u = prof.getNume().replaceAll(" ", "").toLowerCase();
			if (Aplicatie.getConturi().containsKey(u)) {
				System.out.println("Contul exista deja");
				okay = false;}
		else {
			Aplicatie.getConturi().put(u, p);
			okay = true;
		}
		}
		else
		{
			u = prof.getUser();
			if(Aplicatie.getConturi().containsKey(u)) {
				System.out.println("Contul exista deja");
				okay = false;
			}
			else
			{
				Aplicatie.getConturi().put(u, p);
				okay = true;
			}
		}

		return okay;

	}

	public boolean stergereContProfesor(Profesor profesor) {
		String user = profesor.getUser();
		String pass = profesor.getParola();
		boolean okay = false;
		if (user == null)
			System.out.println("Nu exista cont");
		else {
			Aplicatie.getConturi().remove(user);
			System.out.println("Contul a fost sters");
			user = null;
			pass = null;
			okay = true;

		}
		return okay;
	}

	public void modificareContProfesor(Profesor profesor, String criteriu, String valoareNoua) {
		switch (criteriu) {
		case "nume": {
			if (validareProf(criteriu, valoareNoua)) {
				profesor.setNume(valoareNoua);
				System.out.println("Nume modificat");
				break;
			} else {
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
		boolean rezultat = false;

		if (camp.equals("nume"))
			if (valoare.matches("[a-zA-Z]+"))
				rezultat = false;
			else
				rezultat = true;

		else if (camp.equals("serie")) {
			for (String serie : serii)
				if (serie.equals(valoare)) {
					rezultat = true;
					break;
				}
				else
				{
					rezultat = false;
				}
		}

		return rezultat;
	}

	public boolean validareProf(String camp, String valoare) {
		boolean rezultat = true;

		if (camp.equals("nume"))
			if (!valoare.matches("[a-zA-Z]+"))
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


public void creareCelulaOrar() {
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
			// sali

			int oreLuni = 0;
			int oreMarti = 0;
			int oreMiercuri = 0;
			int oreJoi = 0;
			int oreVineri = 0;

			int indexLuni = 8;
			int indexMarti = 10;
			int indexMiercuri = 10;
			int indexJoi = 12;
			int indexVineri = 10;

			for (CelulaOrar c : celuleOrar) {
				if (c.equals(celuleOrar.get(0))) {
					Sala s = new Sala("Luni", Integer.toString(indexLuni), "EC105");
					ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
					indexLuni = ora;
					oreLuni = oreLuni + m.getDurata();
					s.setOraSfarsit(Integer.toString(ora));
					c.setSala(s);
				} else {
					if (oreLuni < 6) {
						Sala s = new Sala("Luni", Integer.toString(indexLuni), "EC105");
						ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
						indexLuni = ora;
						oreLuni = oreLuni + m.getDurata();
						s.setOraSfarsit(Integer.toString(ora));
						c.setSala(s);
					} else {
						if (oreMarti < 6) {
							Sala s = new Sala("Marti", Integer.toString(indexMarti), "EC105");
							ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
							indexMarti = ora;
							oreMarti = oreMarti + m.getDurata();
							s.setOraSfarsit(Integer.toString(ora));
							c.setSala(s);
						} else {
							if (oreMiercuri < 6) {
								Sala s = new Sala("Miercuri", Integer.toString(indexMiercuri), "EC105");
								ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
								indexMiercuri = ora;
								oreMiercuri = oreMiercuri + m.getDurata();
								s.setOraSfarsit(Integer.toString(ora));
								c.setSala(s);
							} else {
								if (oreJoi < 6) {
									Sala s = new Sala("Joi", Integer.toString(indexJoi), "EC105");
									ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
									indexJoi = ora;
									oreJoi = oreJoi + m.getDurata();
									s.setOraSfarsit(Integer.toString(ora));
									c.setSala(s);
								} else {
									if (oreVineri < 6) {
										Sala s = new Sala("Vineri", Integer.toString(indexVineri), "EC105");
										ora = Integer.parseInt(s.getOraInceput()) + m.getDurata();
										indexVineri = ora;
										oreVineri = oreVineri + m.getDurata();
										s.setOraSfarsit(Integer.toString(ora));
										c.setSala(s);
									}
								}
							}

						}

					}

				}

			}
		}

	}

	public void creareMaterie(Grupa grupa, DesfasurareMaterie desf) {
		ArrayList<String> materiiGrupa = grupa.getListaMaterii();
		Materie materieNoua = null;

		for (String materiePredefinita : numeMateriiPredefinite) {
			if (materiiGrupa.contains(materiePredefinita)) {
				boolean ok = true;
				if (celuleOrar != null) {
					for (CelulaOrar celula : celuleOrar) {
						Materie m = celula.getMaterie();
						if (m.getNumeMaterie().equals(materiePredefinita) && m.getModDesfasurareMaterie() == desf) {
							ok = false;
							break;
						}
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
				if (materieNoua != null)
					materii.add(materieNoua);
			}

		}
	}

	public void salvareOrar(String fisier) throws IOException {
		File logFile = new File(fisier);
		PrintWriter filePrint;
		FileWriter testWriter;
		testWriter = new FileWriter(logFile);
		filePrint = new PrintWriter(testWriter, true);
		for (CelulaOrar celula : celuleOrar) {
			try {
				logFile.createNewFile();
			} catch (IOException e1) { // TODO Auto-generated catch block
				e1.printStackTrace();
			}
			filePrint.println("Materie: " + celula.getMaterie().getNumeMaterie().toUpperCase());
			filePrint.println("Sala: " + celula.getSala().getNumeSala().toUpperCase());
			filePrint.println("Profesor: " + celula.getMaterie().getProfesor().getNume());
			filePrint.println("Zi: " + celula.getSala().getZi());
			filePrint.println("Ora: " + celula.getSala().getOraInceput() + "--" + celula.getSala().getOraSfarsit());
			filePrint.println("Tip desfasurare: " + celula.getMaterie().getModDesfasurareMaterie());
			filePrint.println();

		}
	}

	public void afisareOrar() {
		for (CelulaOrar celula : celuleOrar) {
			celula.afisare();
			System.out.println();
		}
	}

	public ArrayList<Materie> getMaterii() {
		return materii;
	}

	public void setMaterii(ArrayList<Materie> materii) {
		this.materii = materii;
	}

	public ArrayList<CelulaOrar> getCeluleOrar() {
		return celuleOrar;
	}

	public void setCeluleOrar(ArrayList<CelulaOrar> celuleOrar) {
		this.celuleOrar = celuleOrar;
	}

	public void adaugareProfesori(Profesor p) {
		profi.add(p);
	}

};

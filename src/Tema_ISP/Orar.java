package Tema_ISP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orar {

	private static ArrayList<CelulaOrar> celuleOrar;
	private Map<String, List<CelulaOrar>> orarZi = new HashMap<String, List<CelulaOrar>>();

	public void adaugareCelula(CelulaOrar celula) {
		if (celula.verificareCelulaOrar())
			celuleOrar.add(celula);
		else
			System.out.println("Nu a fost gasita o asemenea celula!");
	}

	public static ArrayList<CelulaOrar> getCeluleOrar() {
		return celuleOrar;
	}

	public Map<String, List<CelulaOrar>> getOrarZi() {
		return orarZi;
	}

	public void stergereCelula(CelulaOrar celula) {
		if (celuleOrar.contains(celula)) {
			celuleOrar.remove(celula);

		} else {
			System.out.println("Aceasta celula nu exista!");
		}

	}

	public void afisare() {
		for (CelulaOrar celulaOrar : celuleOrar) {
			celulaOrar.afisare();
		}
	}


}

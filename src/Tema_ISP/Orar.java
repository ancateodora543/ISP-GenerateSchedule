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

	public Map<String, List<CelulaOrar>> creareOrarZi(CelulaOrar celula, String zi) {
		while (numarareOreZi(zi) < 6) {
			if (celuleOrar == null) {
				celuleOrar = new ArrayList<CelulaOrar>();
				if (celula.verificareCelulaOrar()) {
					celuleOrar.add(celula);
				}
				orarZi.put(zi, celuleOrar);
			} else {
				if (celula.verificareCelulaOrar()) {
					if (!celuleOrar.contains(celula)) {
						adaugareCelula(celula);
					}
				}
				orarZi.put(zi, celuleOrar);
			}
		}
		return orarZi;

	}

	public int numarareOreZi(String zi) {
		int sum = 0;
		for (CelulaOrar o : orarZi.get(zi)) {
			sum = sum + o.getMaterie().getDurata();
		}
		return sum;
	}

}

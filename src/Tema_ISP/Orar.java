package Tema_ISP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Orar {

	private ArrayList <CelulaOrar> celuleOrar = new ArrayList<CelulaOrar>();
	
	public void adaugareCelula(CelulaOrar celula) {
		this.celuleOrar.add(celula);
		
	}
	
	public void stergereCelula(CelulaOrar celula) {
		if(this.celuleOrar.contains(celula))
		{
			celuleOrar.remove(celula);
			
		}
		else
		{
			System.out.println("Aceasta celula nu exista!");
		}
		
	}
	
	public void afisare() {
		for(CelulaOrar celulaOrar : celuleOrar)
		{
			celulaOrar.afisare();
		}
	}
	
	public void creare(CelulaOrar celula, String zi) {
		Map<String, List<CelulaOrar>> orar = new HashMap<String, List<CelulaOrar>>();
		orar.put(zi, celuleOrar);
		
	}
}

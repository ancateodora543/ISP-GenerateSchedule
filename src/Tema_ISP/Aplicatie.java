package Tema_ISP;

import java.util.HashMap;

public class Aplicatie {

	private static HashMap<String, String> conturi = new HashMap<String, String>();

	public static HashMap<String, String> getConturi() {
		return conturi;
	}

	public void setConturi(HashMap<String, String> conturi) {
		Aplicatie.conturi = conturi;
	}

	public static void main(String[] args) {

	}

}

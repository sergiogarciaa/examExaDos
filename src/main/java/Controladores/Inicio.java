package Controladores;

import Servicios.ImplementacionMenu;
import Servicios.InterfazMenu;

public class Inicio {

	public static void main(String[] args) {
		InterfazMenu menu = new ImplementacionMenu();
		menu.Menu();
	}

}

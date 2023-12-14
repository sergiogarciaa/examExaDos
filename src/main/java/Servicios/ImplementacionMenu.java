package Servicios;

import java.util.Scanner;

public class ImplementacionMenu implements InterfazMenu {

	@Override
	public void Menu() {
		boolean seguir = true;
		InterfazCrud crud = new ImplementacionCrud();
		Scanner sc = new Scanner(System.in);
		try {
			do {
				System.out.println("0º Salir");
				System.out.println("1º Dar de alta Elemento");
				System.out.println("2º Borrar Elemento ");
				System.out.println("3º Modificar Cantidad Elemento ");
				System.out.println("4º Mostrar Stock");
				System.out.println("5º Crear Reserva ");
				
				
				System.out.println("Elija la opción que desea");
	            int opcion = sc.nextInt();
				switch (opcion) {
				case 0: 
					seguir = false;
					break;
				case 1:
					crud.crearElemento();
					break;
				case 2:
					crud.eliminarElemento();
					break;
				case 3:
					crud.modificarCantidadElemento();
					break;
				case 4: 
					crud.mostrarStock();
				case 5:
					crud.crearReserva();
					break;
				default:
					break;
				}
				
			}while(seguir);
		}
		catch (Exception e) {
			System.out.println("Se ha producido un error en el menu.");
		}
	}	
}

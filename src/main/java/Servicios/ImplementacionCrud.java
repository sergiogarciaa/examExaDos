package Servicios;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import Entidades.Reserva;
import Entidades.Vajilla;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ImplementacionCrud implements InterfazCrud {
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	EntityManager em = emf.createEntityManager();

	@Override
	public void crearElemento() {
		 try{
	                System.out.println("Ingresa los datos del nuevo elemento:");
	                System.out.print("Nombre del Elemento: ");
	                String nombre = sc.nextLine();
	                System.out.print("Descripcion del Elemento: ");
	                String descripcion = sc.nextLine();
	                System.out.print("Cantidad: ");
	                int cantidad = sc.nextInt();
	                
	                // Crear un elemento con los detalles ingresados
	                Vajilla vajillaNueva = new Vajilla(0, nombre+descripcion ,nombre, descripcion, cantidad);
	                em.getTransaction().begin();
	                em.persist(vajillaNueva);
	        		em.getTransaction().commit();
	        		em.close();	
	        		
	}catch (Exception e) {
		System.out.println("Error al intentar crear un nuevo elemento.");
		}
		 sc.close();
	}
	
	@Override
	public void eliminarElemento() {
		try {
	        System.out.println("Ingresa el codigo del elemento que desea eliminar:");
	        String codigoElemento = sc.nextLine();

	        // Buscar el elemento por el codigo
	        em.getTransaction().begin();
	        Vajilla elementoEliminar = em.createQuery("SELECT a FROM Vajilla a WHERE a.codigoElemento = :codigo", Vajilla.class).setParameter("codigo", codigoElemento).getSingleResult();

	        // si existe el elemento
	        if (elementoEliminar != null) {
	            em.remove(elementoEliminar);
	            em.getTransaction().commit();
	            System.out.println("Elemento eliminado exitosamente.");
	        } else {
	            System.out.println("El elemento no existe. Reinicia el programa");
	        }
	        em.close();
	    } catch (Exception e) {
	        System.out.println("Error al intentar eliminar el elemento");
	    }
		sc.close();	
	}	

	@Override
	public void modificarCantidadElemento() {
		 try {
		        System.out.println("Ingresa el código del elemento que deseas modificar:");
		        String codigoElemento = sc.nextLine();

		        em.getTransaction().begin();
		        Vajilla modificarElemento = em.createQuery("SELECT a FROM Vajilla a WHERE a.codigoElemento = :codigo", Vajilla.class).setParameter("codigo", codigoElemento).getSingleResult();

		        // para comprobar que el elemento existe
		        if (modificarElemento != null) {
		            System.out.println("Elemento actual: " + modificarElemento.getNombreElemento());
		            System.out.println("Cantidad actual: " + modificarElemento.getCantidadElemento());

		            System.out.print("Ingrese la cantidad que desea retirar: ");
		            int cantidadARestar = Integer.parseInt(sc.nextLine());

		            // no puede quedar en negativo
		            if (cantidadARestar < 0) {
		                System.out.println("La cantidad no puede quedar en negativo.");
		            } else {
		                int nuevaCantidad = modificarElemento.getCantidadElemento() - cantidadARestar;

		                modificarElemento.setCantidadElemento(nuevaCantidad);
		                em.getTransaction().commit();
		                System.out.println("Cantidad modificada. Ahora la cantidad es de: " + nuevaCantidad);
		            }
		        } else {
		            System.out.println("El elemento no existe.");
		        }
		        em.close();
		    } catch (Exception e) {
		        System.out.println("Error al intentar modificar la cantidad del elemento.");
		    }
		 sc.close();
	}
	
	@Override
	public void mostrarStock() {
		   try {
		        // traer de la BD la lista de todos los elementos
		        em.getTransaction().begin();
		        List<Vajilla> elementos = em.createQuery("SELECT v FROM Vajilla v", Vajilla.class).getResultList();
		        em.getTransaction().commit();

		        if (elementos.isEmpty()) {
		            System.out.println("No hay ningun elemento");
		        } 
		        else {
		            System.out.println("Stock de elementos:");
		            // mostrar los datos
		            for (Vajilla elemento : elementos) {
		                System.out.println("codigo: " + elemento.getCodigoElemento());
		                System.out.println("nombre: " + elemento.getNombreElemento());
		                System.out.println("cantidad: " + elemento.getCantidadElemento());
		                System.out.println("------------------------------");
		            }
		        }
		        em.close();
		    } catch (Exception e) {
		        System.out.println("Error al intentar mostrar el stock.");
		    }
	}

	@Override
	public void crearReserva() {
		
		 try{
			 Reserva reserva = new Reserva();
			 Calendar fechaActual = Calendar.getInstance();
			 
             reserva = new Reserva(0, fechaActual);
             em.getTransaction().begin();
             em.persist(reserva);
 			 em.getTransaction().commit();
	     	 em.close();		
	     	 System.out.println("Se ha creado la reserva con la fecha actual.");
		}catch (Exception e) {
			System.out.println("Error al intentar crear un nuevo elemento");
			}
		 sc.close();
		}
}

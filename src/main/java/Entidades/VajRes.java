package Entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Vajillas Reservas, es una relacion NM, pero he creado yo la tabla intermedia para su mantenimiento.
@Entity
@Table(name="vajRes", schema="esqexados")
public class VajRes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idVajRes", nullable=false)
	private long idVajRes;
	
	@OneToMany(mappedBy="resVaj") 
    List<Reserva> reservaVajilla;
	
	@OneToMany(mappedBy="vajRes") 
    List<Vajilla> vajillaReservadas;
	
	@Column(name="cantidad")
	private int cantidad;
	
}

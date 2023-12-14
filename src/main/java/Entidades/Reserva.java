package Entidades;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reservas", schema="esqexados")

public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idReserva", nullable=false)
	private long idReserva;
	
	@Column(name="fchReserva")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchReserva;
	
	@ManyToOne
	@JoinColumn(name = "idVajRes") // FK
	VajRes resVaj;

	// Getter y Setter
	
	public long getIdReserva() {
		return idReserva;
	}

	public Calendar getFchReserva() {
		return fchReserva;
	}

	public void setFchReserva(Calendar fchReserva) {
		this.fchReserva = fchReserva;
	}
	
	// Constructores
	
	public Reserva() {
		super();
	}

	public Reserva(long idReserva, Calendar fchReserva) {
		super();
		this.idReserva = idReserva;
		this.fchReserva = fchReserva;
	}
}

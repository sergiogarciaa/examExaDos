package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vajillas", schema="esqexados")

public class Vajilla {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idElemento", nullable=false)
	private long idElemento;
	
	@Column(name="codigoElemento")
	private String codigoElemento;
	
	@Column(name="nombreElemento")
	private String nombreElemento;
	
	@Column(name="descripcionElemento")
	private String descripcionElemento;
	
	@Column(name="cantidadElemento")
	private int cantidadElemento;
	
	@ManyToOne
	@JoinColumn(name = "idVajRes") // FK
	VajRes vajRes;


	// Getter y Setter
	public long getIdElemento() {
		return idElemento;
	}
	
	public String getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public String getNombreElemento() {
		return nombreElemento;
	}

	public void setNombreElemento(String nombreElemento) {
		this.nombreElemento = nombreElemento;
	}

	public String getDescripcionElemento() {
		return descripcionElemento;
	}

	public void setDescripcionElemento(String descripcionElemento) {
		this.descripcionElemento = descripcionElemento;
	}

	public int getCantidadElemento() {
		return cantidadElemento;
	}

	public void setCantidadElemento(int cantidadElemento) {
		this.cantidadElemento = cantidadElemento;
	}

	//Constructores
    public Vajilla() {
		super();
	}

	public Vajilla(long idElemento, String codigoElemento, String nombreElemento, String descripcionElemento,
			int cantidadElemento) {
		super();
		this.idElemento = idElemento;
		this.codigoElemento = codigoElemento;
		this.nombreElemento = nombreElemento;
		this.descripcionElemento = descripcionElemento;
		this.cantidadElemento = cantidadElemento;
	}
}

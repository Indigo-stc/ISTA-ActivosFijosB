package ista.activosfijos.api.models.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Detalle_ing")
public class Detalle_ing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_detalle_ing;
	
	private String codigoA;
	private String descripcion;
	
	@ManyToOne
//	@JoinColumn(name="id_encabezado_ing")
	private Encabezado_ing encabezado_ing;

	public Detalle_ing() {
		super();
	}

	public Detalle_ing(String codigoA, String descripcion, Encabezado_ing encabezado_ing) {
		super();
		this.codigoA = codigoA;
		this.descripcion = descripcion;
		this.encabezado_ing = encabezado_ing;
	}

	
	

	public long getId_detalle_ing() {
		return id_detalle_ing;
	}

	public void setId_detalle_ing(long id_detalle_ing) {
		this.id_detalle_ing = id_detalle_ing;
	}

	public String getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(String codigoA) {
		this.codigoA = codigoA;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Encabezado_ing getEncabezado_ing() {
		return encabezado_ing;
	}

	public void setEncabezado_ing(Encabezado_ing encabezado_ing) {
		this.encabezado_ing = encabezado_ing;
	}
	
	
}

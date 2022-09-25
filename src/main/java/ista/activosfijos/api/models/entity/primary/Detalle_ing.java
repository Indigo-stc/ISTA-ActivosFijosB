package ista.activosfijos.api.models.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name="Detalle_ing",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "codigoA"),
		})

public class Detalle_ing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_detalle_ing;

	private String codigoA;
	private String descripcion;
	private Boolean estado_detalle;

	@ManyToOne
	@JoinColumn(name="id_encabezado_ing")
	private Encabezado_ing encabezado_ing;


	public Detalle_ing() {
		super();
	}

	public Detalle_ing(String codigoA, String descripcion, Boolean estado_detalle, Encabezado_ing encabezado_ing) {
		super();
		this.codigoA = codigoA;
		this.descripcion = descripcion;
		this.estado_detalle = estado_detalle;
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

	public Boolean getEstado_detalle() {
		return estado_detalle;
	}

	public void setEstado_detalle(Boolean estado_detalle) {
		this.estado_detalle = estado_detalle;
	}

	public Encabezado_ing getEncabezado_ing() {
		return encabezado_ing;
	}

	public void setEncabezado_ing(Encabezado_ing encabezado_ing) {
		this.encabezado_ing = encabezado_ing;
	}
	
}

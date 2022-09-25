package ista.activosfijos.api.models.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_departamento;
		  
	private String nombre_departamento;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_edificio")
	private Edificio edificio;

	public Departamento() {
		super();
	}

	public Departamento(String nombre_departamento, String descripcion, Edificio edificio) {
		super();
		this.nombre_departamento = nombre_departamento;
		this.descripcion = descripcion;
		this.edificio = edificio;
	}

	public long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
}

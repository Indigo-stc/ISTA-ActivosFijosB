package ista.activosfijos.api.models.entity.primary;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Edificio")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_edificio;
	  
	private String nombre_edificio;
	private String descripcion;
	
//	@OneToMany(mappedBy = "edificio")
//	private List<Departamento> departamento;
//	
	
	public Edificio() {
		super();
	}
	
	public Edificio(String nombre_edificio, String descripcion) {
		super();
		this.nombre_edificio = nombre_edificio;
		this.descripcion = descripcion;
	}

	public long getId_edificio() {
		return id_edificio;
	}
	public void setId_edificio(long id_edificio) {
		this.id_edificio = id_edificio;
	}
	public String getNombre_edificio() {
		return nombre_edificio;
	}
	public void setNombre_edificio(String nombre_edificio) {
		this.nombre_edificio = nombre_edificio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

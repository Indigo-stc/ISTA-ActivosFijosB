package ista.activosfijos.api.models.entity.primary;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Procedencia")
@Getter
@Setter
//@NoArgsConstructor
public class Procedencia {

   // Declarar la key y para que sea incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_procedencia;


	private String nombre_procedencia;

	private String descripcion;
	
	public Procedencia() {
	}
	
	public Procedencia(String nombre_procedencia, String descripcion) {
		this.nombre_procedencia = nombre_procedencia;
		this.descripcion = descripcion;
	}

	public Procedencia(long id_procedencia, String nombre_procedencia, String descripcion) {
		this.id_procedencia = id_procedencia;
		this.nombre_procedencia = nombre_procedencia;
		this.descripcion = descripcion;
	}
	/*
	public long getId_procedencia() {
		return id_procedencia;
	}
	public void setId_procedencia(long id_procedencia) {
		this.id_procedencia = id_procedencia;
	}
	public String getNombre_procedencia() {
		return nombre_procedencia;
	}
	public void setNombre_procedencia(String nombre_procedencia) {
		this.nombre_procedencia = nombre_procedencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}*/
	
	
}

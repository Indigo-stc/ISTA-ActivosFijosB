package ista.activosfijos.api.models.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="activo_constatacion")
public class activo_constatacion {
		@Id
		@Column(name = "id_activo", nullable = false, updatable = false)
		private Long id_activo;
		private String codigo_activo;
		private String nombre;
		private String descripcion;
		private String marca;
		private String modelo;
		private String serie;	
		private Double costo;
		private String estado_fisico;
		private String nombre_departamento;
		private String nombre_edificio;
		private String nombre_custodio;
		private String cedula_custodio;
		
		


		public activo_constatacion() {
			super();
		}


		public long getId_activo() {
			return id_activo;
		}


		public activo_constatacion(Long id_activo, String codigo_activo, String nombre, String descripcion, String marca,
		String modelo, String serie, Double costo, String estado_fisico, String nombre_departamento,
		String nombre_edificio, String nombre_custodio, String cedula_custodio) {
				super();
				this.id_activo = id_activo;
				this.codigo_activo = codigo_activo;
				this.nombre = nombre;
				this.descripcion = descripcion;
				this.marca = marca;
				this.modelo = modelo;
				this.serie = serie;
				this.costo = costo;
				this.estado_fisico = estado_fisico;
				this.nombre_departamento = nombre_departamento;
				this.nombre_edificio = nombre_edificio;
				this.nombre_custodio = nombre_custodio;
				this.cedula_custodio = cedula_custodio;
		}

		public void setId_activo(long id_activo) {
			this.id_activo = id_activo;
		}


		public String getCodigo_activo() {
			return codigo_activo;
		}


		public void setCodigo_activo(String codigo_activo) {
			this.codigo_activo = codigo_activo;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getSerie() {
			return serie;
		}


		public void setSerie(String serie) {
			this.serie = serie;
		}


		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getModelo() {
			return modelo;
		}


		public void setModelo(String modelo) {
			this.modelo = modelo;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public double getCosto() {
			return costo;
		}


		public void setCosto(double costo) {
			this.costo = costo;
		}






		public String getEstado_fisico() {
			return estado_fisico;
		}






		public void setEstado_fisico(String estado_fisico) {
			this.estado_fisico = estado_fisico;
		}






		public String getNombre_departamento() {
			return nombre_departamento;
		}






		public void setNombre_departamento(String nombre_departamento) {
			this.nombre_departamento = nombre_departamento;
		}






		public String getNombre_edificio() {
			return nombre_edificio;
		}






		public void setNombre_edificio(String nombre_edificio) {
			this.nombre_edificio = nombre_edificio;
		}






		public String getNombre_custodio() {
			return nombre_custodio;
		}






		public void setNombre_custodio(String nombre_custodio) {
			this.nombre_custodio = nombre_custodio;
		}






		public String getCedula_custodio() {
			return cedula_custodio;
		}






		public void setCedula_custodio(String cedula_custodio) {
			this.cedula_custodio = cedula_custodio;
		}






		public void setId_activo(Long id_activo) {
			this.id_activo = id_activo;
		}






		public void setCosto(Double costo) {
			this.costo = costo;
		}



	
		
		
		
		
	

}


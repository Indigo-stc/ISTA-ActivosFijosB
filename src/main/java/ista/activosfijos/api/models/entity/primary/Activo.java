package ista.activosfijos.api.models.entity.primary;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Anotaciones para la base de datos

@Entity
@Table(name="Activo")

public class Activo {

	// Declarar la key y para que sea incremental
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_activo;
	
	// Dar nombre de mapeo/el nombre de la tabla en la base de datos
	//@Column(name="codigo_activo")
	
	private String codigo_activo;
	private String nombre;
	private String serie;
	private String marca;
	private String modelo;
	private String imagen;
	private String descripcion;
	private double costo;
	private String estado_fisico;
	private boolean disponibilidad;
	
	public Activo() {
		super();
	}

	public Activo(String codigo_activo, String nombre, String serie, String marca, String modelo, String imagen, String descripcion, double costo, String estado_fisico, boolean disponibilidad) {
		this.codigo_activo = codigo_activo;
		this.nombre = nombre;
		this.serie = serie;
		this.marca = marca;
		this.modelo = modelo;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.costo = costo;
		this.estado_fisico = estado_fisico;
		this.disponibilidad = disponibilidad;
	}

	public long getId_activo() {
		return id_activo;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}

package ista.activosfijos.api.models.entity.primary;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Encabezado_Constatacion")
public class Encabezado_Constatacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_encabezado_Constatacion;
	
	private String nombres_Responsable;
	private String Cedula_Responsable;
	private String Observaciones;
	@Column(name="fecha_Constatacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_Constatacion;

	@PrePersist
	public void prePersist() {
		fecha_Constatacion = new Date();
	}
	private int Cantactivos_Constatados;
	private int Cantactivos_Noconstatados;
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_Uresponsable;

	public Encabezado_Constatacion() {
		super();
	}

	public Encabezado_Constatacion(String nombres_Responsable, String cedula_Responsable, String observaciones,
			Date fecha_Constatacion, int cantactivos_Constatados, int cantactivos_Noconstatados, boolean estado,
			Usuario id_Uresponsable) {
		super();
		this.nombres_Responsable = nombres_Responsable;
		Cedula_Responsable = cedula_Responsable;
		Observaciones = observaciones;
		this.fecha_Constatacion = fecha_Constatacion;
		Cantactivos_Constatados = cantactivos_Constatados;
		Cantactivos_Noconstatados = cantactivos_Noconstatados;
		this.estado = estado;
		this.id_Uresponsable = id_Uresponsable;
	}

	public long getId_encabezado_Constatacion() {
		return id_encabezado_Constatacion;
	}

	public void setId_encabezado_Constatacion(long id_encabezado_Constatacion) {
		this.id_encabezado_Constatacion = id_encabezado_Constatacion;
	}

	public String getNombres_Responsable() {
		return nombres_Responsable;
	}

	public void setNombres_Responsable(String nombres_Responsable) {
		this.nombres_Responsable = nombres_Responsable;
	}

	public String getCedula_Responsable() {
		return Cedula_Responsable;
	}

	public void setCedula_Responsable(String cedula_Responsable) {
		Cedula_Responsable = cedula_Responsable;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public Date getFecha_Constatacion() {
		return fecha_Constatacion;
	}

	public void setFecha_Constatacion(Date fecha_Constatacion) {
		this.fecha_Constatacion = fecha_Constatacion;
	}

	public int getCantactivos_Constatados() {
		return Cantactivos_Constatados;
	}

	public void setCantactivos_Constatados(int cantactivos_Constatados) {
		Cantactivos_Constatados = cantactivos_Constatados;
	}

	public int getCantactivos_Noconstatados() {
		return Cantactivos_Noconstatados;
	}

	public void setCantactivos_Noconstatados(int cantactivos_Noconstatados) {
		Cantactivos_Noconstatados = cantactivos_Noconstatados;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getId_Uresponsable() {
		return id_Uresponsable;
	}

	public void setId_Uresponsable(Usuario id_Uresponsable) {
		this.id_Uresponsable = id_Uresponsable;
	}
	
	
	
	
	
	
}

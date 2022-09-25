package ista.activosfijos.api.models.entity.primary;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Asignacion_Responsable")
public class Asignacion_Responsable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Responsable;
	private Date Fecha_asignacion;
	private Date Fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_Uresponsable;

	public Asignacion_Responsable() {
		super();
	}

	public Asignacion_Responsable(Date fecha_asignacion, Date fecha_fin, Activo id_activo, Usuario id_Uresponsable) {
		super();
		Fecha_asignacion = fecha_asignacion;
		Fecha_fin = fecha_fin;
		this.id_activo = id_activo;
		this.id_Uresponsable = id_Uresponsable;
	}

	public long getId_asignacion_Responsable() {
		return id_asignacion_Responsable;
	}

	public void setId_asignacion_Responsable(long id_asignacion_Responsable) {
		this.id_asignacion_Responsable = id_asignacion_Responsable;
	}

	public Date getFecha_asignacion() {
		return Fecha_asignacion;
	}

	public void setFecha_asignacion(Date fecha_asignacion) {
		Fecha_asignacion = fecha_asignacion;
	}

	public Date getFecha_fin() {
		return Fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		Fecha_fin = fecha_fin;
	}

	public Activo getId_activo() {
		return id_activo;
	}

	public void setId_activo(Activo id_activo) {
		this.id_activo = id_activo;
	}

	public Usuario getId_Uresponsable() {
		return id_Uresponsable;
	}

	public void setId_Uresponsable(Usuario id_Uresponsable) {
		this.id_Uresponsable = id_Uresponsable;
	}
	
}

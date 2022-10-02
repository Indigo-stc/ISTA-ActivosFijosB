package ista.activosfijos.api.models.entity.primary;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Asignacion_Responsable")
public class Asignacion_Responsable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Responsable;

	@Column(name="fecha_asignacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_asignacion;

	@PrePersist
	public void prePersist() {
		fecha_asignacion = new Date();
		//fecha_fin = new Date();
	};

	@Column(name="fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_Uresponsable;

	public Asignacion_Responsable() {
		super();
	}

	public Asignacion_Responsable( Date fecha_fin, Activo id_activo, Usuario id_Uresponsable) {
		this.fecha_fin = fecha_fin;
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
		return fecha_asignacion;
	}

	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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

package ista.activosfijos.api.models.entity.primary;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Asignacion_Departamento")
public class Asignacion_Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Departamento;

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
	@JoinColumn(name="id_departamento")
	private Departamento id_departamento;

	
	public Asignacion_Departamento() {
		super();
	}

	public Asignacion_Departamento(Date fecha_fin, Activo id_activo, Departamento id_departamento) {
		this.fecha_fin = fecha_fin;
		this.id_activo = id_activo;
		this.id_departamento = id_departamento;
	}

	public long getId_asignacion_Departamento() {
		return id_asignacion_Departamento;
	}

	public void setId_asignacion_Departamento(long id_asignacion_Departamento) {
		this.id_asignacion_Departamento = id_asignacion_Departamento;
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

	public Departamento getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamento id_departamento) {
		this.id_departamento = id_departamento;
	}
}

package ista.activosfijos.api.models.entity.primary;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Asignacion_Custodio")
public class Asignacion_Custodio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Custodio;

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
	private Usuario id_Ucustodio;

	public Asignacion_Custodio() {
		super();
	}

	public Asignacion_Custodio(Date fecha_fin, Activo id_activo, Usuario id_Ucustodio) {
		this.fecha_fin = fecha_fin;
		this.id_activo = id_activo;
		this.id_Ucustodio = id_Ucustodio;
	}

	public long getId_asignacion_Custodio() {
		return id_asignacion_Custodio;
	}

	public void setId_asignacion_Custodio(long id_asignacion_Custodio) {
		this.id_asignacion_Custodio = id_asignacion_Custodio;
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
		fecha_fin = fecha_fin;
	}

	public Activo getId_activo() {
		return id_activo;
	}

	public void setId_activo(Activo id_activo) {
		this.id_activo = id_activo;
	}

	public Usuario getId_Ucustodio() {
		return id_Ucustodio;
	}

	public void setId_Ucustodio(Usuario id_Ucustodio) {
		this.id_Ucustodio = id_Ucustodio;
	}
}
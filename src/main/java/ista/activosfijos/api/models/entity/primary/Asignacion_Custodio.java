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
@Table(name="Asignacion_Custodio")
public class Asignacion_Custodio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Custodio;
	private Date Fecha_asignacion;
	private Date Fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_Ucustodio;

	public Asignacion_Custodio() {
		super();
	}

	public Asignacion_Custodio(Date fecha_asignacion, Date fecha_fin, Activo id_activo, Usuario id_Ucustodio) {
		super();
		Fecha_asignacion = fecha_asignacion;
		Fecha_fin = fecha_fin;
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

	public Usuario getId_Ucustodio() {
		return id_Ucustodio;
	}

	public void setId_Ucustodio(Usuario id_Ucustodio) {
		this.id_Ucustodio = id_Ucustodio;
	}
	
	
}
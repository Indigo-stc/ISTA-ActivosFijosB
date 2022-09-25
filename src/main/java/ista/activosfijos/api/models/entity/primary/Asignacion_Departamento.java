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
@Table(name="Asignacion_Departamento")
public class Asignacion_Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_asignacion_Departamento;
	private Date Fecha_asignacion;
	private Date Fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento id_departamento;

	
	public Asignacion_Departamento() {
		super();
	}

	public Asignacion_Departamento(Date fecha_asignacion, Date fecha_fin, Activo id_activo,
			Departamento id_departamento) {
		super();
		Fecha_asignacion = fecha_asignacion;
		Fecha_fin = fecha_fin;
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

	public Departamento getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamento id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
}

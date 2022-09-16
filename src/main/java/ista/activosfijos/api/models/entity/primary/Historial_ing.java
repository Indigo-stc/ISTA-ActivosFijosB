package ista.activosfijos.api.models.entity.primary;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Historial_ing")
public class Historial_ing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long historial_ing;
	
	private String estado_fisico;
	private Date fecha_ingreso;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario uResponsable;
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento id_departamento;
	
	@OneToOne
	@JoinColumn(name="id_detalle_ing")
	private Detalle_ing id_detalle_ing;
	
	@OneToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;

	public Historial_ing() {
		super();
	}

	public Historial_ing(String estado_fisico, Date fecha_ingreso, Usuario uResponsable, Departamento id_departamento,
			Detalle_ing id_detalle_ing, Activo id_activo) {
		super();
		this.estado_fisico = estado_fisico;
		this.fecha_ingreso = fecha_ingreso;
		this.uResponsable = uResponsable;
		this.id_departamento = id_departamento;
		this.id_detalle_ing = id_detalle_ing;
		this.id_activo = id_activo;
	}

	public long getHistorial_ing() {
		return historial_ing;
	}

	public void setHistorial_ing(long historial_ing) {
		this.historial_ing = historial_ing;
	}

	

	public String getEstado_fisico() {
		return estado_fisico;
	}

	public void setEstado_fisico(String estado_fisico) {
		this.estado_fisico = estado_fisico;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Usuario getuResponsable() {
		return uResponsable;
	}

	public void setuResponsable(Usuario uResponsable) {
		this.uResponsable = uResponsable;
	}

	public Departamento getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamento id_departamento) {
		this.id_departamento = id_departamento;
	}

	public Detalle_ing getId_detalle_ing() {
		return id_detalle_ing;
	}

	public void setId_detalle_ing(Detalle_ing id_detalle_ing) {
		this.id_detalle_ing = id_detalle_ing;
	}

	public Activo getId_activo() {
		return id_activo;
	}

	public void setId_activo(Activo id_activo) {
		this.id_activo = id_activo;
	}
	

}

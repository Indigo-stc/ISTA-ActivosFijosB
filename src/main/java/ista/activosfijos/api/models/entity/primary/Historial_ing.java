package ista.activosfijos.api.models.entity.primary;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="historial_ing")
public class Historial_ing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_historial_ing;
	
	private String estado_fisico;
	@Column(name="fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fecha_ingreso;

	@PrePersist
	public void prePersist() {
		fecha_ingreso = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_responsable;
	
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
	}

	public long getId_historial_ing() {
		return id_historial_ing;
	}

	public void setId_historial_ing(long id_historial_ing) {
		this.id_historial_ing = id_historial_ing;
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

	public Usuario getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(Usuario id_responsable) {
		this.id_responsable = id_responsable;
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

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
@Table(name="Encabezado_ing")
public class Encabezado_ing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_encabezado_ing;
	
	private String num_recep;
	private Date fecha_ingreso;
	private String Documento;
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_procedencia")
	private Procedencia procedencia;
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	// Relacion
	//@OneToMany(mappedBy = "encabezado_ing")
	//List<Detalle_ing> Detalle_ing;

	public Encabezado_ing() {
		super();
	}



	public Encabezado_ing(String num_recep, Date fecha_ingreso, String documento, boolean estado,
			Procedencia procedencia, Departamento departamento, Usuario usuario) {
		super();
		this.num_recep = num_recep;
		this.fecha_ingreso = fecha_ingreso;
		Documento = documento;
		this.estado = estado;
		this.procedencia = procedencia;
		this.departamento = departamento;
		this.usuario = usuario;
		//Detalle_ing = detalle_ing;
	}


	public String getNum_recep() {
		return num_recep;
	}



	public void setNum_recep(String num_recep) {
		this.num_recep = num_recep;
	}





	public long getId_encabezado_ing() {
		return id_encabezado_ing;
	}

	public void setId_encabezado_ing(long id_encabezado_ing) {
		this.id_encabezado_ing = id_encabezado_ing;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Procedencia getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
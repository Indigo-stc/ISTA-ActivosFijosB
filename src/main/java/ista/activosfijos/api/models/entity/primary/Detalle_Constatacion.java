package ista.activosfijos.api.models.entity.primary;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Detalle_Constatacion")
public class Detalle_Constatacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_detalle_Constatacion;
	
	private String nombres_Uconstatante;
	private String Cedula_Uconstatante;
	private String Observaciones;
	private boolean presencia_Activo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_Uconstatante;
	
	@ManyToOne
	@JoinColumn(name="id_activo")
	private Activo id_activo;
	
	@ManyToOne
	@JoinColumn(name="id_encabezado_Constatacion")
	private Encabezado_Constatacion id_encabezado_Constatacion;

	public Detalle_Constatacion() {
		super();
	}

	public Detalle_Constatacion(String nombres_Uconstatante, String cedula_Uconstatante, String observaciones,
			boolean presencia_Activo, Usuario id_Uconstatante, Activo id_activo,
			Encabezado_Constatacion id_encabezado_Constatacion) {
		super();
		this.nombres_Uconstatante = nombres_Uconstatante;
		Cedula_Uconstatante = cedula_Uconstatante;
		Observaciones = observaciones;
		this.presencia_Activo = presencia_Activo;
		this.id_Uconstatante = id_Uconstatante;
		this.id_activo = id_activo;
		this.id_encabezado_Constatacion = id_encabezado_Constatacion;
	}

	public long getId_detalle_Constatacion() {
		return id_detalle_Constatacion;
	}

	public void setId_detalle_Constatacion(long id_detalle_Constatacion) {
		this.id_detalle_Constatacion = id_detalle_Constatacion;
	}

	public String getNombres_Uconstatante() {
		return nombres_Uconstatante;
	}

	public void setNombres_Uconstatante(String nombres_Uconstatante) {
		this.nombres_Uconstatante = nombres_Uconstatante;
	}

	public String getCedula_Uconstatante() {
		return Cedula_Uconstatante;
	}

	public void setCedula_Uconstatante(String cedula_Uconstatante) {
		Cedula_Uconstatante = cedula_Uconstatante;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public boolean isPresencia_Activo() {
		return presencia_Activo;
	}

	public void setPresencia_Activo(boolean presencia_Activo) {
		this.presencia_Activo = presencia_Activo;
	}

	public Usuario getId_Uconstatante() {
		return id_Uconstatante;
	}

	public void setId_Uconstatante(Usuario id_Uconstatante) {
		this.id_Uconstatante = id_Uconstatante;
	}

	public Activo getId_activo() {
		return id_activo;
	}

	public void setId_activo(Activo id_activo) {
		this.id_activo = id_activo;
	}

	public Encabezado_Constatacion getId_encabezado_Constatacion() {
		return id_encabezado_Constatacion;
	}

	public void setId_encabezado_Constatacion(Encabezado_Constatacion id_encabezado_Constatacion) {
		this.id_encabezado_Constatacion = id_encabezado_Constatacion;
	}
	
	
}

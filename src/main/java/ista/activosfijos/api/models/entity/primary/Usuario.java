package ista.activosfijos.api.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "cedula"),
				@UniqueConstraint(columnNames = "correo")
		})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_usuario;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String contrasenia;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_roles",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles = new HashSet<>();


	public Usuario(String cedula, String nombre, String apellido, String contrasenia, String correo) {
		this.cedula = cedula;
		this.nombres = nombre;
		this.apellidos = apellido;
		this.contrasenia = contrasenia;
		this.correo = correo;
	}
}

package ista.activosfijos.api.models.entity.secundary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "verpersonaf")
@NoArgsConstructor
@AllArgsConstructor
public class verpersonaf {

	@Id
    @Column(name = "cedula", nullable = false,updatable = false)
    private String cedula;
    private String correo_institucional;
    private String nombres;
    private String apellidos;
}
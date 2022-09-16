package ista.activosfijos.api.models.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
public class SignupRequest {

    @NotBlank
    private String cedula;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Email
    private String correo;
    @NotBlank
    private String contrasenia;
    @NotNull
    private Set<String> roles;

}

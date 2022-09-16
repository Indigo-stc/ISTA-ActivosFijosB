package ista.activosfijos.api.models.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginRequest {

    @NotBlank
    private String cedula;
    @NotBlank
    private String contrasenia;

}

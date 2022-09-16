package ista.activosfijos.api.models.dtos.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class JwtResponse {

    @NonNull
    private String token;
    private String type = "Bearer";
    @NonNull
    private Long id;
    @NonNull
    private String cedula;
    @NonNull
    private String correo;
    @NonNull
    private List<String> roles;

}

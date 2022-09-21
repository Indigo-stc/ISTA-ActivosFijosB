package ista.activosfijos.api.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UserInfoResponse {
	private Long id;
	private String correo;
	private List<String> roles;
}

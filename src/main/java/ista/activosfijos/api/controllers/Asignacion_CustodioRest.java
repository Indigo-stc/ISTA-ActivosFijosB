package ista.activosfijos.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.activosfijos.api.models.entity.primary.Asignacion_Custodio;
import ista.activosfijos.api.models.services.Asignacion_custodioService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/asignacionCustodioActivo")
public class Asignacion_CustodioRest {

	@Autowired
	private Asignacion_custodioService asignacioncustodioservice;
	
	@GetMapping("/listarCustodios/")
	public List<Asignacion_Custodio> listarAsignacionCustodio(){
		return asignacioncustodioservice.findAllAsignacionCustodio();
	}
	

	@PostMapping("/guardarasignacionCustodioActivo")
	public Asignacion_Custodio guardarAsignacion_Custodio (@RequestBody Asignacion_Custodio asignacion_Custodio) {
		return this.asignacioncustodioservice.guardarAsignacionCustodio(asignacion_Custodio);
	}
			
	@DeleteMapping(value = "/eliminarAsignacionCustodioActivo/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		asignacioncustodioservice.eliminarAsignacionCustodio(id);
	}
	
	@GetMapping(value = "/buscarAsignacionCustodioActivoPorId/{id}")
	public Asignacion_Custodio findById(@PathVariable("id") Long id) {
		 return this.asignacioncustodioservice.findByIdAsignacionCustodio(id);
	}
			
	
}
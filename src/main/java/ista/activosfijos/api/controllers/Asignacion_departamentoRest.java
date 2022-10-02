package ista.activosfijos.api.controllers;
import java.util.List;

import ista.activosfijos.api.models.entity.primary.Asignacion_Departamento;
import ista.activosfijos.api.models.services.Asignacion_departamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/Asignacion_Departamento/")
public class Asignacion_departamentoRest {
	
	@Autowired
	private Asignacion_departamentoService asignacion_departamentoService;
	
		@GetMapping("/listarAsignacion_Departamento/")
		public List<Asignacion_Departamento> listarAsignacion_Departamento(){
			return asignacion_departamentoService.findAllAsignacion_Departamento();
		}

		@PostMapping("/guardarAsignacion_Departamento")
		public Asignacion_Departamento guardarAsignacion_Departamento (@RequestBody Asignacion_Departamento asignacion_Departamento) {
			return this.asignacion_departamentoService.guardarAsignacion_Departamento(asignacion_Departamento);
		}
				
		@DeleteMapping(value = "/eliminarAsignacion_Departamento/{id}")
		public void EliminarAsignacion_Departamento(@PathVariable("id") Long id) {
			asignacion_departamentoService.eliminarAsignacion_Departamento(id);
		}
				
		@GetMapping(value = "/buscarAsignacion_DepartamentoporId/{id}")
		public Asignacion_Departamento findById(@PathVariable("id") Long id) {
			 return this.asignacion_departamentoService.findByIdAsignacion_Departamento(id);
		}
		
		@PutMapping("/actualizarAsignacion_Departamento")
	    public ResponseEntity<?> updateAsignacion_Departamento(@RequestBody Asignacion_Departamento asignacion_Departamento) {
			asignacion_departamentoService.updateAsignacion_Departamento(asignacion_Departamento);
	       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
		}
}





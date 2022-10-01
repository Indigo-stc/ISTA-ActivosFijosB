package ista.activosfijos.api.controllers;
import java.util.List;

import ista.activosfijos.api.models.entity.primary.Asignacion_Responsable;
import ista.activosfijos.api.models.services.Asignacion_responsableService;
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
@RequestMapping("/api/Asignacion_Responsable/")
public class Asignacion_responsableRest {
	
	@Autowired
	private Asignacion_responsableService asignacion_responsableService;
	
		@GetMapping("/listarAsignacion_Responsable/")
		public List<Asignacion_Responsable> listarAsignacion_Responsable(){
			return asignacion_responsableService.findAllAsignacion_Responsable();
		}

		@PostMapping("/guardarAsignacion_Responsable")
		public Asignacion_Responsable guardarAsignacion_Responsable(@RequestBody Asignacion_Responsable asignacion_Responsable) {
			return this.asignacion_responsableService.guardarAsignacion_Responsable(asignacion_Responsable);
		}
				
		@DeleteMapping(value = "/eliminarAsignacion_Responsable/{id}")
		public void EliminarAsignacion_Responsable(@PathVariable("id") Long id) {
			asignacion_responsableService.eliminarAsignacion_Responsable(id);
		}
				
		@GetMapping(value = "/buscarAsignacion_ResponsablePorId/{id}")
		public Asignacion_Responsable findById(@PathVariable("id") Long id) {
			 return this.asignacion_responsableService.findByIdAsignacion_Responsable(id);
		}
		
		@PutMapping("/actualizarAsignacion_Responsable")
	    public ResponseEntity<?> updateAsignacion_Responsable(@RequestBody Asignacion_Responsable asignacion_Responsable) {
			asignacion_responsableService.updateAsignacion_Responsable(asignacion_Responsable);
	       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
}
}

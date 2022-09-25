package ista.activosfijos.api.controllers;

import java.util.List;
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

import ista.activosfijos.api.models.entity.primary.Activo;
import ista.activosfijos.api.models.services.ActivoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/activos/")
public class ActivoRest {

	@Autowired
	private ActivoService activoService;
	
		@GetMapping("/listarActivos/")
		public List<Activo> listarActivos(){
			return activoService.findAllActivo();
		}

		@PostMapping("/guardarActivos")
		public Activo guardarActivo (@RequestBody Activo activo) {
			return this.activoService.guardarActivo(activo);
		}
				
		@DeleteMapping(value = "/eliminarActivo/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			activoService.eliminarActivo(id);
		}
				
		@GetMapping(value = "/buscarActivoPorId/{id}")
		public Activo findById(@PathVariable("id") Long id) {
			 return this.activoService.findByIdActivo(id);
		}
		
		@PutMapping("/actualizarActivo")
	    public ResponseEntity<?> updateProcedencia(@RequestBody Activo activo) {
			activoService.updateActivo(activo);
	       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
	}
		

}

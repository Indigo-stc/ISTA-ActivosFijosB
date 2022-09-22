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

import ista.activosfijos.api.models.entity.primary.Procedencia;
import ista.activosfijos.api.models.services.ProcedenciaService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/procedencias")
public class ProcedenciaRest {
	
		@Autowired
		private ProcedenciaService procedenciaService;
		
		@GetMapping("/listarProcedencia")
		public List<Procedencia> listarProcedencia () {
			return procedenciaService.findAllProcedencia();
		}

		@PostMapping("/guardarProcedencia")
		public Procedencia guardarProcedencia (@RequestBody Procedencia procedencia) {
			return this.procedenciaService.guardarProcedencia(procedencia);
		}
		
		@DeleteMapping(value = "/eliminarProcedencia/{id}")
		public ResponseEntity<Boolean> eliminarActivo(@PathVariable("id") Long id) {
			procedenciaService.eliminarProcedencia(id);
			return ResponseEntity.ok(!(procedenciaService.findByIdProcedencia(id)!=null));
		}

		@GetMapping(value = "/buscarProcedenciaPorId/{id}")
		public Procedencia findById(@PathVariable("id") Long id) {
			 return this.procedenciaService.findByIdProcedencia(id);
		}
		
		@PutMapping("/actualizarProcedencia")
		    public ResponseEntity<?> updateProcedencia(@RequestBody Procedencia procedencia) {
			 procedenciaService.updateProcedencia(procedencia);
		       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
		}
}


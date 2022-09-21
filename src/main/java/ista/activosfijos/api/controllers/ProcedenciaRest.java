package ista.activosfijos.api.controllers;

import java.net.URI;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import ista.activosfijos.api.models.entity.primary.Procedencia;
import ista.activosfijos.api.models.services.ProcedenciaService;


//@RequestMapping para las URL para acceder al servicio


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/procedencia")
@Slf4j
public class ProcedenciaRest {
	
		// 1. necesitamos los servicios y hay que llamarlos
		@Autowired
		private ProcedenciaService procedenciaService;
	
	
		// 2. Aqui irian todos los metodos CRUD
		@GetMapping("/listar")
		@PreAuthorize("hasRole('RESPONSABLE')")
		public List<Procedencia> listarProcedencia () {
			return procedenciaService.findAllProcedencia();
		}
	
	
		// GUARDAR UNA PROCEDENCIA

		@PreAuthorize("hasRole('RESPONSABLE')")
		@PostMapping("/save")
		public Procedencia guardarEmpleado (@RequestBody Procedencia procedencia) {
			return this.procedenciaService.guardarProcedencia(procedencia);
		}

		@PutMapping("/update/pro")
		public ResponseEntity<?> updateProcedencia(@RequestBody Procedencia procedencia) {
			procedenciaService.updateProcedencia(procedencia);
			return new ResponseEntity<>(("Procedencia Guardado"), HttpStatus.CREATED);
		}

	    @PreAuthorize("hasRole('RESPONSABLE')")
		@DeleteMapping(value = "/delete/{id}")
		public ResponseEntity<Boolean> eliminarActivo(@PathVariable("id") Long id) {
			procedenciaService.eliminarProcedencia(id);
			return ResponseEntity.ok(!(procedenciaService.findByIdProcedencia(id)!=null));
		}

		/*@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			procedenciaService.eliminarProcedencia(id);
		}*/
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Procedencia findById(@PathVariable("id") Long id) {
			 return this.procedenciaService.findByIdProcedencia(id);
		}
		
		//***************************************************************************************
}

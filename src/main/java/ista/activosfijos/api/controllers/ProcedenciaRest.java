package ista.activosfijos.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.activosfijos.api.models.entity.primary.Procedencia;
import ista.activosfijos.api.models.services.ProcedenciaService;


//@RequestMapping para las URL para acceder al servicio

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/procedencias/")
public class ProcedenciaRest {
	
		// 1. necesitamos los servicios y hay que llamarlos
		@Autowired
		private ProcedenciaService procedenciaService;
	
	
		// 2. Aqui irian todos los metodos CRUD
		@GetMapping
		public List<Procedencia> listarProcedencia () {
			return procedenciaService.findAllProcedencia();
		}
	
	
		// GUARDAR UNA PROCEDENCIA
		@PostMapping
		private ResponseEntity<Procedencia> saveProcedencia (@RequestBody Procedencia procedencia){
			try {
				Procedencia newProcedencia = procedenciaService.guardarProcedencia(procedencia);
				return ResponseEntity.created(new URI("/procedencias/" + newProcedencia.getId_procedencia())).body(newProcedencia);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
		// Delete 2
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

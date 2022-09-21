package ista.activosfijos.api.controllers;

import java.net.URI;
import java.util.List;

import ista.activosfijos.api.models.dao.primary.ProcedenciaRepository;
import ista.activosfijos.api.models.dtos.response.MessageResponse;
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

		@Autowired
		private ProcedenciaRepository procedenciaRepository;
	
	
		// 2. Aqui irian todos los metodos CRUD
		@GetMapping("/listar")
		@PreAuthorize("hasRole('RESPONSABLE')")
		public List<Procedencia> listarProcedencia () {
			return procedenciaService.findAllProcedencia();
		}
	
	
		// GUARDAR UNA PROCEDENCIA
		@PostMapping("/save")
		@PreAuthorize("hasRole('RESPONSABLE')")
		private ResponseEntity<?> saveProcedencia (@RequestBody Procedencia procedencia) {
			log.info("Tamos en el service con id {}", procedencia.getId_procedencia());
			log.info("Tamos en el service con nom {}", procedencia.getNombre_procedencia());
			log.info("Tamos en el service con des {}", procedencia.getDescripcion());

			if(procedencia.getId_procedencia() == 0){
				Procedencia proce = new Procedencia(procedencia.getNombre_procedencia(), procedencia.getDescripcion());
				procedenciaRepository.save(proce);
				return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
			}else{
				Procedencia proce = new Procedencia(procedencia.getId_procedencia(), procedencia.getNombre_procedencia(), procedencia.getDescripcion());
				procedenciaRepository.save(proce);
				return ResponseEntity.ok(new MessageResponse("User update successfully!"));

			}

		}



	@PutMapping("/actualizar/{id}")
	@PreAuthorize("hasRole('RESPONSABLE')")
	public Procedencia update(@RequestBody Procedencia procedencia, @PathVariable Long id) {

		Procedencia procedenciaActual = procedenciaService.findByIdProcedencia(id);

		procedenciaActual.setNombre_procedencia(procedencia.getNombre_procedencia());
		procedenciaActual.setDescripcion(procedencia.getDescripcion());

		return procedenciaService.guardarProcedencia(procedenciaActual);
	}
		/*@PreAuthorize("hasRole('RESPONSABLE')")
		@PostMapping("/save/")
		public Procedencia guardarEmpleado (@RequestBody Procedencia procedencia) {
			return this.procedenciaService.guardarProcedencia(procedencia);
		}*/

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

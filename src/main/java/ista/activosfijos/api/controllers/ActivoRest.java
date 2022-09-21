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


import ista.activosfijos.api.models.entity.primary.Activo;
import ista.activosfijos.api.models.services.ActivoService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/activos/")
public class ActivoRest {

	@Autowired
	private ActivoService activoService;
	
		// ACTIVO ****************************************************************************
	
		@GetMapping
		public List<Activo> listarActivos(){
			return activoService.findAllActivo();
		}
		

		@PostMapping
		private ResponseEntity<Activo> saveActivo (@RequestBody Activo activo){
			
			try {
				Activo newActivo = activoService.guardarActivo(activo);
				return ResponseEntity.created(new URI("/activos/" + newActivo.getId_activo())).body(newActivo);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			activoService.eliminarActivo(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Activo findById(@PathVariable("id") Long id) {
			 return this.activoService.findByIdActivo(id);
		}
		
		//***************************************************************************************
	

}

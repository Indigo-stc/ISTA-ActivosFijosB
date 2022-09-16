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

import ista.activosfijos.api.models.entity.primary.Edificio;
import ista.activosfijos.api.models.services.EdificiosService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/edificios/")

public class EdificiosRest {
	
	@Autowired
	private EdificiosService edificioService;
	
	
		@GetMapping
		public List<Edificio> listarEdificios(){
			return edificioService.findAllEdificio();
		}
		

		@PostMapping
		private ResponseEntity<Edificio> saveEdificio (@RequestBody Edificio edificio){
			
			try {
				Edificio newEdificio = edificioService.guardarEdificio(edificio);
				return ResponseEntity.created(new URI("/edificios/" + newEdificio.getId_edificio())).body(newEdificio);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			edificioService.eliminarEdificio(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Edificio findById(@PathVariable("id") Long id) {
			 return this.edificioService.findByIdEdificio(id);
		}
		
		//***************************************************************************************
	

}

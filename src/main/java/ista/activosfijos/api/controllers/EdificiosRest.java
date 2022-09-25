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

import ista.activosfijos.api.models.entity.primary.Edificio;
import ista.activosfijos.api.models.services.EdificiosService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/edificios")

public class EdificiosRest {
	
	@Autowired
	private EdificiosService edificioService;
	
	@GetMapping("/listarEdificios")
	public List<Edificio> listarEdificios(){
		return edificioService.findAllEdificio();
	}
	
	@PostMapping("/guardarEdificio")
	public Edificio guardarEdificio(@RequestBody Edificio edificio) {
		return this.edificioService.guardarEdificio(edificio);
	}
			
	@DeleteMapping(value = "/elminarEdificio/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		edificioService.eliminarEdificio(id);
	}
	
	
	@GetMapping(value = "/buscarEdificiosPorId/{id}")
	public Edificio findById(@PathVariable("id") Long id) {
		 return this.edificioService.findByIdEdificio(id);
	}
	
	@PutMapping("/actualizarEdificio")
    public ResponseEntity<?> updateEdificio(@RequestBody Edificio edificio) {
		edificioService.updateEdificio(edificio);
       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
	}	
		
	

}

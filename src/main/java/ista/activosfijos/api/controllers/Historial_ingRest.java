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

import ista.activosfijos.api.models.entity.primary.Historial_ing;
import ista.activosfijos.api.models.services.Historial_ingService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/historial_ingresos/")
public class Historial_ingRest {

	@Autowired
	private Historial_ingService historial_ingService;
	
	@GetMapping
	public List<Historial_ing> listarhistorial_ingService(){
		return historial_ingService.findAllHistorial_ing();
	}
		

		@PostMapping
		private ResponseEntity<Historial_ing> savehistorial_ingService (@RequestBody Historial_ing historial_ing){
			
			try {
				Historial_ing newHistorial_ing = historial_ingService.guardarHistorial_ing(historial_ing);
				return ResponseEntity.created(new URI("/historial_ingresos/" + newHistorial_ing.getHistorial_ing())).body(newHistorial_ing);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			historial_ingService.eliminarHistorial_ing(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Historial_ing findById(@PathVariable("id") Long id) {
			 return this.historial_ingService.findByIdHistorial_ing(id);
		}
		
		//***************************************************************************************
	
}

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

import ista.activosfijos.api.models.entity.primary.Encabezado_ing;
import ista.activosfijos.api.models.services.Encabezado_ingService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encabezado_ingresos/")
public class Encabezado_ingRest {


	@Autowired
	private Encabezado_ingService encabezado_ingService;
	
	@GetMapping
	public List<Encabezado_ing> listarEncabezado_ing(){
		return encabezado_ingService.findAllEncabezado_ing();
	}
		

		@PostMapping
		private ResponseEntity<Encabezado_ing> saveEncabezado_ing (@RequestBody Encabezado_ing encabezado_ing){
			
			try {
				Encabezado_ing newEncabezado_ing = encabezado_ingService.guardarEncabezado_ing(encabezado_ing);
				return ResponseEntity.created(new URI("/encabezado_ingresos/" + newEncabezado_ing.getId_encabezado_ing())).body(newEncabezado_ing);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			encabezado_ingService.eliminarEncabezado_ing(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Encabezado_ing findById(@PathVariable("id") Long id) {
			 return this.encabezado_ingService.findByIdEncabezado_ing(id);
		}
		
		//***************************************************************************************
	
}

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

import ista.activosfijos.api.models.entity.primary.Detalle_ing;
import ista.activosfijos.api.models.services.Detalle_ingService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/detalle_ingresos/")
public class Detalle_ingRest {

	
	@Autowired
	private Detalle_ingService detalle_ingService;
	
	@GetMapping
	public List<Detalle_ing> listarDetalleIngreos(){
		return detalle_ingService.findAllDetalle_ing();
	}
		

		@PostMapping
		private ResponseEntity<Detalle_ing> saveDetalleIngreso (@RequestBody Detalle_ing detalle_ing){
			
			try {
				Detalle_ing newDetalle_ing = detalle_ingService.guardarDetalle_ing(detalle_ing);
				return ResponseEntity.created(new URI("/detalle_ingresos/" + newDetalle_ing.getId_detalle_ing())).body(newDetalle_ing);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			detalle_ingService.eliminarDetalle_ing(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Detalle_ing findById(@PathVariable("id") Long id) {
			 return this.detalle_ingService.findByIdDetalle_ing(id);
		}
		
		//***************************************************************************************
	

}

package ista.activosfijos.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ista.activosfijos.api.models.entity.primary.Detalle_ing;
import ista.activosfijos.api.models.services.Detalle_ingService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/detalleIngresos")
public class Detalle_ingRest {

	
	@Autowired
	private Detalle_ingService detalle_ingService;
	
	@GetMapping("/buscarNumRecep/{num_recep}")
	public ResponseEntity<List<Detalle_ing>> Buscarnum_recep(@PathVariable("num_recep") String num_recep) {
		return ResponseEntity.ok(detalle_ingService.findBynum_recep(num_recep));

	}
	
	@GetMapping("/listarDetalleIngresos")
	public List<Detalle_ing> listarDetalleIngreos(){
		return detalle_ingService.findAllDetalle_ing();
	}
		
	@PostMapping("/guardarDetalleIngresos")
	public Detalle_ing guardarDetalle_ing(@RequestBody Detalle_ing detalle_ing) {
		return this.detalle_ingService.guardarDetalle_ing(detalle_ing);
	}
	
	@GetMapping ("/filtrarDetalleIngresos/{id}")
		public ResponseEntity<List<Detalle_ing>> getAllDDetalleEncab (@PathVariable("id") Long id){
			return ResponseEntity.ok(detalle_ingService.findAllByDetalle_ings(id));
	}
				
	@DeleteMapping(value = "/eliminarDetalleIngresos/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		detalle_ingService.eliminarDetalle_ing(id);
	}
	
	
	@GetMapping(value = "/buscarDetalleIngresosPorId/{id}")
	public Detalle_ing findById(@PathVariable("id") Long id) {
		 return this.detalle_ingService.findByIdDetalle_ing(id);
	}
// Detalle ingRest

	@PutMapping("/actualizarDetalle")
	public ResponseEntity<?> updateEdificio(@RequestBody Detalle_ing detalle_ing) {
		detalle_ingService.updateDetalleAlRegistrarActivo(detalle_ing);
		return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
	}


	@GetMapping(value = "/ConteoDeDetalles/{id}")
	public ResponseEntity<List<?>> findByConteoDeDetalles(@PathVariable("id") Long id) {
		return ResponseEntity.ok(detalle_ingService.contarLosDetallesTrue(id));
	}
		

}

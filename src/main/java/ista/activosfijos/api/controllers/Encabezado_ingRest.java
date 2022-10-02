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

import ista.activosfijos.api.models.entity.primary.Encabezado_ing;
import ista.activosfijos.api.models.services.Encabezado_ingService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/encabezadoIngresos")
public class Encabezado_ingRest {


	@Autowired
	private Encabezado_ingService encabezado_ingService;
	
	@GetMapping("/listarEncabezadoIngresos")
	public List<Encabezado_ing> listarEncabezado_ing(){
		return encabezado_ingService.findAllEncabezado_ing();
	}
	
	
	@PostMapping("/guardarEncabezadoIngresos")
	public Encabezado_ing guardarEncabezado_ing(@RequestBody Encabezado_ing encabezado_ing) {
		return this.encabezado_ingService.guardarEncabezado_ing(encabezado_ing);
	}
				
	@DeleteMapping(value = "/eliminarEncabezadoIngresos/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		encabezado_ingService.eliminarEncabezado_ing(id);
	}
	
	
	@GetMapping(value = "/buscarEncabezadoIngresosPorId/{id}")
	public Encabezado_ing findById(@PathVariable("id") Long id) {
		 return this.encabezado_ingService.findByIdEncabezado_ing(id);
	}	
	
	
	@PutMapping("/actualizarEstadoRecepcion")
    public ResponseEntity<?> updateProcedencia(@RequestBody Encabezado_ing encabezado_ing) {
		encabezado_ingService.actualizarEstadoDeEncabezado(encabezado_ing);
       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
	}

	@GetMapping(value = "/Buscar_Nombre_documento/{nombre}")
	public ResponseEntity<List<?>> Buscar_Nombre_documento(@PathVariable("nombre") String nombre_documento) {
		return ResponseEntity.ok(encabezado_ingService.findBynombre_documento(nombre_documento));
	}

	
}

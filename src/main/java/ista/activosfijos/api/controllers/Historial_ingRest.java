package ista.activosfijos.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("api/historialIngresosActivos/")
public class Historial_ingRest {

	@Autowired
	private Historial_ingService historial_ingService;
	
	@GetMapping("listarHistorialIngresoActivos")
	public List<Historial_ing> listarhistorial_ingService(){
		return historial_ingService.findAllHistorial_ing();
	}
	
	@PostMapping("/guardarHistorialIngresosActivos")
	public Historial_ing guardarHistorial_ing(@RequestBody Historial_ing historial_ing) {
		return this.historial_ingService.guardarHistorial_ing(historial_ing);
	}
		
	@DeleteMapping(value = "/eliminarHistorialIngresosActivos/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		historial_ingService.eliminarHistorial_ing(id);
	}
	
	@GetMapping(value = "/buscarHistorialIngresosActivosPorId/{id}")
	public Historial_ing findById(@PathVariable("id") Long id) {
		 return this.historial_ingService.findByIdHistorial_ing(id);
	}
	
				
		
	
}

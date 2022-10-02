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
import ista.activosfijos.api.models.entity.primary.Departamento;
import ista.activosfijos.api.models.services.DepartamentosService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/departamentos/")
public class DepartamentosRest {

	@Autowired
	private DepartamentosService departamentoService;
	
	
	@GetMapping ("/listarDepartamentos")
	public List<Departamento> listarDepartamentos(){
		return departamentoService.findAllDepartamento();
	}
		
	@PostMapping("/guardarDepartamento/")
	public Departamento guardarDepartamento (@RequestBody Departamento departamento) {
		return this.departamentoService.guardarDepartamento(departamento);
	}
				
	@DeleteMapping(value = "/eliminarDepartamento/{id}")
	public void Eliminar(@PathVariable("id") Long id) {
		departamentoService.eliminarDepartamento(id);
	}
	

	@GetMapping(value = "/buscarDepartamento/{id}")
	public Departamento findById(@PathVariable("id") Long id) {
		 return this.departamentoService.findByIdDepartamento(id);
	}
	

	@PutMapping("/actualizarDepartamento")
    public ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento) {
		departamentoService.updateDepartamento(departamento);
       return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
	}

	@GetMapping("/buscarDepartamentoPorEdifcio/{id}")
	public ResponseEntity<List<Departamento>> buscarDepartametoPorEdificio(@PathVariable("id") Long id) {
		return ResponseEntity.ok(departamentoService.buscarDepartamentoPorEdifico(id));
	}

	@GetMapping(value = "/validarExistenciaNombreDepartamento/{nombre_departamento}")
	public ResponseEntity<List<?>> findByNombreDepartamento(@PathVariable("nombre_departamento") String nombre_departamento) {
		return ResponseEntity.ok(departamentoService.validarExistenciaNombreDepartamento(nombre_departamento));
	}
}

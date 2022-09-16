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

import ista.activosfijos.api.models.entity.primary.Departamento;
import ista.activosfijos.api.models.services.DepartamentosService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/departamentos/")
public class DepartamentosRest {

	@Autowired
	private DepartamentosService departamentoService;
	
	// Traer todos segun su Id de edificio
	@GetMapping ("{id}")
	public ResponseEntity<List<Departamento>> getAllDepBEdificios (@PathVariable("id") Long id){
		return ResponseEntity.ok(departamentoService.findAllByEdificio(id));
		
	}
	
	
	@GetMapping
	public List<Departamento> listarDepartamentos(){
		return departamentoService.findAllDepartamento();
	}
		

		@PostMapping
		private ResponseEntity<Departamento> saveDepartamento (@RequestBody Departamento departamento){
			
			try {
				Departamento newDepartamento = departamentoService.guardarDepartamento(departamento);
				return ResponseEntity.created(new URI("/departamentos/" + newDepartamento.getId_departamento())).body(newDepartamento);

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		}
				
		@DeleteMapping(value = "/delete/{id}")
		public void Eliminar(@PathVariable("id") Long id) {
			departamentoService.eliminarDepartamento(id);
		}
		
		//**************************************************************************************
		
		@GetMapping(value = "/buscar/{id}")
		public Departamento findById(@PathVariable("id") Long id) {
			 return this.departamentoService.findByIdDepartamento(id);
		}
		
		//***************************************************************************************
	

}

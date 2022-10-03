package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.entity.primary.Detalle_Constatacion;
import ista.activosfijos.api.models.services.Detalle_constatacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/Detalle_Constatacion/")
public class Detalle_constatacionRest {
    @Autowired
    private Detalle_constatacionService detalle_constatacionService;

    @GetMapping("/listarDetalle_Constatacion/")
    public List<Detalle_Constatacion> listarDetalle_constatacion(){
        return detalle_constatacionService.findAll();
    }

    @PostMapping("/guardarDetalle_Constatacion")
    public Detalle_Constatacion guardarActivo (@RequestBody Detalle_Constatacion detalle_constatacion) {
        return this.detalle_constatacionService.guardarDetalle_Constatacion(detalle_constatacion);
    }

    @DeleteMapping(value = "/eliminarDetalle_Constatacion/{id}")
    public void Eliminar(@PathVariable("id") Long id) {
        detalle_constatacionService.eliminarDetalle_Constatacion(id);
    }

    @GetMapping(value = "/buscarDetalle_ConstatacionPorId/{id}")
    public Detalle_Constatacion findById(@PathVariable("id") Long id) {
        return this.detalle_constatacionService.findByIdDetalle_Constatacion(id);
    }

    @PutMapping("/actualizarDetalle_Constatacion")
    public ResponseEntity<?> updateProcedencia(@RequestBody Detalle_Constatacion detalle_constatacion) {
        detalle_constatacionService.updateDetalle_Constatacion(detalle_constatacion);
        return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
    }


}

package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.services.Encabezado_constatacionService;
import ista.activosfijos.api.models.entity.primary.Encabezado_Constatacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/Encabezado_constatacion")
public class Encabezado_constatacionRest {
    @Autowired
    private Encabezado_constatacionService encabezado_constatacionService;

    @GetMapping("/listarEncabezado_constatacion")
    public List<Encabezado_Constatacion> listarEncabezado_Constatacion(){
        return encabezado_constatacionService.findAllEncabezado_Constatacion();
    }

    @PostMapping("/guardarEncabezado_constatacion")
    public Encabezado_Constatacion guardaEncabezado_Constatacion (@RequestBody Encabezado_Constatacion encabezado_constatacion) {
        return this.encabezado_constatacionService.guardarEncabezado_Constatacion(encabezado_constatacion);
    }

    @DeleteMapping(value = "/eliminarEncabezado_constatacion/{id}")
    public void EliminarEncabezado_Constatacion(@PathVariable("id") Long id) {
        encabezado_constatacionService.eliminarEncabezado_Constatacion(id);
    }

    @GetMapping(value = "/buscarEncabezado_constatacionPorId/{id}")
    public Encabezado_Constatacion findByIdEncabezado_Constatacion(@PathVariable("id") Long id) {
        return this.encabezado_constatacionService.findByIdEncabezado_Constatacion(id);
    }

    @PutMapping("/Encabezado_constatacionActivo")
    public ResponseEntity<?> updateEncabezado_Constatacion(@RequestBody Encabezado_Constatacion encabezado_constatacion) {
        encabezado_constatacionService.updateEncabezado_Constatacion(encabezado_constatacion);
        return new ResponseEntity<>(("Actualizado"), HttpStatus.CREATED);
    }

}

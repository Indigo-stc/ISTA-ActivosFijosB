package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.dao.primary.Encabezado_constatacionRepository;
import ista.activosfijos.api.models.entity.primary.Encabezado_Constatacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Encabezado_constatacionService implements IEncabezado_constatacionService {

    @Autowired
    private Encabezado_constatacionRepository encabezado_constatacionRepository;


    @Override
    public List<Encabezado_Constatacion> findAllEncabezado_Constatacion() {
        return  (List<Encabezado_Constatacion>) encabezado_constatacionRepository.findAll();
    }

    @Override
    public Encabezado_Constatacion guardarEncabezado_Constatacion(Encabezado_Constatacion encabezado_constatacion) {
        return  encabezado_constatacionRepository.save(encabezado_constatacion);
    }

    @Override
    public Encabezado_Constatacion findByIdEncabezado_Constatacion(Long id) {
        return encabezado_constatacionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEncabezado_Constatacion(Long id) {
        this.encabezado_constatacionRepository.deleteById(id);
    }

    public boolean updateEncabezado_Constatacion (Encabezado_Constatacion encabezado_constatacion) {
        Optional<Encabezado_Constatacion> exists = encabezado_constatacionRepository.findById(encabezado_constatacion.getId_encabezado_Constatacion());

        if (exists.isPresent()) {
            Encabezado_Constatacion Encabezado_ConstatacionActual = exists.get();
            Encabezado_ConstatacionActual.setFecha_Constatacion(encabezado_constatacion.getFecha_Constatacion());
            Encabezado_ConstatacionActual.setId_Uresponsable(encabezado_constatacion.getId_Uresponsable());
            Encabezado_ConstatacionActual.setNombres_Responsable(encabezado_constatacion.getNombres_Responsable());
            Encabezado_ConstatacionActual.setCedula_Responsable(encabezado_constatacion.getCedula_Responsable());
            Encabezado_ConstatacionActual.setObservaciones(encabezado_constatacion.getObservaciones());
            Encabezado_ConstatacionActual.setCantactivos_Constatados(encabezado_constatacion.getCantactivos_Constatados());
            Encabezado_ConstatacionActual.setCantactivos_Noconstatados(encabezado_constatacion.getCantactivos_Noconstatados());
            Encabezado_ConstatacionActual.setEstado(encabezado_constatacion.isEstado());
            encabezado_constatacionRepository.save(Encabezado_ConstatacionActual);

            return true;
        } else {
            return false;
        }
    }

}

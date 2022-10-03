package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.dao.primary.Detalle_constatacionRepository;
import ista.activosfijos.api.models.entity.primary.Detalle_Constatacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_constatacionService implements IDetalle_constatacionService{

    @Autowired
    private Detalle_constatacionRepository detalle_constatacionRepository;


    @Override
    public List<Detalle_Constatacion> findAll() {
        return (List<Detalle_Constatacion>) detalle_constatacionRepository.findAll();
    }

    @Override
    public Detalle_Constatacion guardarDetalle_Constatacion(Detalle_Constatacion detalle_constatacion) {
        return detalle_constatacionRepository.save(detalle_constatacion);
    }

    @Override
    public Detalle_Constatacion findByIdDetalle_Constatacion(Long id) {
        return detalle_constatacionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarDetalle_Constatacion(Long id) {
        this.detalle_constatacionRepository.deleteById(id);
    }

    public boolean updateDetalle_Constatacion (Detalle_Constatacion detalle_constatacion) {
        Optional<Detalle_Constatacion> exists = detalle_constatacionRepository.findById(detalle_constatacion.getId_detalle_Constatacion());

        if (exists.isPresent()) {
            Detalle_Constatacion Detalle_ConstatacionActual = exists.get();
            Detalle_ConstatacionActual.setId_encabezado_Constatacion(detalle_constatacion.getId_encabezado_Constatacion());
            Detalle_ConstatacionActual.setId_activo(detalle_constatacion.getId_activo());
            Detalle_ConstatacionActual.setId_Uconstatante(detalle_constatacion.getId_Uconstatante());
            Detalle_ConstatacionActual.setCedula_Uconstatante(detalle_constatacion.getCedula_Uconstatante());
            Detalle_ConstatacionActual.setNombres_Uconstatante(detalle_constatacion.getNombres_Uconstatante());
            Detalle_ConstatacionActual.setObservaciones(detalle_constatacion.getObservaciones());
            Detalle_ConstatacionActual.setPresencia_Activo(detalle_constatacion.isPresencia_Activo());

            detalle_constatacionRepository.save(Detalle_ConstatacionActual);

            return true;
        } else {
            return false;
        }
    }
}

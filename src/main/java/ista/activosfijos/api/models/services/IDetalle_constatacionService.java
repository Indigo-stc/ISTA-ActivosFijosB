package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.entity.primary.Detalle_Constatacion;

import java.util.List;

public interface IDetalle_constatacionService {
    public List<Detalle_Constatacion> findAll();

    public Detalle_Constatacion guardarDetalle_Constatacion(Detalle_Constatacion Detalle_Constatacion);

    public Detalle_Constatacion findByIdDetalle_Constatacion(Long id);

    public void eliminarDetalle_Constatacion(Long id);
}

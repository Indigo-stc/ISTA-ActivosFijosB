package ista.activosfijos.api.models.services;


import ista.activosfijos.api.models.entity.primary.Encabezado_Constatacion;

import java.util.List;

public interface IEncabezado_constatacionService {

    public List<Encabezado_Constatacion> findAllEncabezado_Constatacion();

    public Encabezado_Constatacion guardarEncabezado_Constatacion(Encabezado_Constatacion encabezado_constatacion);

    public Encabezado_Constatacion findByIdEncabezado_Constatacion(Long id);

    public void eliminarEncabezado_Constatacion(Long id);

}

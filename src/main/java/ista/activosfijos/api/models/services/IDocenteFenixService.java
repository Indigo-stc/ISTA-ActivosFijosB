package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.entity.secundary.verpersonaf;

import java.util.List;

public interface IDocenteFenixService {
    public List<verpersonaf> findAll();

    public verpersonaf findById(String cedula);

}

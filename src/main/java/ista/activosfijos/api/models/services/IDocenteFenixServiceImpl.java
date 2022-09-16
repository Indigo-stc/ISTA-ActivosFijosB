package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.dao.secundary.VerpersonafDao;
import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDocenteFenixServiceImpl implements IDocenteFenixService{

    @Autowired
    private VerpersonafDao verpersonafDao;

    @Override
    @Transactional(readOnly= true)
    public List<verpersonaf> findAll() {
        // TODO Auto-generated method stub
        return (List<verpersonaf>) verpersonafDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public verpersonaf findById(String id) {
        // TODO Auto-generated method stub
        return verpersonafDao.findById(id).orElse(null);
    }
}

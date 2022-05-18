package edu.elp.siselp.service.impl;

import edu.elp.siselp.dao.IRolDao;
import edu.elp.siselp.entity.Rol;
import edu.elp.siselp.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    protected IRolDao roleDao;

    @Override
    public Rol save(Rol rol) {
        return this.roleDao.save(rol);
    }

    @Override
    public Iterable<Rol> findAll() {
        return this.roleDao.findAll();
    }

    @Override
    public void deleteRol(Long id) {
        this.roleDao.deleteById(id);
    }
}

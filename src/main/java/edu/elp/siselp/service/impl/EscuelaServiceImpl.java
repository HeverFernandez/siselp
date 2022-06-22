package edu.elp.siselp.service.impl;

import edu.elp.siselp.dao.IEscuelaDao;
import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.service.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuelaServiceImpl implements IEscuelaService {

    @Autowired
    private IEscuelaDao escuelaDao;

    @Override
    public List<Escuela> listaEscuelas() {
        return this.escuelaDao.findAll();
    }

    @Override
    public Escuela registrarEscuela(Escuela escuela) {
        return this.escuelaDao.save(escuela);
    }
}

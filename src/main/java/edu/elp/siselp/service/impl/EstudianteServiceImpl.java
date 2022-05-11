package edu.elp.siselp.service.impl;

import edu.elp.siselp.dao.IEstudianteDao;
import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import edu.elp.siselp.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteDao estudianteDao;

    @Override
    public List<Estudiante> listaEstudiantesByEscuela(Escuela idescuela) {
        return this.estudianteDao.findByEscuela(idescuela);
    }

    @Override
    public Page<Estudiante> listaEstudiantesPorPagina(Pageable pageable, Escuela idescuela) {
        return this.estudianteDao.listEstudianteByPagina(pageable,idescuela);
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return this.estudianteDao.save(estudiante);
    }

    @Override
    public Estudiante obtenerPorCodigoOrDni(String coddni) {
        return this.estudianteDao.obtenerPorCodigoOrDni(coddni);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        this.estudianteDao.deleteById(id);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        this.estudianteDao.save(estudiante);
    }
}

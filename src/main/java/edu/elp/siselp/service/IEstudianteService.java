package edu.elp.siselp.service;

import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEstudianteService {

    //Devuelve una lista de estudiantes por escuela
    List<Estudiante> listaEstudiantesByEscuela(Escuela idescuela);

    //Devuelve una lista de estudiantes por escuela y de manera paginada.
    Page<Estudiante> listaEstudiantesPorPagina(Pageable pageable, Escuela idescuela);

    //Registra un estudiante en la base de datos
    Estudiante guardarEstudiante(Estudiante estudiante);

    //Obtener estudiante por código o por dni
    Estudiante obtenerPorCodigoOrDni(String coddni);

    //Elimina un registro de estudiante
    void eliminarEstudiante(Long id);

    //Actualiza un registro de estudiante
    void actualizarEstudiante(Estudiante estudiante);
}

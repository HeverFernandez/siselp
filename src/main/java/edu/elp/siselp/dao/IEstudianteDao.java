package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteDao extends JpaRepository<Estudiante, Long> {

    //Lista de estudiantes por escuela
    List<Estudiante> findByEscuela(Escuela idescuela);

    //Lista de estudiantes por escuela y por página
    @Query("SELECT e FROM Estudiante e WHERE e.escuela = :idescuela")
    Page<Estudiante> listEstudianteByPagina(Pageable pageable, @Param("idescuela") Escuela idescuela);

    //Obtener un estudiante por dni o código
    @Query("SELECT e FROM Estudiante e WHERE e.codigo = :coddni OR e.dni = :coddni")
    Estudiante obtenerPorCodigoOrDni(@Param("coddni") String coddni);
}

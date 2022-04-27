package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteDao extends JpaRepository<Docente, Long> {

}

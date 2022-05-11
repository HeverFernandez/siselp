package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEscuelaDao extends JpaRepository<Escuela, Long> {
}

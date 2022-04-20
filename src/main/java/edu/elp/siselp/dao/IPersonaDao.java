package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona,Long> {



}

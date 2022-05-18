package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRolDao extends CrudRepository<Rol, Long> {

    @Query("SELECT r FROM Rol r WHERE r.idrol = :idrol")
    Rol findByIdrol(@Param("idrol") Long idrol);
}

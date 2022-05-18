package edu.elp.siselp.dao;

import edu.elp.siselp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    Usuario findPersonaByUsername(@Param("username") String username);

    Boolean existsByUsername(String username);
}

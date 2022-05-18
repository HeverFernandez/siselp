package edu.elp.siselp.service;

import edu.elp.siselp.entity.Rol;

public interface IRolService {
    /**
     * Guarda un Rol
     *
     * @param rol
     * @return el rol guardado
     */
    Rol save(Rol rol);

    /**
     * Recupera la lista de roles
     *
     * @return lista de roles
     */
    Iterable<Rol> findAll();

    /**
     * Elimina un rol con el id recibido
     *
     * @param id
     */
    void deleteRol(Long id);
}

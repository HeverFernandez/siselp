package edu.elp.siselp.service;

import edu.elp.siselp.entity.Usuario;

public interface IUserService {

    Usuario getPersonaByUsuario(String username);
}

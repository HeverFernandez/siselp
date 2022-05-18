package edu.elp.siselp.service.impl;

import edu.elp.siselp.dao.IUsuarioDao;
import edu.elp.siselp.entity.Usuario;
import edu.elp.siselp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario getPersonaByUsuario(String username) {
        return this.usuarioDao.findPersonaByUsername(username);
    }
}

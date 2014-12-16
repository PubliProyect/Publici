package com.vimso.padyu.bussines.dao.interfaces;

import com.vimso.padyu.bussines.comun.IComunUsuarios;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IDAOUsuario extends IComunUsuarios{

    List<Usuario> buscarUsuarios(List<String> usuarios);
    
    Usuario buscarUsuarioPorMail(String mail);
    
    void crearUsuario(Usuario usuario);

}

package com.vimso.padyu.bussines.comun;

import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import java.util.List;


/**
 *
 * @author vimso
 */
public interface IComunUsuarios {

    void modificarUsuario(Usuario usuario);

    Usuario buscarUsuario(String nombre);
    
    List<Usuario> buscarUsuario(String nombre,String mail);

    void eliminarUsuario(Long idUsuario);

}

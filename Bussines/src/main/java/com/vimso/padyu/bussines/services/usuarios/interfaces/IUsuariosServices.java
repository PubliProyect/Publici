package com.vimso.padyu.bussines.services.usuarios.interfaces;

import com.vimso.padyu.api.to.gestionusuarios.in.LoginUsuariosTOIn;
import com.vimso.padyu.api.to.gestionusuarios.out.LoginUsuariosTOOut;
import com.vimso.padyu.bussines.comun.IComunUsuarios;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IUsuariosServices extends IComunUsuarios{

    public List<Usuario> buscarUsuarios(List<String> usuarios);

    void crearUsuario(Usuario usuario);

    LoginUsuariosTOOut loginUsuario(LoginUsuariosTOIn loginUsuariosTOIn);
    
}

package com.vimso.padyu.bussines.services.usuarios.validadores.interfaces;

import com.vimso.padyu.dominio.gestion.usuarios.Usuario;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;

/**
 *
 * @author vimso
 */
public interface IValidardorUsuarioServices {

    public RespuestaComponentes vCrearUsuario(Usuario usuario);

}

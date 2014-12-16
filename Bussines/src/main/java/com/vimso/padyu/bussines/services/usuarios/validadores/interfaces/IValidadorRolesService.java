package com.vimso.padyu.bussines.services.usuarios.validadores.interfaces;

import com.vimso.padyu.dominio.gestion.usuarios.Rol;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IValidadorRolesService {

    public RespuestaComponentes vCrearRol(Rol rol);

    public RespuestaComponentes vagregarUsuariosARol(String rol, List<String> usuarios);

}

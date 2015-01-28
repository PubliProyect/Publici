package com.vimso.padyu.bussines.services.usuarios.validadores.interfaces;

import com.vimso.padyu.dominio.gestion.usuarios.Permiso;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;

/**
 *
 * @author vimso
 */
public interface IValidadorPermisosService {

    public RespuestaComponentes vCrearPermiso(Permiso permiso);

}

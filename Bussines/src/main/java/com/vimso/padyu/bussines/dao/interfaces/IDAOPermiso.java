package com.vimso.padyu.bussines.dao.interfaces;

import com.vimso.padyu.bussines.comun.IComunPermisos;
import com.vimso.padyu.dominio.GestionUsuarios.Permiso;

/**
 *
 * @author vimso
 */
public interface IDAOPermiso extends IComunPermisos{

    public void crearPermiso(Permiso permiso);

    public Permiso buscarPermiso(String nombre);

}

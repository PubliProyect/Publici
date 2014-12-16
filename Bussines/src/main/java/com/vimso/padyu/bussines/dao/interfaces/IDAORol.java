package com.vimso.padyu.bussines.dao.interfaces;

import com.vimso.padyu.bussines.comun.IComunRoles;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IDAORol extends IComunRoles{

    List<Rol> getAllRoles();

    List<Rol> getAllRolesActivos();

    public Rol buscarRolPorNombre(String nombre);


    

}

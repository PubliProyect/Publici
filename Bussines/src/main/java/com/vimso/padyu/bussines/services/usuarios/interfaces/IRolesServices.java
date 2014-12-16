package com.vimso.padyu.bussines.services.usuarios.interfaces;

import com.vimso.padyu.bussines.comun.IComunRoles;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IRolesServices extends IComunRoles{

    public Rol buscarRol(String nombre);

    public void agregarUsuariosARol(String rol, List<String> usuarios);

}

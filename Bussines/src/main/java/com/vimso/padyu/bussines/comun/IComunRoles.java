package com.vimso.padyu.bussines.comun;

import com.vimso.padyu.dominio.gestion.usuarios.Rol;



/**
 *
 * @author vimso
 */
public interface IComunRoles {

    void crearRol(Rol rol);

    void eliminarRol(Long idRol);

    void modificarRol(Rol rol);
    
    void guardarRol(Rol rol);

}

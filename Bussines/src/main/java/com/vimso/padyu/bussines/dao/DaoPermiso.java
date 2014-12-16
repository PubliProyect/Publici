package com.vimso.padyu.bussines.dao;

import com.vimso.padyu.bussines.dao.interfaces.IDAOPermiso;
import com.vimso.padyu.bussines.dao.repositorios.IPermisoRepository;
import com.vimso.padyu.dominio.GestionUsuarios.Permiso;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vimso
 */
@Named
public class DaoPermiso implements IDAOPermiso{

    @Inject
    private IPermisoRepository permisoRepository;
    
    @Override
    public void crearPermiso(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public Permiso buscarPermiso(String nombre) {
        return permisoRepository.buscarPermiso(nombre);
    }

}

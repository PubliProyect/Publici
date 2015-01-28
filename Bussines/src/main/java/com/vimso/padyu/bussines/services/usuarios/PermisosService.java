package com.vimso.padyu.bussines.services.usuarios;

import com.vimso.padyu.bussines.dao.interfaces.IDAOPermiso;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IPermisosService;
import com.vimso.padyu.bussines.services.usuarios.validadores.ValidadorPermisosServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidadorPermisosService;
import com.vimso.padyu.dominio.gestion.usuarios.Permiso;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vimso
 */
@Named
public class PermisosService  implements  IPermisosService{

    @Inject
    private IDAOPermiso daoPermiso;
    
    private IValidadorPermisosService validador;
    
    @PostConstruct
    public void postContructor() {
        validador= new ValidadorPermisosServices(this);
    }
    @Override
    public void crearPermiso(Permiso permiso) {
        
        RespuestaComponentes res=validador.vCrearPermiso(permiso);
        if (!res.isOK()) {
            throw new ValidacionExcepcion(res);
        }
        daoPermiso.crearPermiso(permiso);
    }

    @Override
    public Permiso buscarPermiso(String nombre) {
        return daoPermiso.buscarPermiso(nombre);
    }
    
}

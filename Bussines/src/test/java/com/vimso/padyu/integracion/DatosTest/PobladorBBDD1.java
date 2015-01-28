package com.vimso.padyu.integracion.DatosTest;

import com.vimso.padyu.bussines.services.usuarios.interfaces.IPermisosService;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IRolesServices;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vimso
 */
@Named
public class PobladorBBDD1 implements IPobladorBBDD1{

    @Inject
    private IUsuariosServices  usuariosService;
    
    @Inject
    private IRolesServices  rolService;
    
    @Inject    
    private IPermisosService  permisosService;
    
    @Override
    public void pobladorBBDD() {
            
            cargarUsuarios();            
            cargarRoles();
            cargarPermisos();
    }

    private void cargarUsuarios() {
        usuariosService.crearUsuario(DatosTest1.getUsuario1());
        usuariosService.crearUsuario(DatosTest1.getUsuario2());
        usuariosService.crearUsuario(DatosTest1.getUsuario3());
        usuariosService.crearUsuario(DatosTest1.getUsuario4());
//        usuariosService.crearUsuario(DatosTest1.getUsuario5());
    }

    private void cargarRoles() {
        rolService.crearRol(DatosTest1.getRol1());
        rolService.crearRol(DatosTest1.getRol2());
        rolService.crearRol(DatosTest1.getRol3());
        rolService.crearRol(DatosTest1.getRol4());
        rolService.crearRol(DatosTest1.getRol5());
        rolService.crearRol(DatosTest1.getRol6());
        rolService.crearRol(DatosTest1.getRol7());
//        rolService.crearRol(DatosTest1.getRol8());
    }

    private void cargarPermisos() {
        permisosService.crearPermiso(DatosTest1.getPermiso1());
        permisosService.crearPermiso(DatosTest1.getPermiso2());
        permisosService.crearPermiso(DatosTest1.getPermiso3());
        permisosService.crearPermiso(DatosTest1.getPermiso4());
        permisosService.crearPermiso(DatosTest1.getPermiso5());
//        permisosService.crearPermiso(DatosTest1.getPermiso6());
    }

}

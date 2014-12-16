package com.vimso.padyu.bussines.services.usuarios.validadores;

import com.vimso.padyu.bussines.services.usuarios.interfaces.IRolesServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidadorRolesService;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import java.util.List;

/**
 *
 * @author vimso
 */
public class ValidadorRolesServices implements IValidadorRolesService {

    private IRolesServices rolServices;

    public ValidadorRolesServices(IRolesServices rolServices) {
        this.rolServices = rolServices;
    }

    @Override
    public RespuestaComponentes vCrearRol(Rol rol) {
        if (rol == null) {
            throw new ValidacionExcepcion(Mensaje.VALOR_VACIO);
        }
        RespuestaComponentes respuesta = new RespuestaComponentes();
        
        //        //<editor-fold defaultstate="collapsed" desc="Validaciones de longitud">
//      El nombre del rol debe de tener al menos una longitud de 5 caracteres
        if (rol.getNombre().length() < 5) {
            respuesta.addMensajeKO(Mensaje.ROL_NOMBRE_CORTO);
        }
//        //</editor-fold>
        
        //        //<editor-fold defaultstate="collapsed" desc="Validaciones de integridad">
//       Existe algún otro rol en el sistema con ese nombre 

        Rol rolNombre = rolServices.buscarRol(rol.getNombre());

        if (rolNombre != null) {
            //Existen roles con ese nombre ¿?
            respuesta.addMensajeKO(Mensaje.ROL_YA_EXISTENTE);

        }
////</editor-fold>
        return respuesta;
    }

    @Override
    public RespuestaComponentes vagregarUsuariosARol(String rol, List<String> usuarios) {
        
        RespuestaComponentes respuesta = new RespuestaComponentes();
        
        if (rol == null) {
            throw new ValidacionExcepcion(Mensaje.ROL_INCORRECTO);
        }
        if (usuarios == null) {
            throw new ValidacionExcepcion(Mensaje.USUARIOS_INCORRECTO);
        }
        
        return respuesta;
    }

}

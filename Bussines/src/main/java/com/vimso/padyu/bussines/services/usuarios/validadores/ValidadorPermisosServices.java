package com.vimso.padyu.bussines.services.usuarios.validadores;

import com.vimso.padyu.bussines.services.usuarios.interfaces.IPermisosService;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidadorPermisosService;
import com.vimso.padyu.dominio.gestion.usuarios.Permiso;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.parametros.ParametrosDefecto;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;

/**
 *
 * @author vimso
 */
public class ValidadorPermisosServices implements IValidadorPermisosService{
    
    private final IPermisosService permisoService;

    public ValidadorPermisosServices(IPermisosService permisoService) {
        this.permisoService=permisoService;
    }

    @Override
    public RespuestaComponentes vCrearPermiso(Permiso permiso) {
        
        if (permiso == null) {
            throw new ValidacionExcepcion(Mensaje.VALOR_VACIO);
        }
        RespuestaComponentes respuesta = new RespuestaComponentes();

        //        //<editor-fold defaultstate="collapsed" desc="Validaciones de longitud">
        if (permiso.getNombre().length() < ParametrosDefecto.LONGITUD_MINIMA_NOMBRE_PERMISO) {
            respuesta.addMensajeKO(Mensaje.PERMISO_NOMBRE_CORTO);
        }
//        //</editor-fold>

        //        //<editor-fold defaultstate="collapsed" desc="Validaciones de integridad">
//       Existe algún otro permiso en el sistema con ese nombre 
        Permiso permisoPorNombre = permisoService.buscarPermiso(permiso.getNombre());

        if (permisoPorNombre != null) {
            //Existen permiso con ese nombre ¿?
            respuesta.addMensajeKO(Mensaje.PERMISO_YA_EXISTENTE);
        }
////</editor-fold>
        return respuesta;
    }

}

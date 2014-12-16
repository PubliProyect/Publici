package com.vimso.padyu.bussines.services.usuarios.validadores;

import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidardorUsuarioServices;
import com.vimso.padyu.dominio.gestion.usuarios.Usuario;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.parametros.ParametrosDefecto;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author vimso
 */
public class ValidadorUsuarioService implements IValidardorUsuarioServices {

    private final IUsuariosServices usuarioServices;

    public ValidadorUsuarioService(IUsuariosServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @Override
    public RespuestaComponentes vCrearUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new ValidacionExcepcion(Mensaje.VALOR_VACIO);
        }

        RespuestaComponentes respuesta = new RespuestaComponentes();
        
        List<Mensaje> mensajesKO =validarFormatosYLongitudesCrearUsuarios(usuario);
        
        if (mensajesKO!=null && !mensajesKO.isEmpty()) {
            respuesta.setOK(false);
            respuesta.setMensajes(mensajesKO);
        }
        
        //<editor-fold defaultstate="collapsed" desc="Validaciones de integridad">
        
        List<Usuario> usuariosSegunCriterio= usuarioServices.buscarUsuario(usuario.getNombre(),usuario.getMail());
        
        if (!usuariosSegunCriterio.isEmpty()) {
            //Hay usuarios con ese nombre ¿?
            if (!usuariosSegunCriterio.stream().filter(s -> s.getNombre().equals(usuario.getNombre())).collect(Collectors.toList()).isEmpty()) {
                respuesta.addMensajeKO(Mensaje.NOMBRE_EN_USO);
            }
            //Hay usuarios con ese mail
            if (!usuariosSegunCriterio.stream().filter(s -> s.getMail().equals(usuario.getMail())).collect(Collectors.toList()).isEmpty()) {
                respuesta.addMensajeKO(Mensaje.MAIL_EN_USO);
            }  

        }
        
//</editor-fold>

        //Datos mínimos completos y con longitud
        //No puede existir un usuario con ese nombre o mail
        return respuesta;
    }

    private List<Mensaje> validarFormatosYLongitudesCrearUsuarios(Usuario usuario) {
        List<Mensaje> respuesta= new ArrayList<>();
        //El mail es correcto ¿?
        if (!EmailValidator.getInstance().isValid(usuario.getMail())) {
            respuesta.add(new Mensaje(Mensaje.MAIL_MAL_FORMATO));
        }

        //El nombre tiene una longitud mínima
        if (usuario.getNombre() == null || usuario.getNombre().length() < ParametrosDefecto.NOMBRE_CARACTERES_MINIMOS) {
            respuesta.add(new Mensaje(Mensaje.NOMBRE_CARACTERES_MINIMOS,Arrays.asList(ParametrosDefecto.NOMBRE_CARACTERES_MINIMOS.toString())));
        }

        //La password tiene una longitud mínima
        if (usuario.getPassword() == null || usuario.getPassword().length() < ParametrosDefecto.NOMBRE_CARACTERES_MINIMOS) {
            respuesta.add(new Mensaje(Mensaje.PASSWORD_CARACTERES_MINIMOS,Arrays.asList(ParametrosDefecto.PASSWORD_CARACTERES_MINIMOS.toString())));
        }
        return respuesta;
    }
}

package com.vimso.padyu.api.to.gestionusuarios.out;

import com.google.common.base.Objects;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;

/**
 *
 * @author vimso
 */
public class LoginUsuariosTOOut {
    

    private RespuestaComponentes respuesta;

    public LoginUsuariosTOOut(RespuestaComponentes respuesta) {
        this.respuesta = respuesta;
    }

    public LoginUsuariosTOOut() {
    }

    public RespuestaComponentes getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaComponentes respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        
          if (o==null) {
            return false;
        }
        
        if (!(o instanceof  LoginUsuariosTOOut)) {
            return false;
        }
        
        LoginUsuariosTOOut externo=(LoginUsuariosTOOut)o;
        
        return isRespuestasIguales(externo.getRespuesta());
    }
    
    private boolean isRespuestasIguales(RespuestaComponentes respuesta) {
        if (respuesta==null && respuesta==null ) {
            return true;
        }        
        return getRespuesta().equals(respuesta); 
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRespuesta());
    }

}

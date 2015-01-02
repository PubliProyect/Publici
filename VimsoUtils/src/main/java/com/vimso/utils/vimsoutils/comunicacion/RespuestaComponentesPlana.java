package com.vimso.utils.vimsoutils.comunicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vimso
 */
public class RespuestaComponentesPlana implements Serializable{

    public RespuestaComponentesPlana() {
        ok=true;
        mensajes= new ArrayList<>();
    }
    
    
    private Boolean ok;
    private List<String> mensajes;

    public Boolean isOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}

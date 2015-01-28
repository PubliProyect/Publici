package com.vimso.utils.vimsoutils.respuesta;

import com.google.common.base.Objects;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import java.io.Serializable;

/**
 *
 * @author vimso
 */
public class ValidacionExcepcion extends IllegalArgumentException implements Serializable{

    private RespuestaComponentes respuestaComponentes;
    /**
     * Creates a new instance of <code>VimsoValidacionExcepcion</code> without
     * detail message.
     */
    public ValidacionExcepcion() {
    }

    /**
     * Constructs an instance of <code>VimsoValidacionExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValidacionExcepcion(String msg) {
        super(msg);
        respuestaComponentes= new RespuestaComponentes(msg);
    }
    
    public ValidacionExcepcion(Mensaje msg) {
        respuestaComponentes= new RespuestaComponentes(msg);
    }

    
    
    public ValidacionExcepcion(RespuestaComponentes respuestaComponentes) {
        this.respuestaComponentes = respuestaComponentes;
    }

    public RespuestaComponentes getRespuestaComponentes() {
        return respuestaComponentes;
    }

    public void setRespuestaComponentes(RespuestaComponentes respuestaComponentes) {
        this.respuestaComponentes = respuestaComponentes;
    }

    @Override
    public boolean equals(Object o) {
        
        if (o==null) {
            return false;
        }
        
        if (!(o instanceof ValidacionExcepcion)) {
            return false;
        }
        
        return respuestaComponentes.equals(((ValidacionExcepcion)o).getRespuestaComponentes());
        
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(respuestaComponentes);
    }
}

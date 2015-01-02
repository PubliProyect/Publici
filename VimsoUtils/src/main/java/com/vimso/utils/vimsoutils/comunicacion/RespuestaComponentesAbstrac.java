package com.vimso.utils.vimsoutils.comunicacion;

import com.vimso.utils.vimsoutils.respuesta.IRespuesta;

/**
 *
 * @author vimso
 */
public abstract class RespuestaComponentesAbstrac implements IRespuesta{

    public boolean isMultiple()
    {
        return this.getMensajes() != null && this.getMensajes().size() <= 1;
    }

    
}

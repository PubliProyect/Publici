package com.vimso.utils.vimsoutils.respuesta;

import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vimso
 */
public interface IRespuesta extends Serializable {
    
    boolean isOK();
    
    boolean isMultiple();
    
    List<Mensaje> getMensajes();

}

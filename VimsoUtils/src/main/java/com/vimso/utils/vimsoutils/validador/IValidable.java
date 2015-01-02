package com.vimso.utils.vimsoutils.validador;

import com.vimso.utils.vimsoutils.respuesta.IRespuesta;

/**
 *
 * @author vimso
 */
public interface IValidable<T> {

    IRespuesta valida(T entidad);
}

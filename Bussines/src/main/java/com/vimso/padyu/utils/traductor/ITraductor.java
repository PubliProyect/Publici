package com.vimso.padyu.utils.traductor;

import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentesPlana;
import java.util.Locale;

/**
 *
 * @author vimso
 */
public interface ITraductor {

    RespuestaComponentesPlana traducirRespuesCompleja(RespuestaComponentes respuestaComponentes, Locale locale);

    String getTraduccion(String code, Object[] args, Locale locale);

}

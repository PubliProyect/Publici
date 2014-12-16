package com.vimso.padyu.utils.traductor;

import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentesPlana;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import org.springframework.context.MessageSource;

/**
 *
 * @author vimso
 */
@Named
public class Traductor implements ITraductor{
    
    private static final Logger log = Logger.getLogger( Traductor.class.getName() );

    @Resource(name = "messageSource")
    private MessageSource messageSource;

    @Override
    public RespuestaComponentesPlana traducirRespuesCompleja(RespuestaComponentes respuestaComponentes, final Locale locale) {
        RespuestaComponentesPlana respuesta = new RespuestaComponentesPlana();
        List<String> mensajes = new ArrayList<>();
        respuesta.setOk(respuestaComponentes.isOK());

        respuestaComponentes.getMensajes().forEach(
                men -> {
                    try {
                        if (men.getParametros() != null) {
                            mensajes.add(
                                    getTraduccion(men.getClaveMensaje(), men.getParametros().toArray(), locale)
                            );
                        } else {
                            mensajes.add(
                                    getTraduccion(men.getClaveMensaje(), null, locale)
                            );
                        }

                    } catch (Exception e) {
                        if (men.getClaveMensaje() != null) {
                            log.log(Level.SEVERE, "No se puede encontrar la traducicón para el parámetro: {0}", men.getClaveMensaje());
                        } else {
                            log.log(Level.SEVERE, "No se puede agrear un Item de: {0} algo ha fallado al construir la respuesta", RespuestaComponentesPlana.class.getName());
                        }
                    }
                });
        respuesta.setMensajes(mensajes);
        return respuesta;
    }
    
    @Override
    public String getTraduccion(String claveMensaje, Object[] parametros, Locale locale)
    {
        return messageSource.getMessage(claveMensaje,parametros, locale);
    }
    
}

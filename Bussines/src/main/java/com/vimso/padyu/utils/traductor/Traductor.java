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
    
    private static final Logger LOGGER = Logger.getLogger( Traductor.class.getName() );

    @Resource(name = "messageSource")
    private MessageSource messageSource;

    @Override
    public RespuestaComponentesPlana traducirRespuesCompleja(RespuestaComponentes respuestaComponentes, final Locale locale) {
        RespuestaComponentesPlana respuesta = new RespuestaComponentesPlana();
        List<String> mensajes = new ArrayList<>();
        respuesta.setOk(respuestaComponentes.isOK());

        for (Mensaje men : respuestaComponentes.getMensajes()) {
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
                        LOGGER.log(Level.SEVERE, "Se ha producido un error al intentar realizar una traducción",e);
                        String messageLog;
                        if (men.getClaveMensaje() != null) {
                            messageLog=String.format("No se puede encontrar la traducicón para el parámetro: {0}", men.getClaveMensaje());
                        } else {
                            messageLog=String.format("No se puede agrear un Item de: {0} algo inesperado ha fallado al construir la respuesta", RespuestaComponentesPlana.class.getName());
                        }
                         LOGGER.log(Level.SEVERE, messageLog);
                    }
        }
        respuesta.setMensajes(mensajes);
        return respuesta;
    }
    
    @Override
    public String getTraduccion(String claveMensaje, Object[] parametros, Locale locale){
        return messageSource.getMessage(claveMensaje,parametros, locale);
    }
    
}

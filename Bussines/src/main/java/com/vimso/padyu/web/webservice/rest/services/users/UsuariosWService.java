package com.vimso.padyu.web.webservice.rest.services.users;

import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.mapping.MappingServicesNames;
import static com.vimso.padyu.mapping.MappingServicesNames.USER;
import com.vimso.padyu.utils.traductor.ITraductor;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentesPlana;
import com.vimso.utils.vimsoutils.dto.VOut;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vimso
 */
@RestController
@RequestMapping("/"+USER)
public class UsuariosWService implements IUsuariosWService {

    private static final Logger LOGGER = Logger.getLogger(UsuariosWService.class.getName());
    
    @Inject
    private ITraductor traductorService;
    
    @Inject
    private IUsuariosServices usuarioService;

    @RequestMapping(value=MappingServicesNames.CREATE_USER,method = RequestMethod.POST)
    public VOut crearUsuario(@RequestBody RegistroUsuarioTOIn usuarioaRegistrar) {
        
        RespuestaComponentesPlana respuesta = new RespuestaComponentesPlana();
        
        try {
            if (usuarioaRegistrar==null) {
                //Debería devovler un code http de bad request y especificar que falta los datos especificados en la API
            }
            usuarioService.crearUsuario(usuarioaRegistrar.transformToUsuario());
            return new VOut(respuesta);
        } catch (ValidacionExcepcion e) {
            LOGGER.log(Level.INFO, "Ha saltado un error de validación", e);
            respuesta=traductorService.traducirRespuesCompleja(e.getRespuestaComponentes(),usuarioaRegistrar.getLocale());
            return new VOut(respuesta);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ha saltado un error de validación", e);
            respuesta.setOk(Boolean.FALSE);
            return new VOut(respuesta);
        }
    }
}

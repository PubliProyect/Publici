package com.vimso.padyu.web.webservice.rest.services.users;

import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.mapping.IMappingServicesNames;
import static com.vimso.padyu.mapping.IMappingServicesNames.USER;
import com.vimso.padyu.utils.traductor.ITraductor;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentesPlana;
import com.vimso.utils.vimsoutils.dto.VOut;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UsuariosWService.class);
    
    @Inject
    private ITraductor traductorService;
    
    @Inject
    private IUsuariosServices usuarioService;

//    @RequestMapping(value = "/login",method = RequestMethod.PUT)
//    public LoginUsuariosTOOut logearUsuario(LoginUsuariosTOIn parame) {
//        return  usuarioService.loginUsuario(parame);
//    }
//    @RequestMapping(value = "/newusuer",method = RequestMethod.PUT)
//    public RespuestaComponentesPlana logearUsuario(RegistroUsuarioTOIn parame) {
////        return  Service.traducirRespuesCompleja(usuarioService.registrarUsuario(parame).getRespuesta());
//           throw new UnsupportedOperationException();
//    }
    
//    @RequestMapping(value = "/ejemplosJson")    
//    RegistroUsuarioTOIn logearUsuario() {
//        RegistroUsuarioTOIn respuesta = new RegistroUsuarioTOIn();
//        
//        respuesta.setMail("EmailX@gmail.com");
//        respuesta.setPassword("password");
//        respuesta.setNombre("Nombre de prueba");
//        
//        return respuesta;
//    }
    
//    /**
//     * @param id
//     * @return Returns the person with the given id.
//     */
//    @RequestMapping(value="person/{id}",method = RequestMethod.POST)
//    public Integer getPersonById(@PathVariable Integer id) {
//        System.out.println("VIMSO Pasando por el controlador");
//        return id + 1;
//    }
    @RequestMapping(value=IMappingServicesNames.CREATE_USER,method = RequestMethod.POST)
    public VOut crearUsuario(@RequestBody RegistroUsuarioTOIn usuarioaRegistrar) {
        
        RespuestaComponentesPlana respuesta = new RespuestaComponentesPlana();
        
        try {
            if (usuarioaRegistrar==null) {
                //Debería devovler un code http de bad request y especificar que falta los datos especificados en la API
            }
            usuarioService.crearUsuario(usuarioaRegistrar.transformToUsuario());
            return new VOut(respuesta);
        } catch (ValidacionExcepcion e) {
            //Transformo la validacion en una respuesta de error
            respuesta=traductorService.traducirRespuesCompleja(e.getRespuestaComponentes(),usuarioaRegistrar.getLocale());
            return new VOut(respuesta);

        } catch (Exception e) {
            //Se produce un error no experado
            logger.error("Se ha producido un error inexperado al crear un usuario");
            respuesta.setOk(Boolean.FALSE);
            return new VOut(respuesta);
        }
    }
}

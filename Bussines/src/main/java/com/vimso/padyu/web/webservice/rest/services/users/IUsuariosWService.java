package com.vimso.padyu.web.webservice.rest.services.users;

import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import com.vimso.utils.vimsoutils.dto.VOut;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author vimso
 */
public interface IUsuariosWService {

    VOut crearUsuario(@RequestBody RegistroUsuarioTOIn usuarioaRegistrar);

}

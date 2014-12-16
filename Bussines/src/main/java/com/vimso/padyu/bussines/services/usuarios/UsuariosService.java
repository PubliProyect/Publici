package com.vimso.padyu.bussines.services.usuarios;

import com.vimso.padyu.api.to.gestionusuarios.in.LoginUsuariosTOIn;
import com.vimso.padyu.api.to.gestionusuarios.out.LoginUsuariosTOOut;
import com.vimso.padyu.bussines.dao.interfaces.IDAOUsuario;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.ValidadorUsuarioService;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidardorUsuarioServices;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.springframework.util.DigestUtils;

/**
 *
 * @author vimso
 */
@Transactional
@Named
public class UsuariosService implements IUsuariosServices {

    
    private final IDAOUsuario daoUsuario;
        
    private IValidardorUsuarioServices validador;

    
    @Inject
    public UsuariosService(IDAOUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
        
    }    
    
    @PostConstruct
    public void postContructor()
    {
        validador = new ValidadorUsuarioService(this);
    }
    
    
    @Override
    public void crearUsuario(Usuario usuario) {
        RespuestaComponentes res=validador.vCrearUsuario(usuario);
        if (!res.isOK()) {
            throw new ValidacionExcepcion(res);
        }
        usuario.setPassword(DigestUtils.md5DigestAsHex(usuario.getPassword().getBytes()));
        daoUsuario.crearUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuario(String nombre) {
        
        if (nombre==null || nombre.isEmpty()) {
            throw new ValidacionExcepcion(new RespuestaComponentes(Mensaje.VALOR_VACIO));
        }
        return daoUsuario.buscarUsuario(nombre);
    }
    
    private Usuario buscarUsuarioPorMail(String mail) {
        
        if (mail==null || mail.isEmpty()) {
            throw new ValidacionExcepcion(new RespuestaComponentes(Mensaje.VALOR_VACIO));
        }
        return daoUsuario.buscarUsuarioPorMail(mail);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        daoUsuario.eliminarUsuario(idUsuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
//        daoUsuario.modificarUsuario(usuario);
    }

    @Override
    public List<Usuario> buscarUsuario(String nombre, String mail) {
        return daoUsuario.buscarUsuario(nombre, mail);
    }

    @Override
    public List<Usuario> buscarUsuarios(List<String> usuarios) {
        return daoUsuario.buscarUsuarios(usuarios);
    }
    
    @Override
    public LoginUsuariosTOOut loginUsuario(LoginUsuariosTOIn loginUsuariosTOIn)
    {
        //valido que no venga vacio el parametros y tampoco sus propiedades
        
        if (loginUsuariosTOIn==null || loginUsuariosTOIn.getMail()==null || loginUsuariosTOIn.getPassword()==null) {
            throw new ValidacionExcepcion(new RespuestaComponentes(Mensaje.VALOR_VACIO));
        }
        
        if (autentificarUsuarios(loginUsuariosTOIn.getMail(),loginUsuariosTOIn.getPassword())) {
            return new LoginUsuariosTOOut(new RespuestaComponentes(Mensaje.CREDENCIALES_CORRECTAS));
        } else {
            return new LoginUsuariosTOOut(new RespuestaComponentes(Mensaje.CREDENCIALES_ERRONEAS));
        }
    }

    private boolean autentificarUsuarios(String mail, String password) {
        Usuario usuarioAutentificar=buscarUsuarioPorMail(mail);
        
        String passwordCifrada=DigestUtils.md5DigestAsHex(password.getBytes());
        return usuarioAutentificar != null && usuarioAutentificar.getPassword() != null && usuarioAutentificar.getPassword().equals(passwordCifrada);
    }
}

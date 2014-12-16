package com.vimso.padyu.bussines.services.usuarios;

import com.vimso.padyu.bussines.dao.interfaces.IDAORol;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IRolesServices;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.ValidadorRolesServices;
import com.vimso.padyu.bussines.services.usuarios.validadores.interfaces.IValidadorRolesService;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vimso
 */
@Transactional
@Named
public class RolesService implements IRolesServices{

    @Inject
    private IDAORol daoRoles; 
    
    @Inject
    private IUsuariosServices usuariosService; 
            
    private IValidadorRolesService validador;
    
     @PostConstruct
    public void postContructor() {
        validador = new ValidadorRolesServices(this);
    }

    @Override
    public void crearRol(Rol rol) {
        RespuestaComponentes res=validador.vCrearRol(rol);
        if (!res.isOK()) {
            throw new ValidacionExcepcion(res);
        }
        daoRoles.crearRol(rol);
    }

    @Override
    public void eliminarRol(Long idRol) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void modificarRol(Rol rol) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Rol buscarRol(String nombre) {
        return  daoRoles.buscarRolPorNombre(nombre);
    }

    @Override
    public void agregarUsuariosARol(String rol, List<String> usuarios) {
        //Realizo comprobaciones
        RespuestaComponentes res=validador.vagregarUsuariosARol(rol,usuarios);
        if (!res.isOK()) {
            throw new ValidacionExcepcion(res);
        }
        
        //Obtengo el rol
        Rol rolBuscado=daoRoles.buscarRolPorNombre(rol);
        if (rolBuscado==null) {
            res.addMensajeKO(Mensaje.ROL_NO_ENCONTRADO);
            throw new ValidacionExcepcion(res);
        }
        
        List<Usuario> usuariosEncontrados= usuariosService.buscarUsuarios(usuarios);
        
        if (usuarios==null || usuarios.size()!=usuariosEncontrados.size()) {
            res.addMensajeKO(Mensaje.USUARIOS_INCORRECTOS);
            throw new ValidacionExcepcion(res);
        }

        rolBuscado.getUsuarios().addAll(usuariosEncontrados);
        daoRoles.modificarRol(rolBuscado);
    }

    @Override
    public void guardarRol(Rol rol) {
        daoRoles.guardarRol(rol);
    }

}

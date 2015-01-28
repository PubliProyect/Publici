package com.vimso.padyu.bussines.dao;

import com.vimso.padyu.bussines.dao.interfaces.IDAOUsuario;
import com.vimso.padyu.bussines.dao.repositorios.IUsuarioRepository;
import com.vimso.padyu.dominio.gestion.usuarios.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vimso
 */
@Named
public class DaoUsuario implements IDAOUsuario {

    @Inject
    private IUsuarioRepository usuarioRepository;

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(String nombre) {
        return usuarioRepository.getUsuariosByNombre(nombre);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.delete(idUsuario);
    }

    @Override
    public List<Usuario> buscarUsuario(String nombre, String mail) {
        return usuarioRepository.getUsuariosBynombreOrMail(nombre, mail);
    }

    @Override
    public List<Usuario> buscarUsuarios(List<String> usuarios) {
        return usuarioRepository.buscarUsuarios(usuarios);
    }

    @Override
    public Usuario buscarUsuarioPorMail(String mail) {
        return usuarioRepository.buscarUsuarioPorMail(mail);

    }
}

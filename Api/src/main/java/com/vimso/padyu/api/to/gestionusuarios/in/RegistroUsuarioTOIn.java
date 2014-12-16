package com.vimso.padyu.api.to.gestionusuarios.in;

import com.vimso.padyu.dominio.gestion.usuarios.Usuario;
import com.vimso.utils.vimsoutils.dto.VIn;
import java.io.Serializable;

/**
 *
 * @author vimso
 */
public class RegistroUsuarioTOIn extends VIn implements Serializable{
    
    private String nombre;
    private String mail;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario transformToUsuario() {
        Usuario usuarioCreado = new Usuario();
        usuarioCreado.setMail(getMail());
        usuarioCreado.setNombre(getNombre());
        usuarioCreado.setPassword(getPassword());
        return usuarioCreado;
    }

}

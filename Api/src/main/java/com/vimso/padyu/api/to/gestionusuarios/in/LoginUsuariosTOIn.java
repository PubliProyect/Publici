package com.vimso.padyu.api.to.gestionusuarios.in;

import java.io.Serializable;

/**
 *
 * @author vimso
 */
public class LoginUsuariosTOIn implements Serializable{
    
    private String mail;
    private String password;

    public LoginUsuariosTOIn(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public LoginUsuariosTOIn() {
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
    
}

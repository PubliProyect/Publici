package com.vimso.padyu.dominio.gestion.usuarios;

import com.vimso.domain.EntidadPadre;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author vimso
 */
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "usuario_seq", allocationSize = 1)
public class Usuario extends EntidadPadre{

    @Column(unique = true,nullable = false)
    private String mail;
    
    @Column(nullable = false)
    private String password;
    
    @Column(unique = true,nullable = false)
    private String nombre;
    
    @ManyToMany(mappedBy = "usuarios")
    private List<Rol> roles;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">    

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    //</editor-fold>
    

}

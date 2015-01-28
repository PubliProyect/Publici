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
@SequenceGenerator(name = "default_gen", sequenceName = "permiso_seq", allocationSize = 1)
public class Permiso extends EntidadPadre{
    
    @Column(nullable = false,unique = true)
    private String nombre;

    @Column
    private String descripcion;
    
    @ManyToMany(mappedBy = "permisos")
    private List<Rol> roles;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }    
//</editor-fold> 

}

package com.vimso.padyu.dominio.gestion.usuarios;

import com.vimso.domain.EntidadPadre;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author vimso
 */
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "rol_seq", allocationSize = 1)
public class Rol extends EntidadPadre{
    
    @Column (nullable = false,unique = true)
    private String nombre;
    
    @Column (nullable = false)    
    private Boolean activo;
    
    @Column
    private String descripcion;
    
    @ManyToMany
    @JoinTable(
      name="ROL_USU",
      joinColumns={@JoinColumn(name="ROL_ID", referencedColumnName="ID")},
      inverseJoinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")})
    private List<Usuario> usuarios;
    
    @ManyToMany
    @JoinTable(
      name="ROL_PER",
      joinColumns={@JoinColumn(name="ROL_ID", referencedColumnName="ID")},
      inverseJoinColumns={@JoinColumn(name="PER_ID", referencedColumnName="ID")})
    private List<Permiso> permisos;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
    
    //</editor-fold>    
}

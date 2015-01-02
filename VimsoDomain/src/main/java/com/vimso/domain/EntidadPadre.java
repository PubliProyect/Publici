package com.vimso.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vimso
 */
@MappedSuperclass
public abstract class EntidadPadre {

    @Id
    @GeneratedValue(generator = "default_gen")
    @Column(nullable = false,unique = true)
    protected long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaModificacion;

    @PrePersist
    void createdAt() {
        this.fechaCreacion = this.fechaModificacion = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.fechaModificacion = new Date();
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    //</editor-fold>
}

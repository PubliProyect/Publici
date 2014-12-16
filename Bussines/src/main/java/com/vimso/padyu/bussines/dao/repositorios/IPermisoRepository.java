package com.vimso.padyu.bussines.dao.repositorios;
import com.vimso.padyu.dominio.GestionUsuarios.Permiso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vimso
 */
public interface IPermisoRepository extends CrudRepository<Permiso, Long>{

    @Query("from Permiso p where p.nombre=:nombre")
    public Permiso buscarPermiso(@Param("nombre") String nombre);

}

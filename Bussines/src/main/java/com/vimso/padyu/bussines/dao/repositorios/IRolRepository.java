package com.vimso.padyu.bussines.dao.repositorios;

import com.vimso.padyu.dominio.gestion.usuarios.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vimso
 */
public interface IRolRepository extends CrudRepository<Rol, Long>{

    @Query("from Rol r LEFT JOIN FETCH r.usuarios where r.nombre=:nombre")    
    public Rol buscarRolPorNombre(@Param("nombre") String nombre);

    @Query("from Rol r where r.activo=TRUE")
    public List<Rol> buscarRolactivos();

}

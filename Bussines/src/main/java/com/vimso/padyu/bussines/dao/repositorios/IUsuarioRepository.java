package com.vimso.padyu.bussines.dao.repositorios;

import com.vimso.padyu.dominio.gestion.usuarios.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vimso
 */
public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

    @Query("from Usuario u where u.nombre= :nombre or u.mail = :mail")
    public List<Usuario> getUsuariosBynombreOrMail(@Param("nombre") String nombre, @Param("mail") String mail);
    
    @Query("from Usuario u where u.nombre=:nombre")
    public Usuario getUsuariosByNombre(@Param("nombre") String nombre);

    @Query("from Usuario u where u.nombre IN :usuarios")
    public List<Usuario> buscarUsuarios(@Param("usuarios") List<String> usuarios);

    @Query("from Usuario u where u.mail IN :mail")
    public Usuario buscarUsuarioPorMail(@Param("mail") String mail);
}

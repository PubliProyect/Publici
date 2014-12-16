package com.vimso.padyu.bussines.dao;


import com.vimso.padyu.bussines.dao.interfaces.IDAORol;
import com.vimso.padyu.bussines.dao.repositorios.IRolRepository;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vimso
 */
@Named
public class DaoRol implements IDAORol{
    
    @Inject
    private IRolRepository rolRepository;
    
    @Override
    public void crearRol(Rol rol)
    {
        rolRepository.save(rol);
    
    }
    @Override
    public void modificarRol(Rol rol)
    {
        rolRepository.save(rol);
    }
    
    @Override
    public void eliminarRol(Long idRol) {
        rolRepository.delete(idRol);
    }

    @Override    
    public List<Rol> getAllRoles() {
        List<Rol> respuesta=new ArrayList<>();
        respuesta.addAll((Collection<? extends Rol>) rolRepository.findAll());
        return respuesta;
    }

    @Override
    public List<Rol> getAllRolesActivos() {
        return rolRepository.buscarRolactivos();
    }

    @Override
    public Rol buscarRolPorNombre(String nombre) {
        return rolRepository.buscarRolPorNombre(nombre);
    }

    @Override
    public void guardarRol(Rol rol) {
        rolRepository.save(rol);
    }
    

}

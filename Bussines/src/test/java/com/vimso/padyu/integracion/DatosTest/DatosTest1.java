package com.vimso.padyu.integracion.DatosTest;

import com.vimso.padyu.dominio.GestionUsuarios.Permiso;
import com.vimso.padyu.dominio.GestionUsuarios.Rol;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;

/**
 * Clase que contiene las entidades necesarias para los test
 *
 * @author vimso
 */
public class DatosTest1 {

    //<editor-fold defaultstate="collapsed" desc="Usuarios">
    public static Usuario getUsuario1() {
        Usuario u = new Usuario();

        u.setMail("usuario1@gmail.com");
        u.setNombre("NombreUsuario1");
        u.setPassword("password");

        return u;
    }

    public static Usuario getUsuario2() {
        Usuario u = new Usuario();

        u.setMail("usuario2@gmail.com");
        u.setNombre("NombreUsuario2");
        u.setPassword("password");

        return u;
    }

    public static Usuario getUsuario3() {
        Usuario u = new Usuario();

        u.setMail("usuario3@gmail.com");
        u.setNombre("NombrereUsuario3");
        u.setPassword("password");

        return u;
    }

    public static Usuario getUsuario4() {
        Usuario u = new Usuario();

        u.setMail("usuario4@gmail.com");
        u.setNombre("NombreUsuario4");
        u.setPassword("password");

        return u;
    }

    public static Usuario getUsuario5() {
        Usuario u = new Usuario();

        u.setMail("usuario5@gmail.com");
        u.setNombre("NombreUsuario5");
        u.setPassword("password");

        return u;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Roles">
    public static Rol getRol1() {

        int n = 1;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol2() {

        int n = 2;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol3() {

        int n = 3;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol4() {

        int n = 4;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol5() {

        int n = 5;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol6() {

        int n = 6;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol7() {

        int n = 7;
        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol8() {

        int n = 8;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);
        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

    public static Rol getRol9() {

        int n = 9;

        Rol respuesta = new Rol();

        respuesta.setActivo(Boolean.TRUE);

        respuesta.setDescripcion("Descripción Rol " + n);
        respuesta.setNombre("Nombre rol " + n);

        return respuesta;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Permisos">
//</editor-fold>
    public static Permiso getPermiso1() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 1;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }

    public static Permiso getPermiso2() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 2;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }

    public static Permiso getPermiso3() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 3;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }

    public static Permiso getPermiso4() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 4;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }

    public static Permiso getPermiso5() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 5;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }

    public static Permiso getPermiso6() {
        Permiso permisoRespuesta;
        permisoRespuesta = new Permiso();

        int n = 6;
        permisoRespuesta.setNombre("Permis o" + n);
        permisoRespuesta.setDescripcion("Descripcción permiso " + n);

        return permisoRespuesta;
    }
    
    
      public static Usuario getUsuarioCorrecto() {
         Usuario u=new Usuario();
        
        u.setMail("usuarioCorrecto1@gmail.com");
        u.setNombre("NombreusuarioCorrecto1");
        u.setPassword("password");
        
        return u;
    }

    public static Usuario getUsuarioNombreDuplicado() {
        Usuario res=DatosTest1.getUsuario1();
        res.setMail("unmailknoestara@gmail.com");
        return res;
    }

    public static Usuario getUsuarioMailDuplicado() {
        Usuario res=DatosTest1.getUsuario1();
        res.setNombre("un Nombre k no estará repetido");
        return res;
    }

    public static Usuario getUsuarioMailMalFormato() {

        Usuario respu = DatosTest1.getUsuario1();
        respu.setNombre("Usuario con mail erroneo");
        //Modifico el campo del mail
        respu.setMail("algo que no es un mail");
        return respu;
        
    }

}

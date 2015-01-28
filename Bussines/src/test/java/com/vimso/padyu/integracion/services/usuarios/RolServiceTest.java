package com.vimso.padyu.integracion.services.usuarios;

import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.Contexto1;
import com.vimso.padyu.integracion.DatosTest.DatosTest1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IRolesServices;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.dominio.gestion.usuarios.Rol;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE_ALL;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE_TDD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration
//@ContextConfiguration(classes={Contexto1.class})
//@RunWith(SpringJUnit4ClassRunner.class)
public class RolServiceTest {

    @Inject
    private IPobladorBBDD1 pobladorBBD;
    
    @Inject
    private IRolesServices rolesServices;
    
    @Inject
    private IUsuariosServices usuarioService;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    
    @Before
    public void setUp() {
        pobladorBBD.pobladorBBDD();
    }
    
    @After
    public void tearDown() {
    }
    
    //<editor-fold defaultstate="collapsed" desc="Creación de roles">
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testCrearRolNULL() {
//        
//        try {
//            rolesServices.crearRol(null);
//        } catch (ValidacionExcepcion e) {
//            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes()));
//        }
//    } 
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testCrearRolNombreDuplicado() {
//        
//        try {
//            rolesServices.crearRol(DatosTest1.getRol1());
//        } catch (ValidacionExcepcion e) {
//            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.ROL_YA_EXISTENTE).getRespuestaComponentes()));
//        }
//    } 
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testCrearRolNombreCorto() {
//        
//        try {
//            Rol rol =DatosTest1.getRol1();
//            rol.setNombre("123");
//            rolesServices.crearRol(rol);
//        } catch (ValidacionExcepcion e) {
//            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.ROL_NOMBRE_CORTO).getRespuestaComponentes()));
//        }
//    } 
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Busqueda de roles">
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Agregar usuarios a roles">
//
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test
//    public void testAgregarUsuarioARol() {
//
//        String rol = DatosTest1.getRol1().getNombre(); //Rol sin usuarios
//        List<String> usuarios = new ArrayList<>();
//
//        usuarios.addAll(Arrays.asList(
//                DatosTest1.getUsuario1().getNombre(),
//                DatosTest1.getUsuario2().getNombre(),
//                DatosTest1.getUsuario3().getNombre(),
//                DatosTest1.getUsuario4().getNombre()
//        ));
//
//        rolesServices.agregarUsuariosARol(rol, usuarios);
//        Rol rolEncontrado = rolesServices.buscarRol(rol);
//        Assert.assertEquals(rolEncontrado.getUsuarios().size(), usuarios.size());
//
//    }
//</editor-fold>
    
}

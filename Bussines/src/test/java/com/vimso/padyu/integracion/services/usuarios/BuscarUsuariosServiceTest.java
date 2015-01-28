

package com.vimso.padyu.integracion.services.usuarios;

import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration
//@ContextConfiguration(classes={Contexto1.class,WebAppContext.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class BuscarUsuariosServiceTest {
    
    
    @Inject
    private IUsuariosServices usuariosService;
    
    public BuscarUsuariosServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //<editor-fold defaultstate="collapsed" desc="Creación de usuarios">
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testBuscarUsuarioNULL() {
//        
//        try {
//            usuariosService.buscarUsuario(null);
//            fail("Se debería lanzar una excepcion de tipo ValidacionExcepcion");
//        } catch (ValidacionExcepcion e) {
//            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes()));
//        }
//    }  
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testBuscarUsuarioVacio() {
//        
//        try {
//            usuariosService.buscarUsuario("");
//            fail("Se debería lanzar una excepcion de tipo ValidacionExcepcion");
//        } catch (ValidacionExcepcion e) {
//            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes()));
//        }
//    }  
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
//    @Test
//    public void testBuscarUsuarioNombreNoExistente() {
//        
//            Usuario resultado=usuariosService.buscarUsuario("NombreNoExistente");
//            Assert.assertNull(resultado);
//    }  
    private class CargaBBDDTest{
        
    }
//</editor-fold>  
}

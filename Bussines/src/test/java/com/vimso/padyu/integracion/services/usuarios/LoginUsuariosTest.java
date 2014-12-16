package com.vimso.padyu.integracion.services.usuarios;

import com.vimso.padyu.api.to.gestionusuarios.in.LoginUsuariosTOIn;
import com.vimso.padyu.api.to.gestionusuarios.out.LoginUsuariosTOOut;
import com.vimso.padyu.integracion.DatosTest.DatosTest1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE_ALL;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.TESTING_SCOPE_TDD;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.annotation.IfProfileValue;

/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration
//@ContextConfiguration(classes = {Contexto1.class})
//@RunWith(SpringJUnit4ClassRunner.class)
public class LoginUsuariosTest {

    @Inject
    private IPobladorBBDD1 pobladorBBD;

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
        pobladorBBD.PobladorBBDD();
    }

    @After
    public void tearDown() {
    }

//    //<editor-fold defaultstate="collapsed" desc="Test">
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test
//    public void testLoginCorrecto() {
//
//            LoginUsuariosTOOut respuestaEsperada= new LoginUsuariosTOOut(new RespuestaComponentes(Mensaje.CREDENCIALES_CORRECTAS));
//            LoginUsuariosTOOut respuesta=usuarioService.loginUsuario(new LoginUsuariosTOIn(DatosTest1.getUsuario1().getMail(),DatosTest1.getUsuario1().getPassword()));
//            Assert.assertEquals(respuesta,respuestaEsperada);
//            
//    }
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test
//    public void testLoginPasswordIncorrecto() {
//
//            LoginUsuariosTOOut respuestaEsperada= new LoginUsuariosTOOut(new RespuestaComponentes(Mensaje.CREDENCIALES_ERRONEAS));
//            LoginUsuariosTOOut respuesta=usuarioService.loginUsuario(new LoginUsuariosTOIn(DatosTest1.getUsuario1().getMail(),"una constraseña erronea"));
//            Assert.assertEquals(respuesta,respuestaEsperada);
//    }
//    
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test
//    public void testLoginPasswordNull() {
//        try {
//            usuarioService.loginUsuario(new LoginUsuariosTOIn(DatosTest1.getUsuario1().getMail(), null));
//            fail("Deberia haber fallado");
//        } catch (ValidacionExcepcion e) {
//            Assert.assertEquals(e.getRespuestaComponentes(), new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes());
//        }
//    }
//    
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test    
//    public void testLoginMailFalso() {
//
//            LoginUsuariosTOOut respuestaEsperada= new LoginUsuariosTOOut(new RespuestaComponentes(Mensaje.CREDENCIALES_ERRONEAS));
//            LoginUsuariosTOOut respuesta=usuarioService.loginUsuario(new LoginUsuariosTOIn("mailInexistente",DatosTest1.getUsuario1().getPassword()));
//            Assert.assertEquals(respuesta,respuestaEsperada);
//    }
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test    
//    public void testLoginMailnull() {
//
//        try {
//            usuarioService.loginUsuario(new LoginUsuariosTOIn(null, DatosTest1.getUsuario1().getPassword()));
//            fail("Deberia haber fallado");
//        } catch (ValidacionExcepcion e) {
//            Assert.assertEquals(e.getRespuestaComponentes(), new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes());
//        }
//    }
//    
//    @IfProfileValue(name = TESTING_SCOPE, values = {TESTING_SCOPE_TDD, TESTING_SCOPE_ALL})
//    @Test    
//    public void testLoginNull() {
//
//        try {
//            usuarioService.loginUsuario(new LoginUsuariosTOIn(null, null));
//            fail("Deberia haber fallado");
//        } catch (ValidacionExcepcion e) {
//            Assert.assertEquals(e.getRespuestaComponentes(), new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes());
//        }
//    }
//    
    
//</editor-fold>
}

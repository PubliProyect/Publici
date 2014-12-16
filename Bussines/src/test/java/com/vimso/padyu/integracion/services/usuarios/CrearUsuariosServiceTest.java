package com.vimso.padyu.integracion.services.usuarios;

import com.vimso.padyu.integracion.DatosTest.DatosTest1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.Contexto1;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.respuesta.ValidacionExcepcion;
import static com.vimso.utils.vimsoutils.testing.ScopeTest.*;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration
@ContextConfiguration(classes={Contexto1.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CrearUsuariosServiceTest {
    
    @Inject
    private IPobladorBBDD1 pobladorBBD;
    
    @Inject
    private IUsuariosServices usuariosService;
        
    public CrearUsuariosServiceTest() {
    }
    
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
    
    //<editor-fold defaultstate="collapsed" desc="Creación de usuarios">
    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test(expected = ValidacionExcepcion.class)
    public void testCrearUsuarioNULL() {
        
        try {
            usuariosService.crearUsuario(null);
            fail("Deberia haber fallado");
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes()));
            throw e;
        }
    }    
    
    @IfProfileValue(name = TESTING_SCOPE,value = TESTING_SCOPE_TDD )
    @Test
    public void testCrearUsuarioCorrecto() {
        usuariosService.crearUsuario(DatosTest1.getUsuarioCorrecto());
        validarCreacionUsuario(DatosTest1.getUsuarioCorrecto());
    }
    
    @IfProfileValue(name = TESTING_SCOPE,value = TESTING_SCOPE_TDD )
    @Test(expected = ValidacionExcepcion.class)
    public void testCrearUsuarioNombreDuplicado() {
        try {
            usuariosService.crearUsuario(DatosTest1.getUsuarioNombreDuplicado());
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.NOMBRE_EN_USO).getRespuestaComponentes()));
            throw e;
        }
    }
    
    @IfProfileValue(name = TESTING_SCOPE,value = TESTING_SCOPE_TDD )
    @Test(expected = ValidacionExcepcion.class)
    public void testCrearUsuarioMailDuplicado() {
        try {
            usuariosService.crearUsuario(DatosTest1.getUsuarioMailDuplicado());
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.MAIL_EN_USO).getRespuestaComponentes()));
            throw e;
        }
    }
    
    @IfProfileValue(name = TESTING_SCOPE,value = TESTING_SCOPE_TDD )
    @Test(expected = ValidacionExcepcion.class)
    public void testCrearUsuarioDatosErroneos() {
        try {
                usuariosService.crearUsuario(DatosTest1.getUsuarioMailMalFormato());    
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.MAIL_MAL_FORMATO).getRespuestaComponentes()));
            throw e;
        }        
    }    
    
//</editor-fold>       
  
    public void validarCreacionUsuario(Usuario usuarioReferencia) {
        Usuario usuarioEncontrado=usuariosService.buscarUsuario(usuarioReferencia.getNombre());
        Assert.assertEquals(usuarioReferencia.getMail(), usuarioEncontrado.getMail());
    }
}
package com.vimso.padyu.integracion.webservices.gestion.usuarios;

import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IUsuariosServices;
import com.vimso.padyu.dominio.GestionUsuarios.Usuario;
import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.Contexto1;
import com.vimso.padyu.integracion.DatosTest.DatosTest1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.WebAppContext;
import com.vimso.padyu.utils.traductor.ITraductor;
import com.vimso.padyu.web.webservice.rest.services.users.IUsuariosWService;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
import com.vimso.utils.vimsoutils.dto.VOut;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Contexto1.class, WebAppContext.class})
@WebAppConfiguration
@Transactional
public class CrearUsuariosWSTest {

    @Inject
    private IPobladorBBDD1 pobladorBBD;

    @Inject
    private IUsuariosWService usuariowService;

    @Inject
    private IUsuariosServices usuariosService;

    @Inject
    private ITraductor traductorService;

    public CrearUsuariosWSTest() {
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

//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
   
    @Test
    public void testCrearUsuarioCorrecto() throws Exception {
        VOut respuesta = usuariowService.crearUsuario(transforUsuarioTo(DatosTest1.getUsuarioCorrecto()));
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(respuesta.getResPlain().isOk());
        Assert.assertEquals(0, respuesta.getResPlain().getMensajes().size());
        validarCreacionUsuario(DatosTest1.getUsuarioCorrecto());
    }
    @Test
    public void testCrearUsuarioNombreVacio() throws Exception {
        Usuario usr= DatosTest1.getUsuarioCorrecto();
        usr.setNombre("");
        VOut respuesta = usuariowService.crearUsuario(transforUsuarioTo(usr));
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.NOMBRE_CARACTERES_MINIMOS, null, new Locale("es", "es")), respuesta.getResPlain().getMensajes().get(0));
    
    }
    
    @Test
    public void testCrearUsuarioNombreNull() throws Exception {
        Usuario usr= DatosTest1.getUsuarioCorrecto();
        usr.setNombre(null);
        VOut respuesta = usuariowService.crearUsuario(transforUsuarioTo(usr));
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.NOMBRE_CARACTERES_MINIMOS, null, new Locale("es", "es")), respuesta.getResPlain().getMensajes().get(0));
    }
    @Test
    public void testCrearUsuarioMailNull() throws Exception {
        Usuario usr= DatosTest1.getUsuarioCorrecto();
        usr.setMail(null);
        VOut respuesta = usuariowService.crearUsuario(transforUsuarioTo(usr));
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.MAIL_MAL_FORMATO, null, new Locale("es", "es")), respuesta.getResPlain().getMensajes().get(0));
    }
    @Test
    public void testCrearUsuarioTodoNull() throws Exception {
        Usuario usr= DatosTest1.getUsuarioCorrecto();
        usr.setNombre(null);
        usr.setPassword(null);
        usr.setMail(null);
        
        VOut respuesta = usuariowService.crearUsuario(transforUsuarioTo(usr));
        
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(3, respuesta.getResPlain().getMensajes().size());
        
        List<String> mensajesDeRespuesta= new ArrayList<>();
        Locale locale =new Locale("es", "es");
        
        mensajesDeRespuesta.add(traductorService.getTraduccion(Mensaje.MAIL_MAL_FORMATO, null, locale));
        mensajesDeRespuesta.add(traductorService.getTraduccion(Mensaje.NOMBRE_CARACTERES_MINIMOS, null, locale));
        mensajesDeRespuesta.add(traductorService.getTraduccion(Mensaje.PASSWORD_CARACTERES_MINIMOS, null, locale));
        
        Assert.assertArrayEquals(mensajesDeRespuesta.toArray(), respuesta.getResPlain().getMensajes().toArray());
    }

    @Test
    public void testCrearUsuarioMailMalFormato() {
        RegistroUsuarioTOIn registroUsuarioIn=transforUsuarioTo(DatosTest1.getUsuarioMailMalFormato());
        VOut respuesta = usuariowService.crearUsuario(registroUsuarioIn);
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.MAIL_MAL_FORMATO, null, registroUsuarioIn.getLocale()), respuesta.getResPlain().getMensajes().get(0));
    }
    @Test
    public void testCrearUsuarioPasswordCorta() {
        RegistroUsuarioTOIn registroUsuarioIn=transforUsuarioTo(DatosTest1.getUsuarioCorrecto());
        registroUsuarioIn.setPassword("123");
        VOut respuesta = usuariowService.crearUsuario(registroUsuarioIn);
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.PASSWORD_CARACTERES_MINIMOS, null, registroUsuarioIn.getLocale()), respuesta.getResPlain().getMensajes().get(0));
    }

    @Test
    public void testCrearUsuarioNombreDuplicado() {
        RegistroUsuarioTOIn registroUsuarioIn=transforUsuarioTo(DatosTest1.getUsuarioNombreDuplicado());
        VOut respuesta=usuariowService.crearUsuario(registroUsuarioIn);
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.NOMBRE_EN_USO, null, registroUsuarioIn.getLocale()), respuesta.getResPlain().getMensajes().get(0));

    }
    @Test
    public void testCrearUsuarioMailDuplicado() {
        RegistroUsuarioTOIn registroUsuarioIn=transforUsuarioTo(DatosTest1.getUsuarioMailDuplicado());
        VOut respuesta=usuariowService.crearUsuario(registroUsuarioIn);
        Assert.assertNotNull(respuesta);
        Assert.assertTrue(!respuesta.getResPlain().isOk());
        Assert.assertEquals(1, respuesta.getResPlain().getMensajes().size());
        Assert.assertEquals(traductorService.getTraduccion(Mensaje.MAIL_EN_USO, null, registroUsuarioIn.getLocale()), respuesta.getResPlain().getMensajes().get(0));

    }

    private RegistroUsuarioTOIn transforUsuarioTo(Usuario usuario) {
        RegistroUsuarioTOIn respuesta = new RegistroUsuarioTOIn();
        respuesta.setMail(usuario.getMail());
        respuesta.setNombre(usuario.getNombre());
        respuesta.setPassword(usuario.getPassword());
        respuesta.setLocale(new Locale("es", "ES"));
        return respuesta;
    }

    public void validarCreacionUsuario(Usuario usuarioReferencia) {
        Usuario usuarioEncontrado = usuariosService.buscarUsuario(usuarioReferencia.getNombre());
        Assert.assertEquals(usuarioReferencia.getMail(), usuarioEncontrado.getMail());
    }

}

package com.vimso.padyu.integracion.webservices.gestion.usuarios.http;

import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.Contexto1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.WebAppContext;
import com.vimso.padyu.mapping.MappingServicesNames;
import java.util.Locale;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author vimso
 */
//@ProfileValueSourceConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Contexto1.class,WebAppContext.class})
@WebAppConfiguration
@Transactional
public class CrearUsuariosWSTest {

    private static String URE_SERVICE="/"+MappingServicesNames.USER+"/"+MappingServicesNames.CREATE_USER;
    
    private MockMvc mockMvc;
    
    @Inject
    private IPobladorBBDD1 pobladorBBD;
    
    @Inject
    private WebApplicationContext webApplicationContext;
            
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
        pobladorBBD.pobladorBBDD();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }
    
    @After
    public void tearDown() {
    }
    
//    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test
    public void testCrearUsuarioNULL() throws Exception {

        RegistroUsuarioTOIn object = new RegistroUsuarioTOIn();        
        
        object.setLocale(new Locale("es", "ES"));
        
        mockMvc.perform(post(URE_SERVICE)
                .contentType(TestUtil.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(object))
        )
                .andExpect(status().isOk());
        
    }    
    @Test
    public void testCrearUsuarioCorrecto() throws Exception {

        RegistroUsuarioTOIn object = new RegistroUsuarioTOIn();
        object.setMail("mail@gmail.com");
        object.setNombre("NameTest");
        object.setPassword("PasswordTest");
        object.setLocale(new Locale("es", "ES"));
        
        mockMvc.perform(post(URE_SERVICE)
                .contentType(TestUtil.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(object))
        )
                .andExpect(status().isOk());
        
    }    

}

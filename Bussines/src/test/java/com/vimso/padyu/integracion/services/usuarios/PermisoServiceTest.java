package com.vimso.padyu.integracion.services.usuarios;

import com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI.Contexto1;
import com.vimso.padyu.bussines.services.usuarios.interfaces.IPermisosService;
import com.vimso.padyu.dominio.gestion.usuarios.Permiso;
import com.vimso.padyu.integracion.DatosTest.DatosTest1;
import com.vimso.padyu.integracion.DatosTest.IPobladorBBDD1;
import com.vimso.utils.vimsoutils.comunicacion.Mensaje;
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
import org.junit.runner.RunWith;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vimso
 */
@ProfileValueSourceConfiguration
@ContextConfiguration(classes={Contexto1.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PermisoServiceTest {
    
     @Inject
    private IPobladorBBDD1 pobladorBBD;
    
    @Inject
    private IPermisosService permisosService;
    
    
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
    
    //<editor-fold defaultstate="collapsed" desc="creación permisos">
    
    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test
    public void testCrearPermisoNULL() {
        
        try {
            permisosService.crearPermiso(null);
            fail("Deberia haber fallado");
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.VALOR_VACIO).getRespuestaComponentes()));
        }
    }
    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test
    public void testCrearPermisoCorrecto() {
        
            Permiso permiso=DatosTest1.getPermiso1();
            permiso.setNombre("Permiso Correcto");
            permisosService.crearPermiso(permiso);

    }
    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test
    public void testCrearPermisoDuplicado() {
        
        try {
            permisosService.crearPermiso(DatosTest1.getPermiso1());
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.PERMISO_YA_EXISTENTE).getRespuestaComponentes()));
        }
    }
    @IfProfileValue(name = TESTING_SCOPE,values = {TESTING_SCOPE_TDD,TESTING_SCOPE_ALL}  )
    @Test
    public void testCrearPermisoNombreCorto() {
        
        try {
            Permiso permiso=DatosTest1.getPermiso1();
            permiso.setNombre("123");
        } catch (ValidacionExcepcion e) {
            Assert.assertTrue(e.getRespuestaComponentes().equals(new ValidacionExcepcion(Mensaje.PERMISO_YA_EXISTENTE).getRespuestaComponentes()));
        }
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Busqueda de Permisos">
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Asociación Permisos Rol">
    
//</editor-fold>

}

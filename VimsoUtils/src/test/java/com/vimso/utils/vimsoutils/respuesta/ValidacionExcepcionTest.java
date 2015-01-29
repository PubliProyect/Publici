package com.vimso.utils.vimsoutils.respuesta;

import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vimso
 */
public class ValidacionExcepcionTest {

    public ValidacionExcepcionTest() {
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

    /**
     * Test of getRespuestaComponentes method, of class ValidacionExcepcion.
     */
    @Test
    public void testSetGetRespuestaComponentes() {
        System.out.println("getRespuestaComponentes");
        ValidacionExcepcion instance = new ValidacionExcepcion();
        RespuestaComponentes expResult = new RespuestaComponentes();
        instance.setRespuestaComponentes(expResult);
        RespuestaComponentes result = instance.getRespuestaComponentes();
        assertEquals(expResult, result);
    }

    //<editor-fold defaultstate="collapsed" desc="comment">
    /**
     * Test of equals method, of class ValidacionExcepcion. Null_VS_New
     */
    @Test
    public void testEquals_Null_VS_New() {
        System.out.println("equals Null_VS_New");
        Object o = null;
        ValidacionExcepcion instance = new ValidacionExcepcion();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class ValidacionExcepcion. (New_VS_New)
     */
    @Test
    public void testEquals_New_VS_New() {
        System.out.println("equals New_VS_New");
        Object o = new ValidacionExcepcion();
        ValidacionExcepcion instance = new ValidacionExcepcion();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class ValidacionExcepcion. (New_VS_Con_Respuesta)
     */
    @Test
    public void testEquals_New_VS_Con_Respuesta() {
        System.out.println("equals New_VS_Con_Respuesta");
        Object o = new ValidacionExcepcion();
        ValidacionExcepcion instance = generateValidacionConRespuesta();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class ValidacionExcepcion. (Con_Respuesta_VS_New)
     */
    @Test
    public void testEquals_Con_Respuesta_VS_New() {
        System.out.println("equals Con_Respuesta_VS_New");
        Object o = new ValidacionExcepcion();
        ValidacionExcepcion instance = generateValidacionConRespuesta();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ValidacionExcepcion.
     */
    @Test
    public void testHashCodeVacio() {
        System.out.println("hashCode");
        ValidacionExcepcion instance = new ValidacionExcepcion();
        int expResult = new ValidacionExcepcion().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ValidacionExcepcion.
     */
    @Test
    public void testHashCodeRespuesta() {
        System.out.println("hashCode");
        RespuestaComponentes resp = new RespuestaComponentes("respuesta1");
        ValidacionExcepcion instance = new ValidacionExcepcion(resp);
        int expResult = new ValidacionExcepcion(resp).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
//</editor-fold>    

    private ValidacionExcepcion generateValidacionConRespuesta() {
        ValidacionExcepcion validacion = new ValidacionExcepcion();

        validacion.setRespuestaComponentes(new RespuestaComponentes("Clave del mensaje", true));
        return validacion;
    }
}

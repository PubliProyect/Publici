package com.vimso.utils.vimsoutils.comunicacion;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author vimso
 */
public class RespuestaComponentesTest extends TestCase {
    
    public RespuestaComponentesTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Test de constructores">
    /**
     * Test de constructor sin argumentos.
     */
    @Test
    public void testConstructor_Sin_Argumentos() {
        System.out.println("Constructor sin argumentos");
        RespuestaComponentes instance = new RespuestaComponentes();
        assertNotNull(instance.getMensajes());
        assertEquals(instance.isOK(),true);
    }
    
    /**
     * Test de constructor con argumento de tipo String.
     */
    @Test
    public void testConstructor_Argumento_Tipo_String() {
        System.out.println("Constructor con argumento tipo string");
        String textoMensaje="Esto es el texto del mensaje que engloba la respuesta de componentes";
        RespuestaComponentes instance = new RespuestaComponentes(textoMensaje);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(),1);
        assertEquals(instance.getMensajes().get(0).getClaveMensaje(),textoMensaje);
        assertEquals(instance.isOK(),false);
    }
    
    /**
     * Test de constructor con argumentos de tipo Strings y Booleans.
     */
    @Test
    public void testConstructor_Argumentos_Tipo_String_Y_Boolean() {
        System.out.println("Constructor con argumentos tipos string y Boolean");
        String textoMensaje="Esto es el texto del mensaje que engloba la respuesta de componentes";
        RespuestaComponentes instance = new RespuestaComponentes(textoMensaje,true);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(),1);
        assertEquals(instance.getMensajes().get(0).getClaveMensaje(),textoMensaje);
        assertEquals(instance.isOK(),true);
    }
    
    /**
     * Test de constructor con argumento de tipo Mensaje.
     */
    @Test
    public void testConstructor_Argumento_Tipo_Mensaje() {
        System.out.println("Constructor con argumento tipo Mensaje");
        String textoMensaje="Esto es el texto del mensaje que engloba la respuesta de componentes";
        Mensaje mensaje= new Mensaje(textoMensaje);
        RespuestaComponentes instance = new RespuestaComponentes(mensaje);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(),1);
        assertEquals(instance.getMensajes().get(0).getClaveMensaje(),textoMensaje);
        assertEquals(instance.isOK(),false);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Test de las propiedades">   

    /**
     * Test of addMensaje method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensaje_Mensaje_Y_GetMensaje() {
        System.out.println("addMensaje");
        Mensaje mensaje = new Mensaje();
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensaje(mensaje);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(),1);
        assertEquals(instance.getMensajes().get(0),mensaje);
        
    }

    /**
     * Test of setMensajes method, of class RespuestaComponentes.
     */
    @Test
    public void testSetMensajes() {
        System.out.println("setMensajes");
        Mensaje mensaje = new Mensaje();
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.setMensajes(Arrays.asList(mensaje));
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(),1);
        assertEquals(instance.getMensajes().get(0),mensaje);
    }

    /**
     * Test of setOK method, of class RespuestaComponentes.
     */
    @Test
    public void testSetOK() {
        System.out.println("setOK");
        boolean ok = false;
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.setOK(ok);
        assertEquals(ok, instance.isOK());
    }


    /**
     * Test of addMensaje method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensaje_String() {
        System.out.println("addMensaje");
        String mensaje = "Mensaje";
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensaje(mensaje);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.isOK(), true);
    }

    /**
     * Test of addMensajeKO method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensajeKO_String() {
        System.out.println("addMensajeKO");
        String mensaje = "";
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensajeKO(mensaje);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.isOK(), false);
    }

    /**
     * Test of addMensaje method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensaje_String_List() {
        System.out.println("addMensaje");
        String mensaje = "mensaje";
        List<String> parametros = Arrays.asList("Parametro1", "Parametro2");
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensaje(mensaje, parametros);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.getMensajes().get(0).getParametros(),parametros);
        assertEquals(instance.isOK(), true);
    }

    /**
     * Test of addMensaje method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensaje_String_String() {
        System.out.println("addMensaje");
        String mensaje = "Clave Mensaje";
        String parametro = "Parámetro";
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensaje(mensaje, parametro);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.getMensajes().get(0).getParametros().size(),1);
        assertEquals(instance.getMensajes().get(0).getParametros().get(0),parametro);
        assertEquals(instance.isOK(), true);
    }

    /**
     * Test of addMensajeKO method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensajeKO_String_List() {
        System.out.println("addMensajeKO");
        String mensaje = "mensaje";
        List<String> parametros = Arrays.asList("Parametro1", "Parametro2");
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensajeKO(mensaje, parametros);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.getMensajes().get(0).getParametros(),parametros);
        assertEquals(instance.isOK(), false);
    }

    /**
     * Test of addMensajeKO method, of class RespuestaComponentes.
     */
    @Test
    public void testAddMensajeKO_String_String() {
        System.out.println("addMensaje");
        String mensaje = "Clave Mensaje";
        String parametro = "Parámetro";
        RespuestaComponentes instance = new RespuestaComponentes();
        instance.addMensajeKO(mensaje, parametro);
        assertNotNull(instance.getMensajes());
        assertEquals(instance.getMensajes().size(), 1);
        assertEquals(instance.getMensajes().get(0).getParametros().size(),1);
        assertEquals(instance.getMensajes().get(0).getParametros().get(0),parametro);
        assertEquals(instance.isOK(), false);
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Test de Equals y Hascode">
    
//</editor-fold>
    /**
     * Test of equals method, of class RespuestaComponentes. New_Con_Null
     */
    @Test
    public void testEquals_New_Con_Null() {
        System.out.println("equals New_Con_Null");
        Object o = null;
        RespuestaComponentes instance = new RespuestaComponentes();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RespuestaComponentes. New_Con_New
     */
    @Test
    public void testEquals_New_Con_New() {
        System.out.println("equals New_Con_New");
        Object o = new RespuestaComponentes();
        RespuestaComponentes instance = new RespuestaComponentes();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class RespuestaComponentes. New_Con_Respuesta_Con_Mensaje
     */
    @Test
    public void testEquals_New_Con_Respuesta_Con_Mensaje() {
        System.out.println("equals New_Con_Respuesta_Con_Mensaje");
        Object o = generateRespuestaConMensajeOK();
        RespuestaComponentes instance = new RespuestaComponentes();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RespuestaComponentes. Respuesta_Con_Mensaje_KO_VS_Respuesta_Con_Mensaje_OK
     * 
     */
    @Test
    public void testEquals_Respuesta_Con_Mensaje_KO_VS_Respuesta_Con_Mensaje_OK() {
        System.out.println("equals Respuesta_Con_Mensaje_KO_VS_Respuesta_Con_Mensaje_OK");
        Object o = generateRespuestaConMensajeKO();
        RespuestaComponentes instance = generateRespuestaConMensajeOK();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class RespuestaComponentes. Respuesta_Mensaje_KO_Con_X_Parametros_VS_Respuesta_Mensaje_OK_Con_X_Parametros
     */
    @Test
    public void testEquals_Respuesta_Mensaje_KO_Con_X_Parametros_VS_Respuesta_Mensaje_OK_Con_X_Parametros() {
        System.out.println("equals Respuesta_Mensaje_KO_Con_X_Parametros_VS_Respuesta_Mensaje_OK_Con_X_Parametros");
        Object o = generateRespuestaConMensajeKOYParametros();
        RespuestaComponentes instance = generateRespuestaConMensajeOKYParametros();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class RespuestaComponentes. Respuesta_Mensaje_Con_X_Parametros_Ordenados
     */
    @Test
    public void testEquals_Respuesta_Mensaje_Con_X_Parametros_Ordenados() {
        System.out.println("equals testEquals_Respuesta_Mensaje_Con_X_Parametros_Ordenados");
        Object o = generateRespuestaConMensajesOrdenados1();
        RespuestaComponentes instance = generateRespuestaConMensajesOrdenados1();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class RespuestaComponentes. testEquals_Respuesta_Mensaje_Con_X_Parametros_Desordenados
     */
    @Test
    public void testEquals_Respuesta_Mensaje_Con_X_Parametros_Desordenados() {
        System.out.println("equals testEquals_Respuesta_Mensaje_Con_X_Parametros_Desordenados");
        Object o = generateRespuestaConMensajesDesordenados2();
        RespuestaComponentes instance = generateRespuestaConMensajesDesordenados1();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class RespuestaComponentes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        RespuestaComponentes instance = new RespuestaComponentes();
        int expResult = Objects.hashCode(instance.getMensajes(),instance.isOK());
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Aprovisionamiento de los test">
    private RespuestaComponentes generateRespuestaConMensajeOK() {
        
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setMensajes(Arrays.asList(new Mensaje()));
        return respuesta;
    }
    
    private RespuestaComponentes generateRespuestaConMensajeKO() {
        
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(false);
        respuesta.setMensajes(Arrays.asList(new Mensaje()));
        return respuesta;
    }
    
    private RespuestaComponentes generateRespuestaConMensajeOKYParametros() {
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(true);
        respuesta.setMensajes(Arrays.asList(new Mensaje("Clave Mensaje",Arrays.asList("parametro1","Parametro2"))));
        return respuesta;
    }
    
    private RespuestaComponentes generateRespuestaConMensajeKOYParametros() {
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(false);
        respuesta.setMensajes(Arrays.asList(new Mensaje("Clave Mensaje",Arrays.asList("parametro1","Parametro2"))));
        return respuesta;
    }
    
    private RespuestaComponentes generateRespuestaConMensajesDesordenados1() {
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(true);
        respuesta.setMensajes(Arrays.asList(new Mensaje("Clave Mensaje",Arrays.asList("parametro1A","Parametro2A")),new Mensaje("Clave Mensaje",Arrays.asList("parametro1B","Parametro2B"))));
        return respuesta;
    }
    private RespuestaComponentes generateRespuestaConMensajesDesordenados2() {
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(true);
        respuesta.setMensajes(Arrays.asList(new Mensaje("Clave Mensaje",Arrays.asList("parametro1B","Parametro2B")),new Mensaje("Clave Mensaje",Arrays.asList("parametro1A","Parametro2A"))));
        return respuesta;
    }
    
    private RespuestaComponentes generateRespuestaConMensajesOrdenados1() {
        RespuestaComponentes respuesta = new RespuestaComponentes();
        respuesta.setOK(true);
        respuesta.setMensajes(Arrays.asList(new Mensaje("Clave Mensaje", Arrays.asList("parametro1B", "Parametro2B")), new Mensaje("Clave Mensaje", Arrays.asList("parametro1A", "Parametro2A"))));
        return respuesta;
    }
//</editor-fold>

    
    
}

package com.vimso.utils.vimsoutils.comunicacion;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author vimso
 */
public class MensajeTest extends TestCase {

    public MensajeTest(String testName) {
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

    //<editor-fold defaultstate="collapsed" desc="Testeando la propiedad Clave">
    /**
     * Test of getClaveMensaje method and setClaveMensaje, of class Mensaje.
     */
    public void testClaveMensajeStandar() {
        System.out.println("testClaveMensajeStandar");
        Mensaje instance = new Mensaje();
        String expResult = "ClaveMensaje";
        instance.setClaveMensaje(expResult);
        String result = instance.getClaveMensaje();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClaveMensaje method and setClaveMensaje, of class Mensaje.
     */
    public void testClaveMensajeNull() {
        System.out.println("testClaveMensajeNull");
        Mensaje instance = new Mensaje();
        String expResult = null;
        instance.setClaveMensaje(expResult);
        String result = instance.getClaveMensaje();
        assertEquals(expResult, result);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Test parametros">
    /**
     * Test of getParametro method and setParametro, of class Mensaje.
     */
    public void testParametrosCorrectos() {
        System.out.println("getParametros");
        Mensaje instance = new Mensaje();
        List<String> expResult = Arrays.asList("Elemento primero", "Elemento segundo");
        instance.setParametros(expResult);
        List<String> result = instance.getParametros();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParametro method and setParametro, of class Mensaje.
     */
    public void testParametrosNull() {
        System.out.println("getParametros");
        Mensaje instance = new Mensaje();
        assertNotNull(instance.getParametros());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="testando equals y has code">
    /**
     * Test of equals method, Referencia_Tipo_Diferente.
     */
    public void testEquals_Referencia_Tipo_Diferente() {
        System.out.println("equals Referencia_Tipo_Diferente");
        Object o = "a";
        Mensaje instance = new Mensaje();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class Mensaje to a null Mensaje.
     */
    public void testEqualsReferenciaNull() {
        System.out.println("equals");
        Object o = null;
        Mensaje instance = new Mensaje();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (para una instancia limpia de
     * mensaje).
     */
    public void testEqualsReferenciaNew() {
        System.out.println("equals");
        Object o = new Mensaje();
        Mensaje instance = new Mensaje();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, una nueva
     * y vacia y otra completa)
     */
    public void testEqualsMensajes_Diferentes_Nueva_Y_Clave_Mensaje_Mas_tres_parametros() {
        System.out.println("equals");
        Object o = this.generarMensajeConClaveMensajeYTresParametros();
        Mensaje instance = new Mensaje();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias iguales sólo con
     * Claves)
     */
    public void testEqualsMensajes_Iguales_Solo_Clave_Mensaje() {
        System.out.println("equals");
        Object o = this.generarMensajeConSoloUnaClaveMensaje();
        Mensaje instance = this.generarMensajeConSoloUnaClaveMensaje();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes sólo con
     * Claves)
     */
    public void testEqualsMensajes_Diferentes_Solo_Clave_Mensaje() {
        System.out.println("equals");
        Object o = this.generarMensajeConSoloUnaClaveMensaje();
        Mensaje instance = this.generarMensajeConSoloUnaClaveMensajeDos();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, una con
     * solo la clave y otra con la misma clave y tres parámetros)
     */
    public void testEqualsMensajes_Diferentes_Solo_Clave_Mensaje_Y_Clave_Mensaje_Mas_tres_parametros() {
        System.out.println("equals");
        Object o = generarMensajeConClaveMensajeYTresParametros();
        Mensaje instance = this.generarMensajeConSoloUnaClaveMensajeDos();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, mismos
     * parámetros, pero uno sin clave)
     */
    public void testEqualsMensajes_Diferentes_Mismo_Parametro_Pero_Uno_Sin_Clave() {
        System.out.println("equals");
        Object o = generarMensajeConClaveYUnSoloParametro();
        Mensaje instance = generarMensajeConSoloUnParametro();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, mismos
     * parámetros, pero uno sin clave)
     */
    public void testEqualsMensajes_Diferentes_Mismo_Parametro_Pero_Uno_Sin_Clave_Inverso() {
        System.out.println("equals");
        Object o = generarMensajeConSoloUnParametro();
        Mensaje instance = generarMensajeConClaveYUnSoloParametro();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, misma
     * clave, misma cantidad de parámetros pero desordenados)
     */
    public void testEqualsMensajes_Diferentes_Clave_Mensaje_Mas_tres_parametros_Y_Clave_Mensaje_Mas_tres_Parametros_Desordenados() {
        System.out.println("equals");
        Object o = generarMensajeConClaveMensajeYTresParametros();
        Mensaje instance = this.generarMensajeConClaveMensajeYTresParametrosDesordenados();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mensaje (Instancias diferentes, misma
     * clave, misma cantidad de parámetros pero distintos)
     */
    public void testEqualsMensajes_Diferentes_Clave_Mensaje_Mas_tres_parametros_Y_Clave_Mensaje_Mas_tres_Parametros_Distintos() {
        System.out.println("equals");
        Object o = generarMensajeConClaveMensajeYTresParametros();
        Mensaje instance = this.generarMensajeConClaveMensajeYTresParametrosDistintos();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Mensaje.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Mensaje instance = generarMensajeConClaveMensajeYTresParametros();
        int expResult = generarMensajeConClaveMensajeYTresParametros().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Test de los constructores">
    /**
     * Test of constructor, of class Mensaje (Sin argumentos).
     */
    public void testConstruct_Sin_Argumentos() {
        System.out.println("Constructor sin argumentos");
        Mensaje instance = new Mensaje();
        assertNotNull(instance.getParametros());
        assertNull(instance.getClaveMensaje());
    }

    /**
     * Test of constructor, of class Mensaje (Sin parámetros, pero con clave).
     */
    public void testConstruct_Sin_Parametros_Pero_Con_Clave() {
        System.out.println("Constructor Sin parámetros, pero con clave");
        Mensaje instance = new Mensaje("Clave del mensaje");
        assertNotNull(instance.getParametros());
        assertNotNull(instance.getClaveMensaje());
    }

    /**
     * Test of constructor, of class Mensaje (Con todos los parámetros).
     */
    public void testConstruct_Con_Todos_Los_Parametros() {
        System.out.println("Con todos los parámetros");
        Mensaje instance = new Mensaje("Clave del mensaje");
        assertNotNull(instance.getParametros());
        assertNotNull(instance.getClaveMensaje());
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Provisionamiento de test">
    private Mensaje generarMensajeConSoloUnParametro() {
        Mensaje valor = new Mensaje();
        valor.setParametros(Arrays.asList("Unico Parametro"));
        return valor;
    }

    private Mensaje generarMensajeConClaveYUnSoloParametro() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("clave del mensaje");
        valor.setParametros(Arrays.asList("Unico Parametro"));
        return valor;
    }

    private Mensaje generarMensajeConTresParametro() {
        Mensaje valor = new Mensaje();
        valor.setParametros(Arrays.asList("Parametro 1", "Parametro 2", "Parametro 3"));
        return valor;
    }

    private Mensaje generarMensajeConSoloUnaClaveMensaje() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("ClaveMensaje");
        return valor;
    }

    private Mensaje generarMensajeConSoloUnaClaveMensajeDos() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("ClaveMensajeDos");
        return valor;
    }

    private Mensaje generarMensajeConClaveMensajeYTresParametros() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("ClaveMensaje");
        valor.setParametros(Arrays.asList("Parametro 1", "Parametro 2", "Parametro 3"));
        return valor;
    }

    private Mensaje generarMensajeConClaveMensajeYTresParametrosDesordenados() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("ClaveMensaje");
        valor.setParametros(Arrays.asList("Parametro 2", "Parametro 1", "Parametro 3"));
        return valor;
    }

    private Mensaje generarMensajeConClaveMensajeYTresParametrosDistintos() {
        Mensaje valor = new Mensaje();
        valor.setClaveMensaje("ClaveMensaje");
        valor.setParametros(Arrays.asList("Parametro 1 Distinto", "Parametro 2 Distinto", "Parametro 3 Distinto"));
        return valor;
    }
//</editor-fold>

}

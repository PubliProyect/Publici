/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vimso.padyu.api.to.gestionusuarios.out;

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
public class LoginUsuariosTOOutTest {
    
    public LoginUsuariosTOOutTest() {
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
     * Test of getRespuesta method, of class LoginUsuariosTOOut. (Constructor_Con_Respuesta)
     */
    @Test
    public void testConstructor_Con_Respuesta() {
        System.out.println("Constructor_Con_Respuesta");
        RespuestaComponentes res= new RespuestaComponentes("Clave del mensaje", true);
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut(res);
        RespuestaComponentes expResult = res;
        RespuestaComponentes result = instance.getRespuesta();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRespuesta method, of class LoginUsuariosTOOut. (Respuesta_VS_String)
     */
    @Test
    public void testRespuesta_VS_String() {
        System.out.println("Respuesta_VS_String");
        String cadena= "Clave del mensaje";
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut();
        Boolean expResult = false;
        Boolean result = instance.equals(cadena);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRespuesta method, of class LoginUsuariosTOOut. (Set y get Respuesta)
     */
    @Test
    public void testSet_Get_Respuesta() {
        System.out.println("Set_Get_Respuesta");
        RespuestaComponentes res= new RespuestaComponentes("Clave del mensaje", true);
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut();
        instance.setRespuesta(res);
        RespuestaComponentes expResult = res;
        RespuestaComponentes result = instance.getRespuesta();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class LoginUsuariosTOOut. (New_VS_Null)
     */
    @Test
    public void testEquals_New_VS_Null() {
        System.out.println("equals New_VS_Null");
        Object o = null;
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class LoginUsuariosTOOut. (New_VS_New)
     */
    @Test
    public void testEquals_New_VS_New() {
        System.out.println("equals New_VS_New");
        Object o = new LoginUsuariosTOOut();
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class LoginUsuariosTOOut.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut();
        int expResult = new LoginUsuariosTOOut().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class LoginUsuariosTOOut. (HashCode_Distintos)
     */
    @Test
    public void testHashCode_Distintos() {
        System.out.println("HashCode_Distintos");
        LoginUsuariosTOOut instance = new LoginUsuariosTOOut(new RespuestaComponentes("Clave del mensaje"));
        int expResult = new LoginUsuariosTOOut().hashCode();
        int result = instance.hashCode();
        assertNotSame(expResult, result);
    }    
}

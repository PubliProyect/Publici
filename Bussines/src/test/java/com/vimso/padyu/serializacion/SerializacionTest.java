package com.vimso.padyu.serializacion;

import com.vimso.padyu.api.to.gestionusuarios.in.LoginUsuariosTOIn;
import com.vimso.padyu.api.to.gestionusuarios.in.RegistroUsuarioTOIn;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author vimso
 */
public class SerializacionTest {

    @Test
    public void serializacionLoginUsuariosTOIn()
    {
        ObjectMapper mapper = new ObjectMapper();

        Assert.assertTrue(mapper.canSerialize(LoginUsuariosTOIn.class));
    }
    @Test
    public void serializacionRegistroUsuariosTOIn()
    {
        ObjectMapper mapper = new ObjectMapper();

        Assert.assertTrue(mapper.canSerialize(RegistroUsuarioTOIn.class));
    }
    
    @Test
    public void jsonFromRegistroUsuariosTOOut()
    {
        ObjectMapper mapper = new ObjectMapper();
        
        LoginUsuariosTOIn entrada = new LoginUsuariosTOIn();

        entrada.setMail("mso@gmail.com");
        entrada.setPassword("sadasdasd");

        try {
            System.out.println(mapper.writeValueAsString(entrada));
            mapper.writeValueAsString(entrada);
        } catch (IOException ex) {
            Logger.getLogger(SerializacionTest.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException();
        }
        
        try {
            mapper.generateJsonSchema(LoginUsuariosTOIn.class);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializacionTest.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException();
        }
        
    }
    
    @Test
    public void jsonFromRegistroUsuariosTOIn()
    {
        ObjectMapper mapper = new ObjectMapper();
        
        RegistroUsuarioTOIn entrada = new RegistroUsuarioTOIn();

        entrada.setNombre("Nombrecido");
        entrada.setLocale(new Locale("es", "ES"));
        entrada.setMail("mso@gmail.com");
        entrada.setPassword("sadasdasd");

        try {
            System.out.println(mapper.writeValueAsString(entrada));
            mapper.writeValueAsString(entrada);
        } catch (IOException ex) {
            Logger.getLogger(SerializacionTest.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException();
        }
        
        try {
            mapper.generateJsonSchema(LoginUsuariosTOIn.class);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializacionTest.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException();
        }
        
    }
    
    
        
//        LoginUsuariosTOIn entrada= new LoginUsuariosTOIn();
//        
//        entrada.setMail("mso@gmail.com");
//        entrada.setPassword("sadasdasd");
    
        
//        LoginUsuariosTOIn entrada= new LoginUsuariosTOIn();
//        
//        entrada.setMail("mso@gmail.com");
//        entrada.setPassword("sadasdasd");
//        
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.canSerialize(LoginUsuariosTOIn.class);
//        if (false) {
//            
//        }
//        
//        System.out.println("haz algo");
//    }
}

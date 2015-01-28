package com.vimso.utils.vimsoutils.comunicacion;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para encampsular los mensajes que se muestran al usuario, para su
 * internalización y parametrización
 *
 * @author vimso
 */
public class Mensaje implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Constantes de clase">
    public static final String VALOR_VACIO = "VALOR_VACIO";
    public static final String ROL_NOMBRE_CORTO = "ROL_NOMBRE_CORTO";
    public static final String MAIL_MAL_FORMATO = "EMAIL_MAL_FORMATO";
    public static final String NOMBRE_CARACTERES_MINIMOS = "NOMBRE_CARACTERES_MINIMOS";
    public static final String NOMBRE_EN_USO = "NOMBRE_EN_USO";
    public static final String MAIL_EN_USO = "MAIL_EN_USO";
    public static final String ROL_YA_EXISTENTE = "ROL_YA_EXISTENTE";
    public static final String PERMISO_NOMBRE_CORTO = "PERMISO_NOMBRE_CORTO";
    public static final String PERMISO_YA_EXISTENTE = "PERMISO_YA_EXISTENTE";
    public static final String ROL_NO_ENCONTRADO = "ROL_NO_ENCONTRADO";
    public static final String USUARIOS_INCORRECTOS = "USUARIOS_INCORRECTOS";
    public static final String ROL_INCORRECTO = "ROL_INCORRECTO";
    public static final String USUARIOS_INCORRECTO = "USUARIOS_INCORRECTO";
    public static final String CREDENCIALES_ERRONEAS = "CREDENCIALES_ERRONEAS";
    public static final String CREDENCIALES_CORRECTAS = "CREDENCIALES_CORRECTAS";
    public static final String PASSWORD_DIFERENTES = "PASSWORD_DIFERENTES";
    public static final String PASSWORD_CARACTERES_MINIMOS = "PASSWORD_CARACTERES_MINIMOS";
    public static final String MAIL_DIFERENTES = "MAIL_DIFERENTES";

    private String claveMensaje;
    private List<String> parametros;
//</editor-fold>

    public Mensaje(String claveMensaje, List<String> parametros) {
        this.claveMensaje = claveMensaje;
        this.parametros = parametros;
    }

    public Mensaje(String claveMensaje) {
        this.claveMensaje = claveMensaje;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos de clase">    
    public String getClaveMensaje() {
        return claveMensaje;
    }

    public void setClaveMensaje(String claveMensaje) {
        this.claveMensaje = claveMensaje;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }

    //</editor-fold>
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Mensaje)) {
            return false;
        }
        Mensaje mensajeExterno = (Mensaje) o;

        if (claveMensaje != null && mensajeExterno.getClaveMensaje() != null && !claveMensaje.equals(mensajeExterno.getClaveMensaje())) {
            return false;
        }

        return isMismoParametro(this, mensajeExterno);

    }

    private boolean isMismoParametro(Mensaje interno, Mensaje mensajeExterno) {
        if (mensajeExterno.getParametros() != null && interno.getParametros() != null) {
            return Arrays.equals(mensajeExterno.getParametros().toArray(), interno.getParametros().toArray());
        } else {
            return mensajeExterno.getParametros() == null && interno.getParametros() == null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(claveMensaje, parametros);
    }
}

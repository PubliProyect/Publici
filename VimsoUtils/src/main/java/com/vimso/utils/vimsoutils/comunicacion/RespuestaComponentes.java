package com.vimso.utils.vimsoutils.comunicacion;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vimso
 */
public class RespuestaComponentes extends RespuestaComponentesAbstrac implements Serializable {

    private List<Mensaje> mensajes = new ArrayList<Mensaje>();
    private Boolean ok;

    public RespuestaComponentes() {
        ok = true;
    }

    public RespuestaComponentes(Mensaje mensaje) {
        ok = false;
        mensajes.addAll(Arrays.asList(mensaje));
    }

    public RespuestaComponentes(String msg) {
        ok = false;
        mensajes.add(new Mensaje(msg));
    }

    public RespuestaComponentes(String msg, boolean valor) {
        ok = valor;
        mensajes.add(new Mensaje(msg));
    }

    public void addMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void setOK(boolean ok) {
        this.ok = ok;
    }

    public boolean isOK() {
        return ok;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public String obtenerClaveMensajes() {
        if (mensajes == null || mensajes.isEmpty()) {
            return null;
        }
        if (mensajes.size() > 1) {
            throw new IllegalStateException("Hay más de una clave mensaje");
        }
        return mensajes.get(0).getClaveMensaje();
    }

    public void addMensaje(String mensaje) {
        addMensaje(new Mensaje(mensaje));
    }

    public void addMensajeKO(String mensaje) {
        ok = false;
        addMensaje(new Mensaje(mensaje));
    }

    public void addMensaje(String mensaje, List<String> parametros) {
        addMensaje(new Mensaje(mensaje, parametros));
    }

    public void addMensaje(String mensaje, String parametro) {
        List<String> parametros = new ArrayList<String>();
        parametros.add(parametro);
        addMensaje(mensaje, parametros);
    }

    public void addMensajeKO(String mensaje, List<String> parametros) {
        ok = false;
        addMensaje(new Mensaje(mensaje, parametros));
    }

    public void addMensajeKO(String mensaje, String parametro) {
        ok = false;
        List<String> parametros = new ArrayList<String>();
        parametros.add(parametro);
        addMensaje(mensaje, parametros);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof RespuestaComponentes)) {
            return false;
        }

        RespuestaComponentes respuestaExterna = (RespuestaComponentes) o;

        if (ok != respuestaExterna.isOK()) {
            return false;
        }

        return isMensajesIguales(this, respuestaExterna);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mensajes);
    }

    private boolean isMensajesIguales(RespuestaComponentes respuestaInterna, RespuestaComponentes respuestaExterna) {
        if (respuestaExterna.getMensajes() != null && respuestaInterna.getMensajes() != null) {
            return Arrays.equals(respuestaExterna.getMensajes().toArray(), respuestaInterna.getMensajes().toArray());
        } else {
            return respuestaExterna.getMensajes() == null && respuestaInterna.getMensajes() == null;
        }
    }
}

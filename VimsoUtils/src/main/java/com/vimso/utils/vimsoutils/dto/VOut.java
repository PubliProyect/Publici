package com.vimso.utils.vimsoutils.dto;

import com.vimso.utils.vimsoutils.comunicacion.RespuestaComponentesPlana;
import java.io.Serializable;

/**
 *
 * @author vimso
 */
public class VOut implements Serializable {

    private RespuestaComponentesPlana resPlain;

    public VOut() {
    }

    public VOut(RespuestaComponentesPlana resPlain) {
        this.resPlain = resPlain;
    }

    public RespuestaComponentesPlana getResPlain() {
        return resPlain;
    }

    public void setResPlain(RespuestaComponentesPlana resPlain) {
        this.resPlain = resPlain;
    }

}

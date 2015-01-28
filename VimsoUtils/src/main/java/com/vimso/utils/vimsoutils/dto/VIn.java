package com.vimso.utils.vimsoutils.dto;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author vimso
 */
public class VIn implements Serializable{

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

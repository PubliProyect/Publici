package com.vimso.utils.vimsoutils.dto;

import java.io.Serializable;

/**
 *
 * @author vimso
 */
public class VInAuth extends VIn implements Serializable{
    
    private Object tokenAuth;

    public Object getTokenAuth() {
        return tokenAuth;
    }

    public void setTokenAuth(Object tokenAuth) {
        this.tokenAuth = tokenAuth;
    }

}

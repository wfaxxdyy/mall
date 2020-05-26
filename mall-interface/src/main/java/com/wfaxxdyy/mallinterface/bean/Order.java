package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;

public class Order implements Serializable {

    private int o_id;
    private String o_username;
    private String o_tel;
    private String o_street;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_username() {
        return o_username;
    }

    public void setO_username(String o_username) {
        this.o_username = o_username;
    }

    public String getO_tel() {
        return o_tel;
    }

    public void setO_tel(String o_tel) {
        this.o_tel = o_tel;
    }

    public String getO_street() {
        return o_street;
    }

    public void setO_street(String o_street) {
        this.o_street = o_street;
    }
}

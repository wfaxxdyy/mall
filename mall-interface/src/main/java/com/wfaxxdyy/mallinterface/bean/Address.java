package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;

public class Address implements Serializable {

    private String a_id;
    private String a_username;
    private String a_tel;
    private String a_street;
    private boolean a_default;


    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getA_username() {
        return a_username;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public String getA_tel() {
        return a_tel;
    }

    public void setA_tel(String a_tel) {
        this.a_tel = a_tel;
    }

    public String getA_street() {
        return a_street;
    }

    public void setA_street(String a_street) {
        this.a_street = a_street;
    }

    public boolean isA_default() {
        return a_default;
    }

    public void setA_default(boolean a_default) {
        this.a_default = a_default;
    }
}

package br.com.agendaaulaapp.service;

/**
 * User:{"msg":"Usuario e senha não confere!!!","auth":"false"}
 */
public class Message {

    private String msg;
    private boolean auth;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }


}

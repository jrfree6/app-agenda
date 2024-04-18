package br.com.agendaaulaapp.service;

import android.util.Log;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Service {

    private String url = "http://192.168.0.103:8080/app-agenda/api";
    private Client clientJersey = null;
    private WebResource resource = null;
    public Service(){
        clientJersey = Client.create();
        resource = clientJersey.resource(url);
    }

    /**
     * @param path {path do endpoint}
     * @return devolve o json da requisicao.
     */
    public String Post(String path, Object object){

        Gson gson = new Gson();
        String json =gson.toJson(object);
//        WebResource resource = clientJersey.resource(url);

        Log.i(null, "JSON:" + json);
        String resposta = resource.path(path)
                .header("Content-Type","application/json")
                .post(String.class, json);
        Log.i(null, "Saida User:" + resposta);
        return resposta;
    }

    /**
     * @param path {path do endpoint}
     * @return devolve o json da requisicao.
     */
    public String Get(String path){

//        WebResource resource = clientJersey.resource(url);
        String resposta = resource.path(path)
                .header("Content-Type","application/json")
                .get(String.class);
        Log.i(null, "Saida:" + resposta);

        return resposta;

    }

}

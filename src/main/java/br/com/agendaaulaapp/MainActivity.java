package br.com.agendaaulaapp;

import static android.os.StrictMode.*;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

import br.com.agendaaulaapp.service.Message;
import br.com.agendaaulaapp.service.Service;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
        setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        initialize();
//        username.setText("name is bob.");
        Log.i(null, "opa cheguei aqui- batata frita...");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Hello World!!!:" + username.getText());
                efetuaLogin();
            }

        });

    }
    public void efetuaLogin(){
        Service service = new Service();
        HashMap<String, String> req = new HashMap<>();
        req.put("username", username.getText().toString());
        req.put("password", password.getText().toString());
        String ret = service.Post("/login", req);
        Gson gson = new Gson();
        Message msg = gson.fromJson(ret, Message.class);

        if(msg.getAuth()){
            Log.i(null, "Login Autorizado - Prox Tela" + msg.getMsg());
            Intent intent = new Intent(this, ContactListView.class);
            startActivity(intent);
        }else{
            Log.i(null, "Login Nao Autorizado." + msg.getMsg());
        }

    }
    public void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void initialize(){
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        btnLogin = findViewById(R.id.login_btn);
    }

    public void chamaApi(){

        OkHttpClient client = new OkHttpClient();

        String url = "http://192.168.0.103:8080/app-agenda/api";
        Gson gson = new Gson();

        try {
//            Request getRequest = new Request.Builder().url(url+"/getAllUsers").get().build();
//            Response response = client.newCall(getRequest).execute();
//            ResponseBody respondeBody = response.body();
//            if(respondeBody !=null){
//                List<UserEntity> list = (List<UserEntity>) respondeBody;
//                Log.i(null, "OUT1:" + list.get(1).getUsername());
//            }

            /**
             *  Metodo GET
             */
            Client clientJersey = Client.create();
            WebResource resource = clientJersey.resource(url);
            String resposta = resource.path("getAllUsers")
                    .header("Content-Type","application/json")
                    .get(String.class);
            Log.i(null, "Saida:" + resposta);
            UserEntity[] usuarioslist =  gson.fromJson(resposta, UserEntity[].class);
            for (UserEntity values : usuarioslist) {
                Log.i(null, "Usuario:" + values.getUsername());
            }

            /**
             * Metodo POST
             * */
            UserEntity newUser = new UserEntity();
            newUser.setId(2l);
            newUser.setPassword("123456");
            newUser.setUsername("bobsponja");


            String json =gson.toJson(newUser);
            Log.i(null, "JSON:" + json);
            resposta = resource.path("addUsers")
                    .header("Content-Type","application/json")
                    .post(String.class, json);
            Log.i(null, "Saida User:" + resposta);


//            Future<String> algo = clientJersey.asyncResource(url).header("Content-Type", "Application/json").get(String.class);

//
//            client.newCall(getRequest).enqueue(new Callback() {
//                @Override
//                public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                    if(response.isSuccessful() && response.body() != null){
//                        ResponseBody responseData = response.body();
//                        Log.i(null,"Res OUT:" + responseData.toString());
//                    }
//                }
//            });

        } catch(Exception e){
            Log.i(null, "Erro na chamada do webservice." + e.getMessage());
        }




    }



}














/*


  public void acessoApi(){

        try {

            String urlBase = "http://192.168.37.26:8080/app-agenda/api/getAllUsers";
//            String urlBase = "https://api.chucknorris.io/jokes/random";
            OkHttpClient client = new OkHttpClient();

            Request getRequest = new Request.Builder()
                    .url(urlBase)
                    //.addHeader("Content-type","application/json")
                    //.get()
                    .build();
            Response response = client.newCall(getRequest).execute();

//            client.newCall(getRequest).enqueue(new Callback() {
//
//                @Override
//                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                    if(response.isSuccessful() && response.body() != null){
////                        String responseData = response.body().toString();
//                        Gson gson = new Gson();
//                        Object res = response.body();
//                        String json = gson.toJson(res);
//                        Log.i(null, "OUT:"+ json);
//                    }
//                }
//                @Override
//                public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                    Log.i(null, "Falha na chamada.");
//                }
//
//            });


        }catch(Exception e){
            e.printStackTrace();
        }
    }
 */
package br.com.agendaaulaapp;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.agendaaulaapp.service.Service;

public class ContactListView extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_listview);

        ListView lw = findViewById(R.id.listview);
        ArrayAdapter<ContactEntity> adapter = new ArrayAdapter<ContactEntity>(this,
                                                    android.R.layout.simple_list_item_1, findContacts());
        lw.setAdapter(adapter);
    }

    public  ArrayList<ContactEntity> findContacts(){
        Service service = new Service();
        Gson gson = new Gson();
        String json = service.Get("getAllContacts");
        ContactEntity[] list = gson.fromJson(json, ContactEntity[].class);
        return new ArrayList<>(Arrays.asList(list));

    }

}

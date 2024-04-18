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

public class ContactListView extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_listview);
//        ListView listview = (ListView) findViewById(R.id.listview);

        String[] dados = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
                "Honeycomb", "Ice Cream Sandwich", "Jelly Bean",
                "KitKat", "Lollipop", "Marshmallow", "Nougat" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.contact_listview, dados);
        //new ArrayAdapter<String>(this,R.layout.ListView,R.id.textView,StringArray);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.contact_listview,R.id.textView,dados);
//        adapter.addAll(dados);
//        listview.setAdapter(adapter);

    }

}

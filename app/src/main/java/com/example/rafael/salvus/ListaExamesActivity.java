package com.example.rafael.salvus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dominio.Exame;
import dominio.Medico;
import utils.DataUtils;

public class ListaExamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_exames);
        setTitle("Exames");

        ListView examesListView = findViewById(R.id.listaExamesListView);

        final List<Exame> exames = DataUtils.getExames();

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < exames.size(); i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("data", exames.get(i).getData());
            item.put("tipo", exames.get(i).getTipo());
            list.add(item);
        }

        String[] from = new String[] { "tipo", "data" };
        int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

        //layout nativo android de dois itens
        int layoutNativo = android.R.layout.two_line_list_item;

        //atribuindo adaptador com a lista e o layout na ListActivity
        examesListView.setAdapter(new SimpleAdapter(this, list, layoutNativo, from, to));

        examesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ExameActivity.class);
                i.putExtra("exame", exames.get(position));
                startActivity(i);
            }
        });
    }
}


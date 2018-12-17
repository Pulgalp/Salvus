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

import dominio.Consulta;
import dominio.Medico;
import utils.DataUtils;

public class ListaConsultasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consultas);
        setTitle("Consultas");

        ListView consultasListView = findViewById(R.id.consultasListView);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        final List<Consulta> consultas = DataUtils.getConsultas();
        for (int i = 0; i < consultas.size(); i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("medico", consultas.get(i).getMedico().getNome() + " (" + consultas.get(i).getMedico().getEspecialidade() + ")");
            item.put("data", consultas.get(i).getData());
            list.add(item);
        }

        String[] from = new String[] { "medico", "data" };
        int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

        //layout nativo android de dois itens
        int layoutNativo = android.R.layout.two_line_list_item;

        //atribuindo adaptador com a lista e o layout na ListActivity
        consultasListView.setAdapter(new SimpleAdapter(this, list, layoutNativo, from, to));

        consultasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ConsultaActivity.class);
                i.putExtra("consulta", consultas.get(position));
                startActivity(i);
            }
        });
    }
}

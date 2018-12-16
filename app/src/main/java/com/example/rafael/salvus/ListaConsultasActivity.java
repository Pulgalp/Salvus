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

import dominio.Consulta;
import dominio.Medico;

public class ListaConsultasActivity extends AppCompatActivity {


    private ListView consultasListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consultas);
        setTitle("Consultas");

        consultasListView = findViewById(R.id.consultasListView);

        final ArrayList<Consulta> consultas = new ArrayList<>();
        consultas.add(new Consulta(1,
                "Paciente está bem, mas insiste em refazer o exame por sentir dores e um incômodo na próstata",
                "06/12/2018",
                new Medico(1,
                        "Teobaldo Leopoldo Costa Limpa",
                        "Cancer de próstata")
        ));

        consultas.add(new Consulta(2,
                "Paciente disse que não ia tomar glicose pq já tinha tomado demais durante o dia",
                "03/12/2018",
                new Medico(2,
                        "Leopoldo Manoel da Rocha",
                        "Gastrointestinal")));

        consultas.add(new Consulta(3,
                "Paciente não conseguia se equilibrar, mas ainda sim sem dores muito fortes",
                "01/12/2018",
                new Medico(3,
                        "Roberlei Anacleto Tora",
                        "Fisioterapeuta")));

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();


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

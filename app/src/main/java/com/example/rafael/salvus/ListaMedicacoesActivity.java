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

import dominio.Medicacao;
import dominio.Medico;
import utils.DataUtils;

public class ListaMedicacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicacoes);
        setTitle("Medicacoes");

        ListView medicacoesListView = findViewById(R.id.listaMedicacoesListView);

        final List<Medicacao> medicacoes = DataUtils.getMedicacoes();

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < medicacoes.size(); i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("medicamento", medicacoes.get(i).getNome());
            item.put("data", medicacoes.get(i).getData());
            list.add(item);
        }

        String[] from = new String[] { "medicamento", "data" };
        int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

        //layout nativo android de dois itens
        int layoutNativo = android.R.layout.two_line_list_item;

        //atribuindo adaptador com a lista e o layout na ListActivity
        medicacoesListView.setAdapter(new SimpleAdapter(this, list, layoutNativo, from, to));

        medicacoesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MedicacoesActivity.class);
                i.putExtra("medicacao", medicacoes.get(position));
                startActivity(i);

            }
        });
    }
}

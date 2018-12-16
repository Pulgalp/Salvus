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

import dominio.Medicacao;
import dominio.Medico;

public class ListaMedicacoesActivity extends AppCompatActivity {

    private ListView medicacoesListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicacoes);
        setTitle("Medicacoes");

        medicacoesListView = findViewById(R.id.listaMedicacoesListView);

        final ArrayList<Medicacao> medicacoes = new ArrayList<>();

        medicacoes.add(new Medicacao(
                1,
                "01/12/2018",
                new Medico(1,
                        "Teobaldo Leopoldo Costa Limpa",
                        "Cancer de próstata"),
                "Paracetamol"
        ));

        medicacoes.add(new Medicacao(
                2,
                "02/12/2018",
                new Medico(2,
                        "Leopoldo Manoel da Rocha",
                        "Gastrointestinal"),
                "Engov"
        ));

        medicacoes.add(new Medicacao(
                3,
                "03/12/2018",
                new Medico(3,
                        "Roberlei Anacleto Tora",
                        "Fisioterapeuta"),
                "Anti inflamatório"
        ));

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

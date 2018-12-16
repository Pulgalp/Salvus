package com.example.rafael.salvus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import dominio.Paciente;
import ferramentas.HttpUrlConnector;

public class OpcoesPacienteActivity extends AppCompatActivity {

    private ListView opcoesListView;
    private String xml;
    private Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_paciente);

        final String token = (String) getIntent().getSerializableExtra("token");
//        Log.i("token", token);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    xml = HttpUrlConnector.sendGet("pacientes/DU/" + token);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//        try {
//            t.join();
//            paciente = new Paciente(xml);
//            setTitle(paciente.getNome());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        opcoesListView = findViewById(R.id.opcoesListView);

        //inserindo os dados dos clientes na lista
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("nome", "Informacoes");
        list.add(item);
        HashMap<String, String> item2 = new HashMap<String, String>();
        item2.put("nome", "Consultas");
        list.add(item2);
        HashMap<String, String> item3 = new HashMap<String, String>();
        item3.put("nome", "Medicacoes");
        list.add(item3);
        HashMap<String, String> item4 = new HashMap<String, String>();
        item4.put("nome", "Exames");
        list.add(item4);

        String[] from = new String[] { "nome" };
        int[] to = new int[] { android.R.id.text1 };

        //layout nativo android de dois itens
        int layoutNativo = android.R.layout.simple_list_item_1;

        //atribuindo adaptador com a lista e o layout na ListActivity
        opcoesListView.setAdapter(new SimpleAdapter(this, list, layoutNativo, from, to));

        opcoesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(getApplicationContext(), InfoPacienteActivity.class);
                        i.putExtra("paciente", paciente);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i2 = new Intent(getApplicationContext(), ListaConsultasActivity.class);
//                        i2.putExtra("consultas", paciente.getConsultas());
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i4 = new Intent(getApplicationContext(), ListaMedicacoesActivity.class);
//                        i4.putExtra("medicacoes", paciente.getMedicacoes());
                        startActivity(i4);
                        break;
                    case 3:
                        Intent i3 = new Intent(getApplicationContext(), ListaExamesActivity.class);
//                        i3.putExtra("exames", paciente.getExames());
                        startActivity(i3);
                        break;
                }

            }
        });
    }
}

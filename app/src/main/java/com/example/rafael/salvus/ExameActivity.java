package com.example.rafael.salvus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dominio.Exame;

public class ExameActivity extends AppCompatActivity {

    private Exame exame;
    private TextView idExameTextView;
    private TextView tipoExameTextView;
    private TextView dataConsultaTextView;
    private TextView nomeMedicoConsultaTextView;
    private TextView laudoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);

        idExameTextView = findViewById(R.id.idExameTextView);
        tipoExameTextView = findViewById(R.id.tipoExameTextView);
        dataConsultaTextView = findViewById(R.id.dataConsultaTextView);
        nomeMedicoConsultaTextView = findViewById(R.id.nomeMedicoConsultaTextView);
        laudoTextView = findViewById(R.id.laudoTextView);

        exame = (Exame) getIntent().getSerializableExtra("exame");

        this.setTitle("Dados do Exame");

        idExameTextView.setText(String.valueOf(exame.getId()));
        tipoExameTextView.setText(exame.getTipo());
        dataConsultaTextView.setText(exame.getData());
        nomeMedicoConsultaTextView.setText(exame.getMedico().getNome());
        laudoTextView.setText(exame.getLaudo());

    }
}
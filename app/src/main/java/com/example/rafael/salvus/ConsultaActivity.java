package com.example.rafael.salvus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dominio.Consulta;
import dominio.Paciente;

public class ConsultaActivity extends AppCompatActivity {

    private Consulta consulta;
    private TextView idConsultaTextView;
    private TextView dataConsultaTextView;
    private TextView nomeMedicoConsultaTextView;
    private TextView especialidadeMedicoConsultaTextView;
    private TextView avaliacaoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);


        idConsultaTextView = findViewById(R.id.idConsultaTextView);
        dataConsultaTextView = findViewById(R.id.dataConsultaTextView);
        nomeMedicoConsultaTextView = findViewById(R.id.nomeMedicoConsultaTextView);
        especialidadeMedicoConsultaTextView = findViewById(R.id.especialidadeMedicoConsultaTextView);
        avaliacaoTextView = findViewById(R.id.avaliacaoTextView);

        consulta = (Consulta)getIntent().getSerializableExtra("consulta");

        this.setTitle("Dados da Consulta");

        idConsultaTextView.setText(String.valueOf(consulta.getId()));
        dataConsultaTextView.setText(consulta.getData());
        nomeMedicoConsultaTextView.setText(consulta.getMedico().getNome());
        especialidadeMedicoConsultaTextView.setText(consulta.getMedico().getEspecialidade());
        avaliacaoTextView.setText(consulta.getAvaliacao());

    }
}

package com.example.rafael.salvus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dominio.Paciente;

public class InfoPacienteActivity extends AppCompatActivity {

    private Paciente paciente;
    private TextView idPacienteTextView;
    private TextView nomeTextView;
    private TextView cpfTextView;
    private TextView contatoTextView;
    private TextView alergiasTextView;
    private TextView tipoSanguineoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paciente);

        idPacienteTextView = findViewById(R.id.idPacienteTextView);
        nomeTextView = findViewById(R.id.nomeTextView);
        cpfTextView = findViewById(R.id.cpfTextView);
        contatoTextView = findViewById(R.id.contatoTextView);
        alergiasTextView = findViewById(R.id.alergiasTextView);
        tipoSanguineoTextView = findViewById(R.id.tipoSanguineoTextView);

        paciente = new Paciente(123,
                "777.187.629-39",
                "Carlos Alberto Barbosa",
                "+55 (11) 99999-9999",
                "Penicilina, Eritromicina, Amoxicilina, Ampicilina ou Tetraciclina",
                "O+");

        this.setTitle("Dados do Paciente");

        idPacienteTextView.setText(String.valueOf(paciente.getId()));
        nomeTextView.setText(paciente.getNome());
        cpfTextView.setText(paciente.getCpf());
        contatoTextView.setText(paciente.getContato());
        alergiasTextView.setText(paciente.getAlergias());
        tipoSanguineoTextView.setText(paciente.getTiposang());
    }
}

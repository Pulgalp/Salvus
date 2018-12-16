package com.example.rafael.salvus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dominio.Medicacao;

public class MedicacoesActivity extends AppCompatActivity {

    private Medicacao medicacao;
    private TextView dataMedicamentoTextView;
    private TextView nomeMedicamentoTextView;
    private TextView idMedicamentoTextView;
    private TextView nomeMedicoMedicamentoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicacoes);

        dataMedicamentoTextView = findViewById(R.id.dataMedicamentoTextView);
        nomeMedicamentoTextView = findViewById(R.id.nomeMedicamentoTextView);
        idMedicamentoTextView = findViewById(R.id.idMedicacaoTextView);
        nomeMedicoMedicamentoTextView = findViewById(R.id.nomeMedicoMedicamentoTextView);

        medicacao = (Medicacao) getIntent().getSerializableExtra("medicacao");

        this.setTitle("Dados da Medicacao");

        idMedicamentoTextView.setText(String.valueOf(medicacao.getId()));
        nomeMedicamentoTextView.setText(medicacao.getNome());
        dataMedicamentoTextView.setText(medicacao.getData());
        nomeMedicoMedicamentoTextView.setText(medicacao.getMedico().getNome());

    }

}
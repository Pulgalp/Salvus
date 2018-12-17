package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dominio.Consulta;
import dominio.Exame;
import dominio.Medicacao;
import dominio.Medico;

public final class DataUtils {

    private DataUtils() {
    }

    public static List<Medico> getMedicos() {
        Medico medico1 = new Medico(1,
                "Carlos da Silva Lacaz",
                "Neurocirurgião");
        Medico medico2 = new Medico(2,
                "Roberto Matias da Rocha",
                "Gastrointestinal");
        Medico medico3 = new Medico(3,
                "Oswaldo Cruz",
                "Fisioterapeuta");
        return Arrays.asList(medico1, medico2, medico3);
    }

    public static List<Consulta> getConsultas() {
        Consulta consulta1 = new Consulta(1,
                "Paciente sente dores na parte posterior do crânio, tonturas e breve perda de visão.",
                "06/12/2018",
                getMedicos().get(0));
        Consulta consulta2 = new Consulta(2,
                "Paciente apresenta sinais de infecção alimentar, dores fortes e ânsia de vômito",
                "03/12/2018",
                getMedicos().get(1));
        Consulta consulta3 = new Consulta(3,
                "Paciente não conseguia se equilibrar em uma das pernas, mas ainda sim sem dores muito fortes",
                "01/12/2018",
                getMedicos().get(2));
        return Arrays.asList(consulta1, consulta2, consulta3);
    }

    public static List<Exame> getExames() {
        List<Exame> exames = new ArrayList<>();

        List<Medico> medicos = DataUtils.getMedicos();
        exames.add(new Exame(1,
                "01/02/2018",
                "Atesto para os devidos fins de direito que o(a) Sr.(a) Carlos Rafael Pulga é portador da deficiência espécie Código Internacional de Doença (CID10) 87,  possuindo o seguinte grau/nível de deficiência ALTA, sendo a causa desta deficiência GENÉTICA, possuindo o(a) candidato(a) o seguinte nível de autonomia REGULAR.",
                medicos.get(0),
                "Atestado")
        );

        exames.add(new Exame(2,
                "02/02/2018",
                "Atesto para os devidos fins de direito que o(a) Sr.(a) Carlos Rafael Pulga é portador da deficiência espécie Código Internacional de Doença (CID10) 35,  possuindo o seguinte grau/nível de deficiência MEDIA, sendo a causa desta deficiência GENÉTICA, possuindo o(a) candidato(a) o seguinte nível de autonomia ALTA.",
                medicos.get(1),
                "Laudo de exame")
        );

        exames.add(new Exame(3,
                "03/02/2018",
                "Atesto para os devidos fins de direito que o(a) Sr.(a) Carlos Rafael Pulga é portador da deficiência espécie Código Internacional de Doença (CID10) 20,  possuindo o seguinte grau/nível de deficiência BAIXA, sendo a causa desta deficiência CONTAMINAÇÃO, possuindo o(a) candidato(a) o seguinte nível de autonomia BAIXA.",
                medicos.get(2),
                "Laudo de consulta")
        );

        return exames;
    }

    public static List<Medicacao> getMedicacoes() {
        final ArrayList<Medicacao> medicacoes = new ArrayList<>();
        List<Medico> medicos = DataUtils.getMedicos();

        medicacoes.add(new Medicacao(
                1,
                "01/12/2018",
                medicos.get(0),
                "Paracetamol"
        ));

        medicacoes.add(new Medicacao(
                2,
                "02/12/2018",
                medicos.get(1),
                "Engov"
        ));

        medicacoes.add(new Medicacao(
                3,
                "03/12/2018",
                medicos.get(2),
                "Anti inflamatório"
        ));
        return medicacoes;
    }
}
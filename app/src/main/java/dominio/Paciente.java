package dominio;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.util.ArrayList;

import ferramentas.XMLParser;

public class Paciente implements Serializable {

	private int id;
	private String cpf, nome, contato, alergias, tiposang;
	private ArrayList<Consulta> consultas;
	private ArrayList<Exame> exames;
	private ArrayList<Medicacao> medicacoes;

	public Paciente(int id, String cpf, String nome, String contato, String alergias, String tiposang) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.alergias = alergias;
		this.tiposang = tiposang;
	}

	public Paciente(int id, String cpf, String nome, String contato, String alergias, String tiposang,
			ArrayList<Consulta> consultas, ArrayList<Exame> exames, ArrayList<Medicacao> medicacoes) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.alergias = alergias;
		this.tiposang = tiposang;
		this.consultas = consultas;
		this.exames = exames;
		this.medicacoes = medicacoes;
	}



	public ArrayList<Exame> getExames() {
		return exames;
	}



	public void setExames(ArrayList<Exame> exames) {
		this.exames = exames;
	}



	public ArrayList<Medicacao> getMedicacoes() {
		return medicacoes;
	}



	public void setMedicacoes(ArrayList<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getContato() {
		return contato;
	}



	public void setContato(String contato) {
		this.contato = contato;
	}



	public String getAlergias() {
		return alergias;
	}



	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}



	public String getTiposang() {
		return tiposang;
	}



	public void setTiposang(String tiposang) {
		this.tiposang = tiposang;
	}



	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}



	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}



	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(String xml){

		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml); // getting DOM element

		//atribuindo cadastro do Paciente
		NodeList cadastroNL = doc.getElementsByTagName("Paciente");
		Element e = (Element) cadastroNL.item(0);

		//Informações Paciente
		this.id = Integer.parseInt(parser.getValue(e, "id"));
		this.nome = parser.getValue(e, "nome");
		this.cpf = parser.getValue(e, "cpf");
		this.contato = parser.getValue(e, "contato");
		this.alergias = parser.getValue(e, "alergias");
		this.tiposang = parser.getValue(e, "tiposang");

		for(int i=0; i<cadastroNL.getLength(); i++){
			Element tagUser = (Element) cadastroNL.item( i );

			//Consultas
			NodeList consultaNL = tagUser.getElementsByTagName("Consulta");
			ArrayList<Consulta> consultasNovas = new ArrayList<>();
			for(int j=0; j<consultaNL.getLength(); j++){
				Element e1 = (Element) consultaNL.item(j);

				Consulta nova = new Consulta(Integer.parseInt(parser.getValue(e1, "id")),
						parser.getValue(e1, "avaliacao"), parser.getValue(e1, "data"),
						new Medico(parser.getValue(e1, "medico"), parser.getValue(e1, "especialidade")));

				consultasNovas.add(nova);
			}
			this.consultas = consultasNovas;

			//Exames
			NodeList exameNL = tagUser.getElementsByTagName("Exame");
			ArrayList<Exame> exameNovas = new ArrayList<>();
			for(int j=0; j<exameNL.getLength(); j++){
				Element e1 = (Element) exameNL.item(j);

				Exame nova = new Exame(Integer.parseInt(parser.getValue(e1, "id")),parser.getValue(e1, "data"), parser.getValue(e1, "laudo"),
						new Medico(parser.getValue(e1, "medico"), parser.getValue(e1, "especialidade")), parser.getValue(e1, "tipo"));

				exameNovas.add(nova);
			}
			this.exames = exameNovas;

			//Medicações
			NodeList medicacoesNL = tagUser.getElementsByTagName("Medicacao");
			ArrayList<Medicacao> medicacoesNovas = new ArrayList<>();
			for(int j=0; j<medicacoesNL.getLength(); j++){
				Element e1 = (Element) medicacoesNL.item(j);

				Medicacao nova = new Medicacao(Integer.parseInt(parser.getValue(e1, "id")),parser.getValue(e1, "data"),
						new Medico(parser.getValue(e1, "medico"), parser.getValue(e1, "especialidade")), parser.getValue(e1, "nome"));

				medicacoesNovas.add(nova);
			}
			this.medicacoes = medicacoesNovas;
		}
	}

}

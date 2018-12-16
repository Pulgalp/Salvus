package dominio;


import java.io.Serializable;

public class Medicacao implements Serializable {

	private int id;
	private String data;
	private Medico medico;
	private String nome;
	
	


	public Medicacao(int id, String data, Medico medico, String nome) {
		super();
		this.id = id;
		this.data = data;
		this.medico = medico;
		this.nome = nome;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public Medicacao() {
		// TODO Auto-generated constructor stub
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

}

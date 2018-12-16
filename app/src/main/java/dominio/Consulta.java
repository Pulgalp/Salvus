package dominio;

import java.io.Serializable;

public class Consulta implements Serializable {

	private int id;
	private String avaliacao;
	private String data;
	private Medico medico;
	
	public Consulta(int id, String avaliacao, String data, Medico medico) {
		super();
		this.id = id;
		this.avaliacao = avaliacao;
		this.data = data;
		this.medico = medico;
	}

	
	
	public Consulta(int id, String data, Medico medico) {
		super();
		this.id = id;
		this.data = data;
		this.medico = medico;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
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

	public Consulta() {
		// TODO Auto-generated constructor stub
	}

}

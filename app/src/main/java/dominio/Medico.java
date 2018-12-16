package dominio;

import java.io.Serializable;

public class Medico implements Serializable {

	private int id;
	private String nome;
	private String especialidade;
	
	public Medico(int id, String nome, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Medico(String nome, String especialidade) {
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Medico() {
		// TODO Auto-generated constructor stub
	}

}

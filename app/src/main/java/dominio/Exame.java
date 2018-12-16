package dominio;

import java.io.Serializable;

public class Exame implements Serializable {

private int id;
private String data;
private String laudo;
private Medico medico;
private String tipo;

	public Exame(int id, String data, String laudo, Medico medico, String tipo) {
		this.id = id;
		this.data = data;
		this.laudo = laudo;
		this.medico = medico;
		this.tipo = tipo;
	}

	public Medico getMedico() {
	return medico;
}




public void setMedico(Medico medico) {
	this.medico = medico;
}




	public Exame(int id, String data, String laudo) {
	super();
	this.id = id;
	this.data = data;
	this.laudo = laudo;
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




public String getLaudo() {
	return laudo;
}




public void setLaudo(String laudo) {
	this.laudo = laudo;
}




	public Exame() {
		// TODO Auto-generated constructor stub
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

package dominio;

import java.io.Serializable;

import javax.crypto.SecretKey;

public class Etiqueta implements Serializable {
	private String idEtiqueta;
	private SecretKey k;
	private byte[] iv;
	private int ctr;

	
	
	public Etiqueta(String idEtiqueta, SecretKey k, byte[] iv, int ctr) {
		super();
		this.idEtiqueta = idEtiqueta;
		this.k = k;
		this.iv = iv;
		this.ctr = ctr;
	}
	public String getIdEtiqueta() {
		return idEtiqueta;
	}
	public void setIdEtiqueta(String idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}
	public SecretKey getK() {
		return k;
	}
	public void setK(SecretKey k) {
		this.k = k;
	}
	public byte[] getIv() {
		return iv;
	}
	public void setIv(byte[] iv) {
		this.iv = iv;
	}
	public int getCtr() {
		return ctr;
	}
	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
	
	
	
	
	}

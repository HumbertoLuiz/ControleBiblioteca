package br.edu.ifpr.entidades;

import java.util.UUID;

public class Autor {
	private String id;
	private String nomeAutor;	
	
	public Autor(String id, String nome, String nomeAutor) {
		this.id = UUID.randomUUID().toString();
		this.nomeAutor = nomeAutor;
	}

	public Autor() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
}

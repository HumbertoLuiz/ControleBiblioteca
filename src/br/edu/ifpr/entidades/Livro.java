package br.edu.ifpr.entidades;

import java.util.Date;
import java.util.UUID;

public class Livro{
	
	private String id;
	private String nomeLivro;
	private Date dataCriacao;
	private StatusLivro status;
	private Autor autor;
	
	public Livro() {
		this.id = UUID.randomUUID().toString();
		this.dataCriacao = new Date();
		this.status = StatusLivro.DISPONIVEL;
		this.autor = new Autor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusLivro getStatus() {
		return status;
	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}

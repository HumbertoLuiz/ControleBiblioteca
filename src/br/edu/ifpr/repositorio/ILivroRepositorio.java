package br.edu.ifpr.repositorio;

import java.util.List;

import br.edu.ifpr.entidades.Livro;

public interface ILivroRepositorio {
	
	public List<Livro> buscarTodas();
	
	public Livro buscarPorId(String id);
	
	public Livro cadastrar(Livro livro);
	
	public void alterarStatus(String id, String status) throws IllegalArgumentException;

	public void excluir(String id);
}

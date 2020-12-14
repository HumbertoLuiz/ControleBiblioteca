package br.edu.ifpr.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.entidades.StatusLivro;

public class LivroRepositorioMemoria implements ILivroRepositorio {
	
	private static List<Livro> livros = new ArrayList<Livro>();


	@Override
	public List<Livro> buscarTodas() {
		return livros;
	}
	

	@Override
	public Livro buscarPorId(String id) throws IllegalArgumentException {
		
		for (Livro livro : livros) {
			if(id.equals(livro.getId())) {
				return livro;
			}
		}
		
		throw new IllegalArgumentException("id inexistente");
	}

	@Override
	public Livro cadastrar(Livro livro) throws IllegalArgumentException {
		
		if(livro.getNomeLivro() == null || livro.getNomeLivro().isEmpty()) {
			
			throw new IllegalArgumentException("O nome do Livro nao pode ser vazio");
			
		} else if(livro.getNomeLivro().length()  < 3) {
			
			throw new IllegalArgumentException("O nome do Livro nao pode ter menos que 3 caracteres");
		
		}
		
		livros.add(livro);
		
		return livro;
	}

	
	public void alterarStatus(String id, String status) throws IllegalArgumentException {
		
		Livro livro = this.buscarPorId(id);
		
		switch(status) {
			case "disponivel":
				livro.setStatus(StatusLivro.DISPONIVEL);
				break;
			
			case "emprestado":
				livro.setStatus(StatusLivro.EMPRESATADO);
				break;
				
			default:
				throw new IllegalArgumentException("Status inválido");
		}
	}

	public void excluir(String id) {
		
		for (int index = 0; index < livros.size(); index++) {
			
			Livro livro = livros.get(index);
			
			if(livro.getId().equals(id)) {
				livros.remove(index);
			}
			
		}
		
		//Validacao
		//throw Exception(...)
		
	}

}

package br.edu.ifpr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.repositorio.ILivroRepositorio;
import br.edu.ifpr.repositorio.LivroRepositorioMemoria;

@WebServlet("/livros/cadastrar")
public class CadastrarLivroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String nomeLivro = req.getParameter("inputNomeLivro");
			String nomeAutor = req.getParameter("inputNomeAutor");
			
			Livro livro = new Livro();
			livro.setNomeLivro(nomeLivro);
			livro.getAutor().setNomeAutor(nomeAutor);
			
			repositorio.cadastrar(livro);
			resp.sendRedirect("/app");
		
		} catch(IllegalArgumentException e) {
						
			req.setAttribute("erros", e.getMessage());
			RequestDispatcher disp = req.getRequestDispatcher("/app");
			disp.forward(req, resp);
		}
	}
}

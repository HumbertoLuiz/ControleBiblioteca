package br.edu.ifpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.repositorio.ILivroRepositorio;
import br.edu.ifpr.repositorio.LivroRepositorioMemoria;

@WebServlet("/livros/alterar-status")
public class AlterarStatusLivroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = req.getParameter("status");
		
		repositorio.alterarStatus(id, status);
		
		resp.sendRedirect("/app");
	}

}

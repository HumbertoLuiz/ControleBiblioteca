<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpr.entidades.Livro"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

</head>
<body>

	<%
		List<Livro> listaLivrosJSP = new ArrayList<Livro>();
		
			if(request.getAttribute("listaLivros") != null){
		listaLivrosJSP = (List<Livro>) request.getAttribute("listaLivros");
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			
			String mensagemErro = (String) request.getAttribute("erros");
	%>

	<div class="container">

		<h2>Lista de Livros</h2>
		
		<form action="/app/livros/cadastrar" method="post" class="form-inline mt-4 mb-4">
		
		<h6 style="margin-left:10px">Livro</h6>
			<input style="margin-left:10px" class="form-control mb-1 mr-sm-1 " type="text" name="inputNomeLivro" />
			
		<h6 style="margin-left:10px">Autor</h6>
			<input style="margin-left:10px" class="form-control mb-1 mr-sm-1 " type="text" name="inputNomeAutor" />

			<button style="margin-left:10px" type="submit" class="btn btn-primary mb-1" >cadastrar</button>
			
		</form>

		<div>
			<small> <%	if(mensagemErro != null){ out.println(mensagemErro); } %> </small>
		</div><br>


		<table class="table">
			<thead>
				<tr>
					<th>#id</th>
					<th>livro</th>
					<th>autor</th>
					<th>data</th>
					<th>status</th>
					<th>operações</th>
				</tr>
			</thead>

			<!-- taglib -->

			<%	for(Livro livro: listaLivrosJSP) { %>
			
			<tr>
				<td>
					<% out.print(livro.getId()); %>
				</td>
				<td><%= livro.getNomeLivro() %></td>
				<td><%= livro.getAutor().getNomeAutor() %></td>
				<td><%= dateFormat.format(livro.getDataCriacao()) %></td>
				<td><%= livro.getStatus().getStatus() %></td>

				<td><a href="/app/livros/alterar-status?id=<%= livro.getId() %>&status=disponivel">disponivel</a>
					<a href="/app/livros/alterar-status?id=<%= livro.getId() %>&status=emprestado">emprestado</a>
					<a href="/app/livros/excluir?id=<%= livro.getId() %>">excluir</a>
				</td>
			</tr>

			<%} %>
		</table>
	</div>
</body>
</html>
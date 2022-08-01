<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        <h1>Alterar Dados do Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="EditarPROD" method="POST">
            
            <input type="hidden" name="id" value="<%=produto.getId()%>" >
            
            Idcategoria:<br>
            <input type="text" name="idcategoria" value="<%=produto.getIdcategoria() %>" >
            <br>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" >
            <br>
            <% if(request.getAttribute("erro_descricao1") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao1"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao() %>" >
            <br>
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor() %>"  >
            <br>
            
          
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>

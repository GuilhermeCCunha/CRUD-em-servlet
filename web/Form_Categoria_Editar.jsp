<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Lista de Categorias</h1>
        <h1>Alterar Dados da Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); 
        %>
        <form action="EditarCAT" method="POST">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            <% if(request.getAttribute("erro_descrição") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descrição"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" >
            <br>
            
          
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>

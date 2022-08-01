<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <h1>Lista de Categorias</h1>
        <h1>Dados do Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); 
        %>
        <form action="ListaCategoria" method="GET">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            <% if(request.getAttribute("erro_descricao") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" readonly="true" >
            <br>
         
            <br><br>
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>

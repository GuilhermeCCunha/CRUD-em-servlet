<%@page import="br.DAO.Compras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Lista de Compras</h1>
        <h1>Alterar Dados das Compras</h1>
        <% Compras compras = (Compras) request.getAttribute("compras"); 
        %>
        <form action="EditarCMPR" method="POST">
            
            <input type="hidden" name="id" value="<%=compras.getId()%>" >
            
            
            Idcliente:<br>
            <input type="text" name="idcliente" value="<%=compras.getIdcliente() %>"  >
            <br> 
            Idproduto:<br>
            <input type="text" name="idproduto" value="<%=compras.getIdproduto() %>" >
            <br>
          
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaCompras">Retorna</a>
        </form> 
    </body>
</html>
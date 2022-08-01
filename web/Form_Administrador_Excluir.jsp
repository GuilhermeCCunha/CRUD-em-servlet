<%@page import="br.DAO.Administrador"%>
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
        <h1>Lista de Administradores</h1>
        <h1>Excluir Administradores</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="ExcluirADM" method="Post">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            
             <% if(request.getAttribute("erro_login") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao1"));%></h3>        
            <% }%>
            Login:<br>
            <input type="text" name="login" value="<%=administrador.getLogin() %>" readonly="" >
            <br>
            Senha:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha() %>" readonly="" >
            <br>
           
            
        
          
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaAdministrador">Retorna</a>
        </form> 
    </body>
</html>

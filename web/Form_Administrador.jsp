<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Administrador</h1>
        <form action="IncluirADM" method="POST">
           
              <% if(
                    (request.getAttribute("erro_login") != null)
                    || (request.getAttribute("erro_login") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_login"));%></h3>        
            <% }%>
            Login:<br>
            <input type="text" name="login" >
            <br>
            <% if(
                    (request.getAttribute("erro_senha") != null)
                    || (request.getAttribute("erro_senha") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_senha"));%></h3>        
            <% }%>
            Senha:<br>
            <input type="text" name="senha" >
            <br>
            
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Compras</h1>
        <form action="IncluirCMPR" method="POST">
              <% if(request.getAttribute("erro_idcliente") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcliente"));%></h3>        
            <% }%>
            Idcliente:<br>
            <input type="text" name="idcliente" >
            <br>
              <% if(request.getAttribute("erro_idproduto") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idproduto"));%></h3>        
            <% }%>
            Idproduto:<br>
            <input type="text" name="idproduto" >
            <br>
        
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

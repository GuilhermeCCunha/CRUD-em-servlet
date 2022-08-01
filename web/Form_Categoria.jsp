<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Categoria</h1>
        <form action="IncluirCAT" method="POST">
            <% if(
                    (request.getAttribute("erro_descrição") != null)
                    || (request.getAttribute("erro_descrição") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descrição"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" >
            <br>
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

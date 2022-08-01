<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Produto</h1>
        <form action="IncluirPROD" method="POST">
              <% if(request.getAttribute("erro_idcategoria") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcategoria"));%></h3>        
            <% }%>
            Idcategoria:<br>
            <input type="text" name="idcategoria" >
            <br>
              <% if(
                    (request.getAttribute("erro_nome") != null)
                    || (request.getAttribute("erro_nome") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" >
            <br>
            <% if(
                    (request.getAttribute("erro_descrição1") != null)
                    || (request.getAttribute("erro_descrição1") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descrição1"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" >
            <br>
             <% if(request.getAttribute("erro_valor") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Valor:<br>
            <input type="text" name="valor" >
            <br>
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

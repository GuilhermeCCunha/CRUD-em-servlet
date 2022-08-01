<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
        <p></p>
        <div><a href="<% out.println(request.getAttribute("retorna"));%>">Página anterior</a></div>
    </body>
</html>

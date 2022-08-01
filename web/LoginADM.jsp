<%-- 
    Document   : LoginADM
    Created on : 02-Dec-2017, 01:38:10
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <form action="LoginSessao" method="post">
                Login:<input type="text" name="login"> <br><br>
              Senha:<input type="password" name="senha"> <br><br> 
              <input type="submit" name="submit" value="submit">
            </form>   
        </div>
    </body>
</html>

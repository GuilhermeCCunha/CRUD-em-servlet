<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Produtos no Carrinho</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="IncluirCarrinho" method="POST">
            
            <input type="hidden" name="id" value="<%=produto.getId()%>" >
            
            Idcategoria:<br>
            <input type="text" name="idcategoria" value="<%=produto.getIdcategoria() %>"readonly="true" >
            <br>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" readonly="true">
            <br>
            <% if(request.getAttribute("erro_descricao1") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao1"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao() %>" readonly="true">
            <br>
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor() %>" readonly="true" >
            <br>
            
          
            <br><br>
            <input type="submit" value="Incluir">
            <a href="index.jsp">Retorna</a>
        </form> 
    </body>
</html>

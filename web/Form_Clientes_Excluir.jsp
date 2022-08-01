<%@page import="br.DAO.Clientes"%>
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
        <h1>Lista de Clientes</h1>
        <h1>Excluir Clientes</h1>
        <% Clientes clientes = (Clientes) request.getAttribute("clientes"); 
        %>
        <form action="ExcluirCLNT" method="Post">
            
            <input type="hidden" name="id" value="<%=clientes.getId()%>" >
            
             <% if(request.getAttribute("erro_nome1") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome1"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=clientes.getNome() %>" readonly="" >
            <br>
            endereco:<br>
            <input type="text" name="endereco" value="<%=clientes.getEndereco() %>" readonly="" >
            <br>
            bairro:<br>
            <input type="text" name="bairro" value="<%=clientes.getBairro() %>" readonly="" >
            <br>
            cidade:<br>
            <input type="text" name="cidade" value="<%=clientes.getCidade() %>" readonly="" >
            <br>
            cep:<br>
            <input type="text" name="cep" value="<%=clientes.getCep() %>" readonly="" >
            <br>
            estado:<br>
            <input type="text" name="estado" value="<%=clientes.getEstado() %>" readonly="" >
            <br>
            referencia:<br>
            <input type="text" name="referencia" value="<%=clientes.getReferencia() %>" readonly="" >
            <br>
            cpf:<br>
            <input type="text" name="cpf" value="<%=clientes.getCpf() %>" readonly="" >
            <br>
            identidade:<br>
            <input type="text" name="identidade" value="<%=clientes.getIdentidade() %>" readonly="" >
            <br>
            telfixo:<br>
            <input type="text" name="telfixo" value="<%=clientes.getTelfixo() %>" readonly="" >
            <br>
            celular:<br>
            <input type="text" name="celular" value="<%=clientes.getCelular() %>" readonly="" >
            <br>
            
            numcartao:<br>
            <input type="text" name="numcartao" value="<%=clientes.getNumcartao() %>" readonly="" >
            <br>
            bandcartao:<br>
            <input type="text" name="bandcartao" value="<%=clientes.getBandcartao() %>" readonly="" >
            <br>
            
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
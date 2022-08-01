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
        <h1>Dados dos Clientes</h1>
        <% Clientes clientes = (Clientes) request.getAttribute("clientes"); 
        %>
        <form action="ListaClientes" method="GET">
            
            <input type="hidden" name="id" value="<%=clientes.getId()%>" >
            
             <% if(request.getAttribute("erro_nome1") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome1"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=clientes.getNome() %>" readonly="true" >
            <br>
            endereco:<br>
            <input type="text" name="endereco" value="<%=clientes.getEndereco() %>" readonly="true" >
            <br>
            bairro:<br>
            <input type="text" name="bairro" value="<%=clientes.getBairro() %>" readonly="true" >
            <br>
            cidade:<br>
            <input type="text" name="cidade" value="<%=clientes.getCidade() %>" readonly="true" >
            <br>
            cep:<br>
            <input type="text" name="cep" value="<%=clientes.getCep() %>" readonly="true" >
            <br>
            estado:<br>
            <input type="text" name="estado" value="<%=clientes.getEstado() %>" readonly="true" >
            <br>
            referencia:<br>
            <input type="text" name="referencia" value="<%=clientes.getReferencia() %>" readonly="true" >
            <br>
            cpf:<br>
            <input type="text" name="cpf" value="<%=clientes.getCpf() %>" readonly="true" >
            <br>
            identidade:<br>
            <input type="text" name="identidade" value="<%=clientes.getIdentidade() %>" readonly="true" >
            <br>
            telfixo:<br>
            <input type="text" name="telfixo" value="<%=clientes.getTelfixo() %>" readonly="true" >
            <br>
            celular:<br>
            <input type="text" name="celular" value="<%=clientes.getCelular() %>" readonly="true" >
            <br>
            
            numcartao:<br>
            <input type="text" name="numcartao" value="<%=clientes.getNumcartao() %>" readonly="true" >
            <br>
            bandcartao:<br>
            <input type="text" name="bandcartao" value="<%=clientes.getBandcartao() %>" readonly="true" >
            <br>
            
         
            <br><br>
            <a href="ListaClientes">Retorna</a>
        </form> 
    </body>
</html>
<%@page import="br.DAO.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <h1>Alterar Dados dos Clientes</h1>
        <% Clientes clientes = (Clientes) request.getAttribute("clientes"); 
        %>
        <form action="EditarCLNT" method="POST">
            
            <input type="hidden" name="id" value="<%=clientes.getId()%>" >
            
            
            Nome:<br>
            <input type="text" name="nome" value="<%=clientes.getNome() %>" >
            <br>
             endereco:<br>
            <input type="text" name="endereco" value="<%=clientes.getEndereco() %>" >
            <br>
             bairro:<br>
            <input type="text" name="bairro" value="<%=clientes.getBairro() %>" >
            <br>
             cidade:<br>
            <input type="text" name="cidade" value="<%=clientes.getCidade() %>" >
            <br>
             cep:<br>
            <input type="text" name="cep" value="<%=clientes.getCep() %>" >
            <br>
              estado:<br>
            <input type="text" name="estado" value="<%=clientes.getEstado() %>" >
            <br>
             referencia:<br>
            <input type="text" name="referencia" value="<%=clientes.getReferencia() %>" >
            <br>
             cpf:<br>
            <input type="text" name="cpf" value="<%=clientes.getCpf() %>" >
            <br>
             identidade:<br>
            <input type="text" name="identidade" value="<%=clientes.getIdentidade() %>" >
            <br>
             telfixo:<br>
            <input type="text" name="telfixo" value="<%=clientes.getTelfixo() %>" >
            <br>
             celular:<br>
            <input type="text" name="celular" value="<%=clientes.getCelular() %>" >
            <br>
          
          
           
            numcartao:<br>
            <input type="text" name="numcartao" value="<%=clientes.getNumcartao() %>" >
            <br>
            bandcartao:<br>
          
                      <select name="bandcartao"    value="<%=clientes.getBandcartao() %>"   >
  <option value="MasterCard">MasterCard</option>
  <option value="Visa">Visa</option>
  <option value="American_Express">American Express</option>
  <option value="Diners_Club">Diners Club International</option>
  <option value="Elo">Elo</option>
  <option value="Hipercard">Hipercard</option>
</select> 
<br>
            
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaClientes">Retorna</a>
        </form> 
    </body>
</html>
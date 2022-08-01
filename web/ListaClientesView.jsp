<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <a href="Form_Clientes.jsp">Incluir Clientes</a>
        <a href="AreaRestrita.jsp">Área Restrita</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>endereco</th>
            <th>bairro</th>
            <th>cidade</th>
            <th>cep</th>
            <th>estado</th>
            <th>referencia</th>
            <th>cpf</th>
            <th>identidade</th>
            <th>telfixo</th>
            <th>celular</th>
            <th>numcartao</th>
            <th>bandcartao</th>
            
            
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Clientes> resultado = (ArrayList) request.getAttribute("meusClientes");
            for (int i = 0; i < resultado.size(); i++) {
                Clientes aux = (Clientes)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
          <td><%=aux.getNome()%></td>
          <td><%=aux.getEndereco()%></td>
          <td><%=aux.getBairro()%></td>
          <td><%=aux.getCidade()%></td>
          <td><%=aux.getCep()%></td>
          <td><%=aux.getEstado()%></td>
          <td><%=aux.getReferencia()%></td>
          <td><%=aux.getCpf()%></td>
          <td><%=aux.getIdentidade()%></td>
          <td><%=aux.getTelfixo()%></td>
          <td><%=aux.getCelular()%></td>
          <td><%=aux.getNumcartao()%></td>
          <td><%=aux.getBandcartao()%></td>
          
       
       
        <td><a href="VisualizarCLNT?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCLNT?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCLNT?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

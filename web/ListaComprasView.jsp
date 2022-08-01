<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Compras"%>
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
        <h1>Lista de Compras</h1>
        <a href="Form_Compras.jsp">Incluir Compras</a>
        <a href="AreaRestrita.jsp">Área Restrita</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Idcliente</th>
             <th>Idproduto</th>
             
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Compras> resultado = (ArrayList) request.getAttribute("minhasCompras");
            for (int i = 0; i < resultado.size(); i++) {
                Compras aux = (Compras)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
         <td><%=aux.getIdcliente()%></td>
          <td><%=aux.getIdproduto()%></td>
        
       
        <td><a href="VisualizarCMPR?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCMPR?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCMPR?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

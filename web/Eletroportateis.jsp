<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Produto"%>
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
        LOJA DW
        <h1>Lista de Eletroportáteis</h1>
       
        <a href="index.jsp">Página Inicial</a>
        <p></p>
       
        <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("meusEleport");
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
        %>
        <tr>
       
        
          <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td> 
        
         <td>-R$ <%=aux.getValor()%></td>
       
        <td><a href="IncluirCarrinho?id=<%=aux.getId()%>">Comprar</a> </td>
        </tr><br><br>
        <%
            }
        %>

    </table>

</body>
</html>

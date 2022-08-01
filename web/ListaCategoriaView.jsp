<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Categoria"%>
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
        <h1>Lista de Categorias</h1>
        <a href="Form_Categoria.jsp">Incluir Categorias</a>
        <a href="AreaRestrita.jsp">Área Restrita</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Descrição</th>
            
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Categoria> resultado = (ArrayList) request.getAttribute("minhasCategorias");
            for (int i = 0; i < resultado.size(); i++) {
                Categoria aux = (Categoria)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getDescricao()%></td> 
       
        <td><a href="VisualizarCAT?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCAT?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCAT?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>


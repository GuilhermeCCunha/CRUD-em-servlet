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
        <h1>Minhas Compras</h1>
       
       
        <p></p>
       
        <% float aux1 = 0;
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("meuCarrinho");
            if ( resultado !=null) {
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
               aux1 = aux1 + aux.getValor();
        %>
        <tr>
       
        
          <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td> 
        
         <td>-R$ <%=aux.getValor()%></td>
       
        <td><a href="ExcluirCarrinho?id=<%=aux.getId()%>">Excluir</a> </td>
        </tr><br><br>
        <%
            }}
        %>

    </table>
    
    Total da Compra: R$<%out.println(aux1);%>
 <br><br>
    
 <a href="Form_Clientes.jsp">FINALIZAR A COMPRA</a>
 <br><br><br>
  <a href="index.jsp">RETORNAR AS COMPRAS</a>
</body>
</html>

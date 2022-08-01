<%@page import="java.util.ArrayList"%>

<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1></h1>
        LOJA DW  &emsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="LoginADM.jsp"> Área Restrita </a>
        <br>
        <br>
        <br>
        <div><a href="ListaEledo">Eletrodomésticos  </a>&nbsp;&nbsp;
        <a href="ListaInfo"> Informática </a>&nbsp;&nbsp;
       <a href="ListaEleport"> Eletroportáteis </a>&nbsp;&nbsp;
        
      <a href="ListaSmart"> Smartphones </a> &emsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;
      &emsp;&emsp;&emsp;&emsp;
      <a href="ListaCarrinho"> <img width="35px" height="35px" src="icone_carrinho.jpg"/> </a>
      <br><br> 
      
  <div>
      
     <form action="Pesqprod" method="Listar">
                <input type="text" name="nome"> 
              
              <input type="submit" name="submit" value="PESQUISAR">
            </form>  
  </div>
      <div>
      <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("minhasPesqprod");
            if ( resultado !=null) {
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
           } }
        %>
      </div>

        </div>
    </body>
</html>

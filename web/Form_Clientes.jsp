<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Clientes</h1>
        <form action="IncluirCLNT" method="POST">
            
              <% if(
                    (request.getAttribute("erro_nome1") != null)
                    || (request.getAttribute("erro_nome1") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome1"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" >
            <br>
               <% if(
                    (request.getAttribute("erro_endereco") != null)
                    || (request.getAttribute("erro_endereco") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_endereco"));%></h3>        
            <% }%>
            endereco:<br>
            <input type="text" name="endereco" >
            <br>
               <% if(
                    (request.getAttribute("erro_bairro") != null)
                    || (request.getAttribute("erro_bairro") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bairro"));%></h3>        
            <% }%>
            bairro:<br>
            <input type="text" name="bairro" >
            <br>
         
               <% if(
                    (request.getAttribute("erro_cidade") != null)
                    || (request.getAttribute("erro_cidade") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cidade"));%></h3>        
            <% }%>
            cidade:<br>
            <input type="text" name="cidade" >
            <br>
               <% if(
                    (request.getAttribute("erro_cep") != null)
                    || (request.getAttribute("erro_cep") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cep"));%></h3>        
            <% }%>
            cep:<br>
            <input type="text" name="cep" >
            <br>
               <% if(
                    (request.getAttribute("erro_estado") != null)
                    || (request.getAttribute("erro_estado") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_estado"));%></h3>        
            <% }%>
            estado:<br>
            <input type="text" name="estado" >
            <br>
              <% if(
                    (request.getAttribute("erro_referencia") != null)
                    || (request.getAttribute("erro_referencia") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_referencia"));%></h3>        
            <% }%>
            referencia:<br>
            <input type="text" name="referencia" >
            <br>
               <% if(
                    (request.getAttribute("erro_cpf") != null)
                    || (request.getAttribute("erro_cpf") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            cpf:<br>
            <input type="text" name="cpf" >
            <br>
               <% if(
                    (request.getAttribute("erro_identidade") != null)
                    || (request.getAttribute("erro_identidade") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_identidade"));%></h3>        
            <% }%>
            identidade:<br>
            <input type="text" name="identidade" >
            <br>
         
               <% if(
                    (request.getAttribute("erro_telfixo") != null)
                    || (request.getAttribute("erro_telfixo") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_telfixo"));%></h3>        
            <% }%>
            telfixo:<br>
            <input type="text" name="telfixo" >
            <br>
               <% if(
                    (request.getAttribute("erro_celular") != null)
                    || (request.getAttribute("erro_celular") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            celular:<br>
            <input type="text" name="celular" >
             <br>
        
                <% if(request.getAttribute("erro_numcartao") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_numcartao"));%></h3>        
            <% }%>
            numcartao:<br>
            <input type="text" name="numcartao" >
            <br>
                <% if(request.getAttribute("erro_bandcartao") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bandcartao"));%></h3>        
            <% }%>
            bandcartao:<br>
           
            
            <select name="bandcartao" >
  <option value="MasterCard">MasterCard</option>
  <option value="Visa">Visa</option>
  <option value="American_Express">American Express</option>
  <option value="Diners_Club">Diners Club International</option>
  <option value="Elo">Elo</option>
  <option value="Hipercard">Hipercard</option>
</select> 
  <br>          
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

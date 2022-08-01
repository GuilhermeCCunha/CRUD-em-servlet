package br.controle;

import br.DAO.Clientes;
import br.DAO.Clientes_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCLNT", urlPatterns = {"/IncluirCLNT"})
public class IncluirCLNT extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        
        String nome = request.getParameter("nome");
         String endereco = request.getParameter("endereco");
          String bairro = request.getParameter("bairro");
           String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
         String estado = request.getParameter("estado");
         String referencia = request.getParameter("referencia");
          String cpf = request.getParameter("cpf");
           String identidade = request.getParameter("identidade");
            String telfixo = request.getParameter("telfixo"); 
            String celular = request.getParameter("celular");
        
        String numcartao = request.getParameter("numcartao");
         String bandcartao = request.getParameter("bandcartao");
      
        try {
            
            request.setAttribute("erro_nome1", "");

            if (nome.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome1", "A descrição não pode ser vazia");
                }

              

                RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes.jsp");
                rd.forward(request, response);
            } else {

                Clientes clientes = new Clientes (nome,endereco,bairro,cidade,cep,estado,referencia,cpf,identidade,telfixo,celular,numcartao,bandcartao);
                Clientes_DAO clientes_dao = new Clientes_DAO();
                try {
                    clientes_dao.Inserir(clientes);
                    request.setAttribute("mensagem", "Operação realizada Com Sucesso");
                    request.setAttribute("retorna", "index.jsp");//request.setAttribute("retorna", "ListaClientes");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome1", "A descrição não pode ser vazia");
            
            RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes.jsp");
            rd.forward(request, response);
        }

    }

}

package br.controle;

import br.DAO.Compras;
import br.DAO.Compras_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCMPR", urlPatterns = {"/IncluirCMPR"})
public class IncluirCMPR extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
         int idproduto = Integer.parseInt(request.getParameter("idproduto"));
      
        try {
            
            request.setAttribute("erro_idcliente", "");

            if (idcliente <= 0) // verifica os dados
            {  // retorna para o formulario de contato

               

              

                RequestDispatcher rd = request.getRequestDispatcher("Form_Compras.jsp");
                rd.forward(request, response);
            } else {

                Compras compras = new Compras(idcliente,idproduto);
                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Inserir(compras);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
            
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras.jsp");
            rd.forward(request, response);
        }

    }

}
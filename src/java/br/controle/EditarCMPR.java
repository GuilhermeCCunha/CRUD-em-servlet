package br.controle;

import br.DAO.Compras;
import br.DAO.Compras_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "EditarCMPR", urlPatterns = {"/EditarCMPR"})
public class EditarCMPR extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Compras compras = new Compras(id);
        Compras_DAO compras_dao = new Compras_DAO();
        try {
            compras_dao.get(compras);
            request.setAttribute("compras", compras);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int id = Integer.parseInt(request.getParameter("id"));
         int idcliente = Integer.parseInt(request.getParameter("idcliente"));
          int idproduto = Integer.parseInt(request.getParameter("idproduto"));
       

        Compras compras = new Compras (id, idcliente , idproduto );
        try {
            if (idcliente <= 0) // verifica os dados
            {  // retorna para o formulario de contato

                if (idcliente <= 0) {
                    request.setAttribute("erro_idcliente", "O idcliente não pode ser vazio");
                }

                


                request.setAttribute("compras", compras);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Compras_Editar.jsp");
                rd.forward(request, response);
            } else {

                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Alterar(compras);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_idcliente", "O idcliente não pode ser vazio");
         
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras.jsp");
            rd.forward(request, response);
        }

    }

}

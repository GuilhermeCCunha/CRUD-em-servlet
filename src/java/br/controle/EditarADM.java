package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
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
@WebServlet(name = "EditarADM", urlPatterns = {"/EditarADM"})
public class EditarADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador administrador = new Administrador(id);
        Administrador_DAO administrador_dao = new Administrador_DAO();
        try {
            administrador_dao.get(administrador);
            request.setAttribute("administrador", administrador);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int id = Integer.parseInt(request.getParameter("id"));
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
       

        Administrador administrador = new Administrador (id, login , senha );
        try {
            if (login.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (login.isEmpty()) {
                    request.setAttribute("erro_login", "O login não pode ser vazio");
                }

                


                request.setAttribute("administrador", administrador);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador_Editar.jsp");
                rd.forward(request, response);
            } else {

                Administrador_DAO administrador_dao = new Administrador_DAO();
                try {
                    administrador_dao.Alterar(administrador);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaAdministrador");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_login", "O login não pode ser vazio");
         
            RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador.jsp");
            rd.forward(request, response);
        }

    }

}

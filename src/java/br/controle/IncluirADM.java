package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirADM", urlPatterns = {"/IncluirADM"})
public class IncluirADM extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
      
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
       
        try {
            
            request.setAttribute("erro_login", "");

            if (login.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (login.isEmpty()) {
                    request.setAttribute("erro_login", "O login não pode ser vazio");
                }

              

                RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador.jsp");
                rd.forward(request, response);
            } else {

                Administrador administrador = new Administrador(login,senha);
                Administrador_DAO administrador_dao = new Administrador_DAO();
                try {
                    administrador_dao.Inserir(administrador);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaAdministrador");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descrição", "O login não pode ser vazio");
            
            RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador.jsp");
            rd.forward(request, response);
        }

    }

}

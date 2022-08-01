package br.controle;

import br.DAO.Clientes;
import br.DAO.Clientes_DAO;
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
@WebServlet(name = "EditarCLNT", urlPatterns = {"/EditarCLNT"})
public class EditarCLNT extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Clientes clientes = new Clientes(id);
        Clientes_DAO clientes_dao = new Clientes_DAO();
        try {
            clientes_dao.get(clientes);
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        int id = Integer.parseInt(request.getParameter("id"));
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
        


Clientes clientes = new Clientes (id,nome,endereco,bairro,cidade,cep,estado,referencia,cpf,identidade,telfixo,celular,numcartao,bandcartao);
        try {
            if (nome.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome1", "A descrição não pode ser vazia");
                }

                


                request.setAttribute("clientes", clientes);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes_Editar.jsp");
                rd.forward(request, response);
            } else {

                Clientes_DAO clientes_dao = new Clientes_DAO();
                try {
                    clientes_dao.Alterar(clientes);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaClientes");
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
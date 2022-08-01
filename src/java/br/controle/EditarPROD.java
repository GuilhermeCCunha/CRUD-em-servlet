package br.controle;

import br.DAO.Produto;
import br.DAO.Produto_DAO;
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
@WebServlet(name = "EditarPROD", urlPatterns = {"/EditarPROD"})
public class EditarPROD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto(id);
        Produto_DAO produto_dao = new Produto_DAO();
        try {
            produto_dao.get(produto);
            request.setAttribute("produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int id = Integer.parseInt(request.getParameter("id"));
        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float valor = Float.parseFloat(request.getParameter("valor"));

        Produto produto = new Produto (id, idcategoria , nome , descricao, valor);
        try {
            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
                }

                


                request.setAttribute("produto", produto);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Editar.jsp");
                rd.forward(request, response);
            } else {

                Produto_DAO produto_dao = new Produto_DAO();
                try {
                    produto_dao.Alterar(produto);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaProduto");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
         
            RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos.jsp");
            rd.forward(request, response);
        }

    }

}

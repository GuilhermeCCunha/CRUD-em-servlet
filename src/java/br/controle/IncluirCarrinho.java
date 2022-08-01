package br.controle;

import br.DAO.Produto;
import br.DAO.ComprarPROD;
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
@WebServlet(name = "IncluirCarrinho", urlPatterns = {"/IncluirCarrinho"})
public class IncluirCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto(id);
        ComprarPROD produto_dao = new ComprarPROD();
        try {
            produto_dao.get(produto);
            request.setAttribute("produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Carrinho.jsp");
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
                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Carrinho.jsp");
                rd.forward(request, response);
            } else {

                ComprarPROD produto_dao = new ComprarPROD();
                try {
                    produto_dao.Alterar(produto);
                    request.setAttribute("mensagem", "Incluido no carrinho Com Sucesso");
                    request.setAttribute("retorna", "index.jsp");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
         
            RequestDispatcher rd = request.getRequestDispatcher("Form_index.jsp");
            rd.forward(request, response);
        }

    }

}

package br.controle;

import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirPROD", urlPatterns = {"/IncluirPROD"})
public class IncluirPROD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float valor = Float.parseFloat(request.getParameter("valor"));
        try {
            
            request.setAttribute("erro_descricao1", "");

            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao1", "A descrição não pode ser vazia");
                }

              

                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
                rd.forward(request, response);
            } else {

                Produto produto = new Produto(idcategoria,nome,descricao,valor);
                Produto_DAO produto_dao = new Produto_DAO();
                try {
                    produto_dao.Inserir(produto);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
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
            
            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
            rd.forward(request, response);
        }

    }

}
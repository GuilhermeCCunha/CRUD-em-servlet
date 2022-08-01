/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categoria;
import br.DAO.Categoria_DAO;
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
@WebServlet(name = "EditarCAT", urlPatterns = {"/EditarCAT"})
public class EditarCAT extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = new Categoria(id);
        Categoria_DAO categoria_dao = new Categoria_DAO();
        try {
            categoria_dao.get(categoria);
            request.setAttribute("categoria", categoria);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");

        Categoria categoria = new Categoria(id, descricao);
        try {
            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
                }

                


                request.setAttribute("categoria", categoria);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria_Editar.jsp");
                rd.forward(request, response);
            } else {

                Categoria_DAO categoria_dao = new Categoria_DAO();
                try {
                    categoria_dao.Alterar(categoria);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaCategoria");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descrição", "A descrição não pode ser vazia");
         
            RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria.jsp");
            rd.forward(request, response);
        }

    }

}

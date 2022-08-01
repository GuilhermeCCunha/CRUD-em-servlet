/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Produto;
import br.DAO.ComprarPROD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
@WebServlet(name = "ListaCarrinho", urlPatterns = {"/ListaCarrinho"})
public class ListaCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ComprarPROD produto_dao = new ComprarPROD();
        ArrayList<Produto> meuCarrinho = produto_dao.Listar();
        request.setAttribute("meuCarrinho", meuCarrinho);
        RequestDispatcher rd = request.getRequestDispatcher("Carrinho.jsp");
        rd.forward(request, response);

    }

}
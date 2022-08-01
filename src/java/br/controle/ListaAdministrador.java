/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
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
@WebServlet(name = "ListaAdministrador", urlPatterns = {"/ListaAdministrador"})
public class ListaAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Administrador_DAO administrador_dao = new Administrador_DAO();
        ArrayList<Administrador> Administradores = administrador_dao.Listar();
        request.setAttribute("Administradores", Administradores);
        RequestDispatcher rd = request.getRequestDispatcher("ListaAdministradorView.jsp");
        rd.forward(request, response);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author guilh
 */
@WebServlet(name = "LoginSessao", urlPatterns = {"/LoginSessao"})
public class LoginSessao extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
    { 
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/alomundodb", "usuario", "12345");
          PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMINISTRADOR WHERE login=? AND senha=? ");
          
          String login = req.getParameter("login");
          String senha = req.getParameter("senha");
          ps.setString(1,login);
          ps.setString(2,senha);
          ResultSet rs = ps.executeQuery();
          if (rs.next())
          {
             HttpSession session = req.getSession(true);
             session.setAttribute("WELCOME",login);
             //res.sendRedirect("AreaRestrita.jsp");
              RequestDispatcher rd1 = req.getRequestDispatcher("AreaRestrita.jsp");
                    rd1.forward(req, res);
             
             
              
          }    
          else
              
              req.setAttribute("mensagem", "Administrador incorreto");
                    req.setAttribute("retorna", "index.jsp");
                    RequestDispatcher rd = req.getRequestDispatcher("Resposta.jsp");
                    rd.forward(req, res);
              //res.sendRedirect("index.jsp");
      }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginSessao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginSessao.class.getName()).log(Level.SEVERE, null, ex);
        }    
   
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Conexao;
import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Pesqprod", urlPatterns = {"/Pesqprod"})
public class Pesqprod extends HttpServlet {
    
    /**
     *
     * @param req
     * @param res
     * @return
     * @throws IOException
     * @throws ServletException
     */
    
        public ArrayList<Produto> Listar (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
    { 
        ArrayList<Produto> minhasPesqprod = new ArrayList();
        Conexao conexao = new Conexao();
        try {                   
            Class.forName("org.apache.derby.jdbc.ClientDriver");

                      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/alomundodb", "usuario", "12345");
                                String nome = req.getParameter("nome");


            String selectSQL = "SELECT * FROM PRODUTO WHERE Nome LIKE '%"+nome+"%'";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto (Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Float.parseFloat(resultado.getString("VALOR")));
                            
                          
                    minhasPesqprod.add (produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pesqprod.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConexao();
        }
        return minhasPesqprod;

    }


     
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pesqprod pesqprod = new Pesqprod();
        ArrayList<Produto> minhasPesqprod = pesqprod.Listar( request,  response);
        request.setAttribute("minhasPesqprod", minhasPesqprod);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

}

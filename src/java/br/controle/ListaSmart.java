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


/**
 *
 * @author guilh
 */
@WebServlet(name = "ListaSmart", urlPatterns = {"/ListaSmart"})
public class ListaSmart extends HttpServlet {

    public ArrayList<Produto> Listar() {
        ArrayList<Produto> meusSmart = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE IDCATEGORIA=4";
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
                            
                          
                    meusSmart.add (produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusSmart;

    }


    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ListaSmart listasmart = new ListaSmart();
        ArrayList<Produto> meusSmart = listasmart.Listar();
        request.setAttribute("meusSmart", meusSmart);
        RequestDispatcher rd = request.getRequestDispatcher("Smartphones.jsp");
        rd.forward(request, response);

    }

}

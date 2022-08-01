/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class Administrador_DAO {
    


    public void Inserir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ADMINISTRADOR (login,senha ) VALUES (?,?)");
           
           sql.setString(1, administrador.getLogin());
           sql.setString(2, administrador.getSenha());
          

            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador get(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                   

                    administrador.setLogin(resultado.getString("LOGIN"));
                    administrador.setSenha(resultado.getString("SENHA"));
                   


                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE ADMINISTRADOR  SET login = ?, senha = ?  WHERE ID = ? ");
     
            sql.setString(1, administrador.getLogin());
            sql.setString(2, administrador.getSenha());
           
         
            sql.setInt(3, administrador.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM ADMINISTRADOR  WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Administrador> Listar() {
        ArrayList<Administrador> Administradores = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador administrador;
                    administrador = new Administrador (Integer.parseInt(resultado.getString("id")),
                            
                            resultado.getString("LOGIN"),
                            resultado.getString("SENHA"));
                           
                            
                          
                    Administradores.add(administrador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return Administradores;

    }

}
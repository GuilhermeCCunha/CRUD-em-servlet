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
public class Clientes_DAO {
    


    public void Inserir(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTES (nome,endereco,bairro,cidade,cep,estado,referencia,cpf,identidade,telfixo,celular,numcartao,bandcartao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, clientes.getNome());
            sql.setString(2, clientes.getEndereco());
            sql.setString(3, clientes.getBairro());
            sql.setString(4, clientes.getCidade());
            sql.setString(5, clientes.getCep());
            sql.setString(6, clientes.getEstado());
            sql.setString(7, clientes.getReferencia());
            sql.setString(8, clientes.getCpf());
            sql.setString(9, clientes.getIdentidade());
            sql.setString(10, clientes.getTelfixo());
            sql.setString(11, clientes.getCelular());
            sql.setString(12, clientes.getNumcartao());
            sql.setString(13, clientes.getBandcartao());
            
            
            
           


            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Clientes get(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, clientes.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    

                    clientes.setNome(resultado.getString("NOME"));
                    clientes.setEndereco(resultado.getString("ENDERECO"));
                    clientes.setBairro(resultado.getString("BAIRRO"));
                    clientes.setCidade(resultado.getString("CIDADE"));
                    clientes.setCep(resultado.getString("CEP"));
                    clientes.setEstado(resultado.getString("ESTADO"));
                    clientes.setReferencia(resultado.getString("REFERENCIA"));
                    clientes.setCpf(resultado.getString("CPF"));
                    clientes.setIdentidade(resultado.getString("IDENTIDADE"));
                    clientes.setTelfixo(resultado.getString("TELFIXO"));
                    clientes.setCelular(resultado.getString("CELULAR"));
                    clientes.setNumcartao(resultado.getString("NUMCARTAO"));
                    clientes.setBandcartao(resultado.getString("BANDCARTAO"));
                    
                    
                   


                }
            }
            return clientes;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTES SET nome = ?  ,endereco = ?, bairro = ? ,cidade = ? ,cep = ? ,estado = ? ,referencia = ? ,cpf = ? ,identidade = ? ,telfixo = ? ,celular = ? ,numcartao = ? ,bandcartao = ? WHERE ID = ? ");
            
            sql.setString(1, clientes.getNome());
            sql.setString(2, clientes.getEndereco());
            sql.setString(3, clientes.getBairro());
            sql.setString(4, clientes.getCidade());
            sql.setString(5, clientes.getCep());
            sql.setString(6, clientes.getEstado());
            sql.setString(7, clientes.getReferencia());
            sql.setString(8, clientes.getCpf());
            sql.setString(9, clientes.getIdentidade());
            sql.setString(10, clientes.getTelfixo());
            sql.setString(11, clientes.getCelular());
            sql.setString(12, clientes.getNumcartao());
            sql.setString(13, clientes.getBandcartao());
            
        
            sql.setInt(14, clientes.getId());
           sql.executeUpdate();
           

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, clientes.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Clientes> Listar() {
        ArrayList<Clientes> meusClientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTES";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Clientes clientes;
                    clientes = new Clientes (Integer.parseInt(resultado.getString("id")),
                            
                            resultado.getString("NOME"),
                             resultado.getString("ENDERECO"),
                             resultado.getString("BAIRRO"),
                             resultado.getString("CIDADE"),
                             resultado.getString("CEP"),
                            resultado.getString("ESTADO"),
                             resultado.getString("REFERENCIA"),
                             resultado.getString("CPF"),
                             resultado.getString("IDENTIDADE"),
                             resultado.getString("TELFIXO"),
                            resultado.getString("CELULAR"),
                            resultado.getString("NUMCARTAO"),
                            resultado.getString("BANDCARTAO"));
                            
                           
                            
                          
                    meusClientes.add (clientes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusClientes;

    }

}
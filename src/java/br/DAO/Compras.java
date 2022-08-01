package br.DAO;

public class Compras {

    private int id;
    private int idcliente;
    private int idproduto;
  

    public Compras (int idcliente, int idproduto) {

        this.idcliente = idcliente;
         this.idproduto = idproduto;
       
   
    }
    
     public Compras (int id ,int idcliente, int idproduto) {
        this.id = id; 
        this.idcliente = idcliente;
         this.idproduto = idproduto;
       
   
    }

    public Compras (int id) {
        this.id = id;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
   

  
}
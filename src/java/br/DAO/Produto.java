package br.DAO;

public class Produto {

    private int id;
    private int idcategoria;
    private String nome;
    private String descricao;
    private float valor;

    public Produto(int idcategoria, String nome, String descricao,float valor) {

        this.idcategoria = idcategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
   
    }
    
      public Produto(int id, int idcategoria, String nome, String descricao,float valor) {
          
        this.id = id;
        this.idcategoria = idcategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
   
    }


    public Produto (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
     public int getIdcategoria() {
        return idcategoria;
    }
     
     public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

  
}

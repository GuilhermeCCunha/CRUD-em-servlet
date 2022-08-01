package br.DAO;

public class Clientes {

    private int id;
    private String nome;
     private String endereco;
      private String bairro;
       private String cidade;
        private String cep ;
    private String estado;
     private String referencia;
      private String cpf;
      private String identidade;
       private String telfixo ;
        private String celular; 
        private String numcartao;
        private String bandcartao;
    

    public Clientes(String nome,String endereco,String bairro,String cidade,String cep ,String estado, String referencia,String cpf,String identidade,String telfixo, String celular, String numcartao, String bandcartao ) {

       
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.identidade = identidade;
        this.telfixo = telfixo;
        this.celular = celular;
        this.numcartao = numcartao;
        this.bandcartao = bandcartao;
       
   
    }
    
   public Clientes(int id,String nome,String endereco,String bairro,String cidade,String cep ,String estado, String referencia,String cpf,String identidade,String telfixo, String celular, String numcartao, String bandcartao ) {

        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.identidade = identidade;
        this.telfixo = telfixo;
        this.celular = celular;
        this.numcartao = numcartao;
        this.bandcartao = bandcartao;
       
   
    }

    public Clientes (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
  
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getTelfixo() {
        return telfixo;
    }

    public String getCelular() {
        return celular;
    }

    public String getNumcartao() {
        return numcartao;
    }

    public String getBandcartao() {
        return bandcartao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public void setTelfixo(String telfixo) {
        this.telfixo = telfixo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNumcartao(String numcartao) {
        this.numcartao = numcartao;
    }

    public void setBandcartao(String bandcartao) {
        this.bandcartao = bandcartao;
    }

  
}

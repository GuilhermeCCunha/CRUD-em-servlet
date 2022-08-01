# CRUD-em-servlet


Site de venda de produtos online. O site possui uma área pública e outra
privada (restrita).

1) Na área pública.
A loja possui 4 categorias de produtos: Eletrodomésticos, informática, eletroportáteis e
smartphones. Cada produto pertence a uma única categoria e possui, ainda, um nome, uma
descrição e preço.


2) Na área restrita.
Essa área é destinada aos administradores do site, mediante um login.
Nessa área os administradores deverão dar manutenção aos dados do site, basicamente
operações de CRUD (Create, Read, Update e Delete) para as tabelas:
- Categoria (id, descrição)
- Produto (id, idcategoria, nome, descrição, valor)
- Clientes (id, nome, endereço, bairro, cidade, CEP, estado (UF), referência, CPF, RI (identidade), Telefone fixo, Celular, Número do cartão de crédito, Bandeira do cartão de crédito (Visa, Mastercard...))
- Compras (id, idcliente, idproduto)
- Administrador (id, login, senha)

3) Instruções
- Este projeto já faz um tempo que eu criei, mas foi testado recentemente, para ele funcionar é necessário ter o NetBeans IDE instalado, 
eu testei com a versão 14 e com o Java JDK 17, incluí o Java EE Web 8 API Library, nas bibliotecas do projeto, eu também usei o Apache Tomcat 8.5.81 
e o Java DB para o banco de dados do projeto, é necessário incluir o driver do BD nas bibliotecas do projeto, adicione Java DB Driver - derby.jar, Java DB Driver - derbyclient.jar, Java DB Driver - derbynet.jar, eu usei o driver na versão 10.2.2.0, o nome do banco de dados deste projeto é jdbc:derby://localhost:1527/alomundodb, 
Usuário = usuario, Senha = 12345, para criar as tabelas do banco de dados é só copiar os comando que estão escritos nos arquivos txt e executar para criar as tabelas e inserir um administrador padrão e as categorias de produtos ao banco de dados.

- Após fazer o build do projeto e conectar o banco de dados, o site estará disponível em http://localhost:8080/EX21
- Para acessar a Área Restrita digite em Login: admin e digite em Senha: 1234, esse administrador já foi criado no momento da inserção no banco de dados, mas é possível alterar o login e a senha do administrador na opção Listar os Administradores dentro da Área Restrita.
     

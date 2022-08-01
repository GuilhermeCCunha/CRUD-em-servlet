# CRUD-em-servlet


Site de venda de produtos online. O site possui um área publica e outra
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
- Clientes (id, nome, endereço, bairro, cidade, cep, estado (UF), referência, CPF, RI (identidade), Telefone fixo, Celular, Número do cartão de crédito, Bandeira do cartão de crédito (visa, mastercard...))
- Compras (id, idcliente, idproduto)
- Administrador (id, login, senha)

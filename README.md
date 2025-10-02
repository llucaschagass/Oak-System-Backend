# Oak System API 🌳

## 📝 Descrição do Projeto

Este projeto é o **back-end (API)** para um sistema de controle de estoque, desenvolvido como parte de um trabalho acadêmico. A arquitetura é baseada em serviços, onde esta API RESTful fornece todas as funcionalidades de negócio para gerenciar o estoque de uma empresa comercial.

A API permite:
- Cadastro, edição, consulta e exclusão de produtos e categorias via endpoints REST.
- Controle de movimentações de entrada e saída de estoque.
- Geração de dados para relatórios de gestão e tomada de decisão.

## 🛠️ Tecnologias e Ferramentas Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL
- **Build Tool:** Apache Maven
- **Servidor:** Apache Tomcat (Embutido no Spring Boot)
- **Documentação da API:** Swagger / OpenAPI 3 (via Springdoc)
- **Controle de Versão:** Git + GitHub

## ⚙️ Funcionalidades Implementadas (e Planejadas)

- **CRUD de Categorias** via API REST (`/api/categorias`)
- **CRUD de Produtos** via API REST (`/api/produtos`)
- **Movimentação de Estoque (Entrada/Saída)**
- **Reajuste de preços em massa por percentual**
- **Endpoints para geração de relatórios:**
  - Lista de Preços
  - Balanço Físico/Financeiro
  - Produtos abaixo da quantidade mínima
  - E outros...

## 📖 Documentação da API (Swagger)

A API possui uma documentação interativa gerada automaticamente com o Swagger. Através dela, é possível ver todos os endpoints disponíveis, seus parâmetros, os modelos de dados e **testar a API diretamente pelo navegador**.

Com a aplicação rodando, acesse:
- **Swagger UI (Interface Gráfica):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Definição OpenAPI (JSON):** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🧱 Estrutura do Projeto

O projeto segue a arquitetura em camadas padrão do Spring Boot:

- `src/main/java/br/com/oaksystem/oaksystem`: Pacote raiz da aplicação.
  - `/model`: Classes de entidade que mapeiam as tabelas do banco (@Entity).
  - `/repository`: Interfaces do Spring Data JPA para acesso aos dados.
  - `/service`: Camada que contém as regras de negócio da aplicação.
  - `/controller`: Camada que expõe os endpoints da API REST (@RestController).
- `src/main/resources/application.properties`: Arquivo de configuração principal (conexão com banco, porta do servidor, etc.).
- `pom.xml`: Arquivo de configuração do Maven, onde são gerenciadas as dependências do projeto.

## 📁 Como Executar o Projeto

### Pré-requisitos

- Java JDK 21 ou superior
- Apache Maven 3.6 ou superior
- MySQL Server 8 ou superior (instalado e em execução)
- Um cliente Git

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO_AQUI]
    cd Oak-System-API
    ```

2.  **Configure o banco de dados:**
    - Certifique-se de que seu servidor MySQL esteja rodando.
    - Crie o banco de dados `oaksystem_db` através de um cliente MySQL (Workbench, DBeaver, etc.).
      ```sql
      CREATE DATABASE oaksystem_db;
      ```
    - Execute o script SQL do banco de dados para criar as tabelas e popular com dados iniciais.

3.  **Configure a conexão da API:**
    - Abra o arquivo `src/main/resources/application.properties`.
    - Ajuste as seguintes propriedades com suas credenciais do MySQL:
      ```properties
      spring.datasource.username=seu_usuario_mysql_aqui
      spring.datasource.password=sua_senha_mysql_aqui
      ```

4.  **Execute a aplicação:**
    - A forma mais simples é pelo terminal, na pasta raiz do projeto:
      ```bash
      # No Windows (CMD ou PowerShell)
      mvnw.cmd spring-boot:run

      # No Linux ou macOS
      ./mvnw spring-boot:run
      ```
    - Alternativamente, importe o projeto como um projeto Maven em sua IDE (IntelliJ/Eclipse) e execute a classe principal `OakSystemApplication.java`.

5.  **Verifique se a API está no ar:**
    - Após a inicialização, acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) no seu navegador.
SGA - Sistema de Gestão Acadêmica

🎯 Objetivo do Projeto
Desenvolvimento de uma aplicação web para a gestão centralizada de alunos, cursos, disciplinas e matrículas em uma instituição de ensino. O sistema visa substituir processos manuais, garantindo a integridade dos dados e a eficiência administrativa.

🚀 Funcionalidades Implementadas

O sistema atende aos requisitos funcionais propostos, permitindo:

Gestão de Cursos: Cadastro, Edição e Exclusão (CRUD Completo) com validação de integridade.

Gestão de Alunos: Cadastro completo com vínculo a Cursos.

Gestão de Disciplinas: Organização da grade curricular por curso.

Matrículas: Sistema de vínculo acadêmico (Aluno x Disciplina).

Relatórios Gerenciais: Dashboard com totalizadores e listas analíticas de ocupação.

💻 Tecnologia Utilizada
Linguagem: Java 17

Framework: Spring Boot 3.x

Persistência: Spring Data JPA / Hibernate

Banco de Dados: MySQL

Frontend: HTML5 / Thymeleaf / Bootstrap 5

Ferramenta de Build: Apache Maven

👥 Equipe
Gustavo Cerqueira Bonfim Oliveira - Matrícula: 202303392877

🛠️ Como Executar o Projeto
Clonar o Repositório:

Bash

git clone https://github.com/smpguga/sga-projeto-poo-java-gustavoc
Configurar o Banco de Dados:

Abra o MySQL Workbench (ou terminal).

Crie um banco de dados vazio chamado sga_db:

SQL

CREATE DATABASE sga_db;
(Nota: As tabelas serão criadas automaticamente pelo Hibernate ao iniciar a aplicação).

Ajustar as Propriedades:

Abra o arquivo src/main/resources/application.properties.

Edite a linha spring.datasource.password com a sua senha do MySQL local.

Rodar a Aplicação:

No IntelliJ, execute a classe DemoApplication.java.

Ou via terminal: mvn spring-boot:run.

Acessar:

Abra o navegador em: http://localhost:8080/

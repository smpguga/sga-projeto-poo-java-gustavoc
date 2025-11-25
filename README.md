# SGA - Sistema de Gestão Acadêmica

## 🌐 Demonstração Online (Deploy)
O projeto está hospedado e rodando em ambiente de produção (Nuvem). Você pode testar a aplicação diretamente pelo navegador sem necessidade de instalação:

👉 **(https://sga-projeto-poo-java-gustavoc-production.up.railway.app/)**

---

## 🎯 Objetivo do Projeto
Desenvolvimento de uma aplicação web para a gestão centralizada de alunos, cursos, disciplinas e matrículas em uma instituição de ensino. O sistema visa substituir processos manuais, garantindo a integridade dos dados e a eficiência administrativa.

## 🚀 Funcionalidades Implementadas
O sistema atende aos requisitos funcionais propostos, permitindo:
- **Gestão de Cursos:** Cadastro, Edição e Exclusão (CRUD Completo).
- **Gestão de Alunos:** Cadastro completo com vínculo a Cursos.
- **Gestão de Disciplinas:** Organização da grade curricular.
- **Matrículas:** Sistema de vínculo acadêmico (Aluno x Disciplina).
- **Relatórios Gerenciais:** Dashboard com totalizadores e listas analíticas.

## 💻 Tecnologia Utilizada
- **Linguagem:** Java 17
- **Framework:** Spring Boot 3.x
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL
- **Deploy/Hospedagem:** Railway
- **Frontend:** HTML5 / Thymeleaf / Bootstrap 5

## 👥 Equipe
- **Gustavo Cerqueira Bonfim Oliveira** - Matrícula: 202303392877

## 🛠️ Como Executar Localmente (Opcional)
Caso queira rodar o projeto em sua máquina local em vez de acessar o link online:

1. **Clonar o Repositório:**
   `git clone https://github.com/smpguga/sga-projeto-poo-java-gustavoc`

2. **Configurar o Banco de Dados:**
    - Crie um banco de dados vazio no MySQL chamado `sga_db`.

3. **Ajustar as Propriedades:**
    - No arquivo `src/main/resources/application.properties`, ajuste a senha do MySQL local.

4. **Rodar a Aplicação:**
    - Execute a classe `DemoApplication.java` no IntelliJ.
    - Acesse: http://localhost:8080/
**Universidade Federal da Paraíba - UFPB** \
**Centro de Ciências Exatas e Educação - CCAE** \
**Departamento de Ciências Exatas - DCX**

**Professor:** [Matheus Barbosa](https://github.com/barbosamaatheus)
---

# Projeto JavaFX – Tela de Registro e Login  

Este projeto contém uma aplicação JavaFX simples com **duas telas principais**:
- Tela de **Registro**  

O objetivo é que os(as) alunos(as) compreendam como funciona a criação de interfaces gráficas com JavaFX, navegação entre telas e manipulação de dados.  

---

## Atividades Propostas  

Implemente as seguintes melhorias e extensões no projeto:  

1. **Tela de Login**
   - Criar uma tela de login com campos para e-mail e senha, além de mensagens de erro para cada campo.
   - Implementar um **controller** responsável por capturar os dados, chamar o serviço de login e exibir mensagens de sucesso ou erro.
   - Criar um **serviço de login** que valide os campos, consulte o repositório de usuários e autentique o login.
   - Usar o **repositório de usuários** já existente para buscar os dados de autenticação.
- **Dica:** o `RegisterController` já possui um método pronto para redirecionar para a tela de login (Está comentado). Se a tela e o controller de login forem implementados corretamente, esse redirecionamento deve funcionar automaticamente.

2. **Tela de Boas-vindas**  
   - Após login bem-sucedido, redirecionar o usuário para uma tela com uma mensagem de boas-vindas.  
   - Exibir o nome do usuário que acabou de logar.  

3. **Redirecionamento Login/Cadastro**  
   - Implementar um link direto entre as telas de login e cadastro e de cadastro para login.  


--- 
## Ferramentas Recomendadas

Para facilitar a criação e edição das telas em FXML, recomendamos o uso do **Scene Builder**:  
🔗 [Download do Scene Builder (Gluon)](https://gluonhq.com/products/scene-builder/) 
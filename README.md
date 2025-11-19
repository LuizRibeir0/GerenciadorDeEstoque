# 📦 Gerenciador de Estoque – Doce Vida

Sistema de gerenciamento de estoque desenvolvido em **Java**, usando **Spring Boot** no backend e **Swing** no frontend.  
Ideal para pequenos comércios que precisam controlar produtos, entradas, saídas e manter tudo salvo em banco de dados **H2** local.

---

<div align="center">

### 🖼️ Banner do Projeto  
<img src="https://via.placeholder.com/1100x280.png?text=Gerenciador+de+Estoque+-+Doce+Vida" />

</div>

---

## ⭐ Resumo do Projeto

O sistema permite:

- Cadastrar produtos  
- Listar itens cadastrados  
- Registrar entrada e saída de estoque  
- Validar saldo automaticamente  
- Salvar tudo de forma persistente usando H2  
- Interface simples e intuitiva em Swing  

---

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17-red?logo=java&style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen?logo=springboot&style=for-the-badge)
![Swing](https://img.shields.io/badge/Swing-UI-blue?style=for-the-badge)
![H2 Database](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven&style=for-the-badge)

---

# 🖼️ Demonstração das Telas

## 🧭 Tela Principal
<div align="center">
<img width="617" height="556" alt="Image" src="https://github.com/user-attachments/assets/c9454c91-c331-4ccb-9bcb-d713a87bbe8e" />
</div>

---

## 📋 Cadastro de Produto
<div align="center">
<img width="427" height="407" alt="Image" src="https://github.com/user-attachments/assets/f135b21d-0106-4349-b9eb-efdec4524f39" />
</div>

---

## 📦 Listagem de Produtos
<div align="center">
<img width="583" height="392" alt="Image" src="https://github.com/user-attachments/assets/2296cfe1-f134-4ed3-b89e-c109b9fcafd1" />
</div>

---

## ➕ Entrada de Estoque
<div align="center">
<img width="616" height="419" alt="Image" src="https://github.com/user-attachments/assets/be9c9247-ceff-4b2a-97e6-7826ef4de344" />
</div>

---

## ➖ Saída de Estoque
<div align="center">
<img width="569" height="414" alt="Image" src="https://github.com/user-attachments/assets/764f317f-c825-42c5-9de3-7b74436aa6d1" /></div>

---

# ⚙️ Como Executar

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo
2️⃣ Rodar o projeto
bash
Copiar código
mvn spring-boot:run
A interface Swing abrirá automaticamente após o backend iniciar.

🗄️ Configuração do Banco H2
O projeto usa um banco persistido em arquivo:

ini
Copiar código
spring.datasource.url=jdbc:h2:file:./data/estoque;AUTO_SERVER=TRUE
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
Console H2
Acesse:

👉 http://localhost:8080/h2-console

JDBC URL: jdbc:h2:file:./data/estoque
Usuário: sa
Senha: (vazia)

---

📚 Estrutura do Projeto
css
Copiar código
src/main/java/com/docevida/GerenciadorDeEstoque
│
├── model/        → Entidades (Produto)
├── repository/   → Interface JPA
├── service/      → Regras de negócio
└── view/         → Telas Swing (UI Desktop)
✔️ Funcionalidades
Cadastro de produtos

Atualização de estoque (entrada/saída)

Validação de quantidade

Listagem detalhada

Persistência automática

👨‍💻 Autor
Luizão
Desenvolvedor Java | Spring Boot
Sempre buscando novos desafios 🚀

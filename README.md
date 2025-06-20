# QA Automation Framework - Java + Selenium + RestAssured + Cucumber

Este projeto é um framework de automação de testes baseado em:

- 💻 Java 17
- 🌐 Selenium WebDriver (para testes Web UI)
- 🧪 RestAssured (para testes de API)
- 🥒 Cucumber (para BDD com steps legíveis)
- 🧰 Maven (gerenciador de dependências)
- 🧠 Page Object Model (padrão de design)
- 🔄 WebDriverManager (sem precisar baixar drivers)

---

## 📁 Estrutura

```
src
├── main
│   └── java
│       └── utils           # DriverFactory e helpers
├── test
│   ├── java
│   │   ├── steps           # Steps do Cucumber
│   │   ├── pages           # Page Objects
│   │   ├── api             # Testes de API
│   │   └── runners         # Test Runner
│   └── resources
│       └── features        # .feature files do Cucumber
```

---

## 🚀 Como rodar

### Pré-requisitos

- Java 17+
- Maven
- Git

### Para executar todos os testes:

```bash
mvn clean test
```

---

## 🌐 Teste Web

O teste de login automatizado acessa uma página pública de prática de QA:
`https://practicetestautomation.com/practice-test-login/`

Com suporte a múltiplos cenários (validação positiva e negativa) com Cucumber Scenario Outline.

---

## 🔌 Teste de API

Testes de GET e POST usando `jsonplaceholder.typicode.com` e `reqres.in`, com validação de status e conteúdo da resposta.

---

## ⚙️ Configuração

As URLs e parâmetros podem ser configurados no arquivo `config.properties`.

---

## 💡 Futuras melhorias

- Relatórios HTML customizados
- Execução paralela
- Integração com Jenkins e Docker
- Testes com dados externos (CSV/JSON)
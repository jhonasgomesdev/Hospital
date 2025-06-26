# 🏥 Hospital Management API

Um sistema completo de gestão hospitalar em API desenvolvido como projeto acadêmico na Unilasalle, proposto pelo Professor Thiago. Embora implementado em Spring Boot, a arquitetura enfatiza princípios universais de backend aplicáveis a qualquer stack tecnológica.

## 🌟 Key Features

- **API RESTful** seguindo padrões do mercado
- **Domain-Driven Design** com relacionamentos claros entre entidades
- **Documentação profissional** via Swagger UI
- **Validações de dados** (CRM/CPF únicos, controle de status de consultas)
- **Arquitetura limpa** com separação de responsabilidades

## 🛠️ Core Implementation Details

```
src/
├── controller/    # API endpoints
├── model/         # Business entities
├── repository/    # Data persistence
├── dto/           # Data transfer objects
├── mapper/        # Entity-DTO conversion
└── config/        # API documentation setup
```

## 💡 Universal Backend Concepts Demonstrated

- **Proper API Documentation** (Swagger/OpenAPI)
- **DTO Pattern** for data transfer
- **Repository Pattern** for data access
- **Dependency Injection**
- **Relational Data Modeling**

## 🚀 Getting Started

1. **Requirements**:
   - Java 17+
   - PostgreSQL
   - Maven

2. **Setup**:
   ```bash
   git clone https://github.com/jhonasgomesdev/Hospital.git
   mvn spring-boot:run

## 📊 Esquema do Banco de Dados

### Principais Tabelas
- `medicos` (CRM, nome, especialidade)  
- `pacientes` (CPF, convenio)  
- `consultas` (relaciona médicos e pacientes)  

## 🤝 Troca de Ideias

Apesar de ser um projeto acadêmico, adoraria conversar sobre:
- Como implementar essa mesma arquitetura em .NET
- Melhorias na modelagem do banco de dados
- Experiências com Swagger em outras linguagens

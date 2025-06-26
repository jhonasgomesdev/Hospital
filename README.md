# 🏥 Hospital Management API

A complete hospital management system API developed as an academic project at Unilasalle, proposed by Professor Thiago. While implemented in Spring Boot, the architecture emphasizes **universal backend principles** applicable to any tech stack.

## 🌟 Key Features

- **RESTful API** following industry standards
- **Domain-Driven Design** with clear entity relationships
- **Professional API Documentation** via Swagger UI
- **Data Validation** (unique CRM/CPF, appointment status control)
- **Clean Architecture** with separation of concerns

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

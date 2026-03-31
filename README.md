# 📏 Quantity Measurement Application

A modular, extensible **Java-based Quantity Measurement System** evolved from core OOP design to a **full Spring Boot RESTful application** through structured use cases (UC1 → UC17).

This project demonstrates how a clean domain model can scale from plain Java → N-Tier Architecture → JDBC Integration → Spring Boot API.

---

## 🚀 Evolution Journey (UC1 → UC17)

| Use Case | Evolution Stage | Feature Implemented |
|----------|------------------|----------------------|
| UC1–UC3  | Core Java        | Basic unit equality |
| UC4–UC6  | Core Java        | Unit conversion logic |
| UC7–UC9  | Core Java        | Arithmetic operations |
| UC10     | Core Java        | Target unit specification |
| UC11     | Core Java        | Volume & Weight support |
| UC12     | Core Java        | Temperature handling |
| UC13     | Refactoring      | Architectural extensibility |
| UC14     | Refactoring      | Clean separation of units & quantities |
| UC15     | N-Tier Arch      | Layered architecture (Controller → Service → Repository) |
| UC16     | JDBC Integration | Database persistence using JDBC |
| UC17     | Spring Boot      | REST APIs with Spring Boot |

---

## 🧱 Current Capabilities (Spring Boot Version)

✅ REST APIs for quantity operations  
✅ Cross-unit equality comparison  
✅ Automatic unit conversion  
✅ Arithmetic operations with target unit output  
✅ JDBC-based persistence layer  
✅ Clean N-Tier architecture  
✅ JUnit testing with EPS precision handling  

---

## 📚 Supported Measurement Domains

### 📏 Length
- Feet, Inch, Yard, Centimeter

### ⚖️ Weight
- Gram, Kilogram, Tonne

### 🧪 Volume
- Litre, Millilitre, Gallon

### 🌡️ Temperature
- Celsius, Fahrenheit

---

## 🏗️ Architectural Highlights

- Interface-driven abstraction using `IMeasurable`
- Encapsulation & Polymorphism
- EPS-based floating point precision handling
- N-Tier Architecture (Controller, Service, Repository)
- JDBC integration for persistence
- Spring Boot RESTful exposure of the domain logic
- Highly extensible design for adding new measurement types

---

## 🧪 Test-Driven Development

- JUnit test cases written alongside use cases
- Precision-safe equality assertions
- Cross-unit and arithmetic validation
- Edge case handling

---

## 🛠️ Tech Stack

- Java
- JDBC
- Spring Boot
- JUnit
- Maven

---

## 📌 Future Scope

- Authentication & Authorization
- Swagger API documentation
- Adding new measurement domains (Time, Area)
- Frontend UI for interaction

---

⭐ This project showcases the complete journey from **core Java design** to **enterprise-level Spring Boot application**, maintaining clean architecture and scalability throughout.

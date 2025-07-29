# 📦 Microservicio de Inventario y Productos - Prueba Técnica Backend

Este proyecto implementa una arquitectura de microservicios en **Java** con **Spring Boot**, **Docker** y **PostgreSQL**. Se ha avanzado hasta el **flujo de compra** de la prueba técnica, dejando lista:

- La infraestructura con `Docker Compose`
- Los microservicios separados
- La configuración y persistencia con PostgreSQL
- El esqueleto del flujo de compra

🔧 **Queda pendiente**:
- Implementar autenticación entre servicios (API Key)
- Agregar pruebas unitarias e integración
- Documentar APIs (Swagger/Postman)
- Diagramas y análisis técnico final

---

## 🚀 ¿Cómo ejecutar el proyecto?

### 1️⃣ Requisitos previos

- 🐳 [Docker Desktop](https://www.docker.com/products/docker-desktop) instalado
- ☕ Java 17 (para desarrollo local)
- 📦 Maven instalado

---

### 2️⃣ Clonar el repositorio

```bash
git clone https://github.com/Dreckor/LinkticPrueba.git
cd LinkticPrueba
```

### 3️⃣ Construir los JARs
📁 Desde cada microservicio (productos/ e inventario/):
```
cd productos
mvn clean package -DskipTests

cd ../inventario
mvn clean package -DskipTests
```

### 4️⃣ Levantar los contenedores

```
docker-compose up --build
```

#  Requisitos Técnicos - Prueba Técnica Backend

## Descripción general

Se desarrolló una API REST en Java con Spring Boot para gestionar una colección de películas a partir de un archivo CSV. La solución incluye Swagger para documentación, pruebas unitarias, contenedorización con Docker y despliegue automático en AWS EC2 usando GitHub Actions.

---

## 🔧 Tecnologías utilizadas

| Componente       | Tecnología                       |
|------------------|----------------------------------|
| Lenguaje         | Java 17                          |
| Framework        | Spring Boot 3.x                  |
| Dependencias     | Spring Web, Lombok, OpenAPI      |
| Construcción     | Maven                            |
| Contenedores     | Docker                           |
| CI/CD            | GitHub Actions                   |
| Infraestructura  | AWS EC2 (Ubuntu 22.04, Free Tier)|
| Documentación    | Swagger (Springdoc OpenAPI)      |

---

##  Funcionalidad de la API

- `GET /movies/{id}` → Consultar película por ID.
- `GET /movies?total=5&order=asc` → Listar películas ordenadas.
- `POST /movies` → Agregar nueva película.

---

##  Requisitos para ejecución local

1. Java 17
2. Maven
3. Docker (opcional)
4. Archivo CSV en `src/main/resources/movies.csv`

---

##  Instrucciones de uso

### A. Ejecución local

```bash
./mvnw spring-boot:run

# Ligas deportivas — API REST

Backend del proyecto final de la materia (UPIIZ-IPN): una API para administrar ligas deportivas con equipos, jugadores, entrenadores y partidos. El frontend está en [Proyecto-Final](https://github.com/gaelg22/Proyecto-Final).

## Stack

Java 21 · Spring Boot 3 · Spring Security + JWT · Spring Data JPA · PostgreSQL / MySQL · Swagger (springdoc) · Docker · Render

## Qué tiene

- CRUD de **ligas, equipos, jugadores, entrenadores y partidos** con DTOs para las peticiones.
- **Login y registro con JWT**: los `GET` son públicos y crear, editar o borrar requiere token.
- Arquitectura por capas: `controllers → services → repositories → entities`.
- Documentación con **Swagger UI** en `/swagger-ui.html`.
- `DataLoader` que llena la base con datos de ejemplo al arrancar.
- Dockerfile multi-stage (build con Maven y runtime ligero) para desplegar en Render.

## Endpoints principales

| Método | Ruta | Auth |
|---|---|---|
| POST | `/api/auth/register`, `/api/auth/login` | no |
| GET | `/api/ligas`, `/api/equipos`, `/api/jugadores`, `/api/entrenadores`, `/api/partidos` | no |
| POST / PUT / DELETE | mismas rutas (`/{id}` para editar y borrar) | JWT |

## Correrlo

```bash
./mvnw spring-boot:run
# o con Docker
docker build -t ligas-api . && docker run -p 8080:8080 ligas-api
```

Configura la conexión a la base y el secreto JWT en `src/main/resources/application.properties`.

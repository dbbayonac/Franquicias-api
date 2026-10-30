# API de franquicias

API REST construida con Java 17, Spring Boot 3, Spring Data JPA y MySQL.

## Ejecución con Docker

Requisitos: Docker y Docker Compose.

```bash
docker compose up --build -d
```

La API queda disponible en `http://localhost:8080`. Para detenerla: `docker compose down`.

## Ejecución local

Iniciar MySQL en localhost:3306 con usuario `root`, contraseña `root` (o configurar `DB_URL`, `DB_USER` y `DB_PASSWORD`). Ejecutar `mvn spring-boot:run` con Java 17 y Maven instalados.

## Endpoints

| Método | Ruta | JSON de ejemplo |
|---|---|---|
| POST | `/api/franquicias` | `{"nombre":"Mi Franquicia"}` |
| POST | `/api/franquicias/1/sucursales` | `{"nombre":"Centro"}` |
| POST | `/api/sucursales/1/productos` | `{"nombre":"Café","stock":30}` |
| DELETE | `/api/sucursales/1/productos/1` | sin cuerpo |
| PATCH | `/api/productos/1/stock` | `{"stock":50}` |
| GET | `/api/franquicias/1/productos-max-stock` | sin cuerpo |
| PATCH | `/api/franquicias/1/nombre` | `{"nombre":"Nuevo nombre"}` |
| PATCH | `/api/sucursales/1/nombre` | `{"nombre":"Nueva sucursal"}` |
| PATCH | `/api/productos/1/nombre` | `{"nombre":"Nuevo producto"}` |

La consulta de máximo stock retorna un producto por sucursal que tenga productos, indicando sucursal y stock. En caso de empate selecciona uno de los máximos. Los stocks negativos se rechazan con HTTP 400 y los recursos inexistentes con HTTP 404.

## Git

Subir el proyecto a un repositorio público con `git init`, `git add .`, `git commit -m "Implementar API de franquicias"` y configurar el remoto de GitHub.

## Mejoras posibles

Pruebas automatizadas, migraciones Flyway, Swagger/OpenAPI, credenciales mediante secretos y despliegue en nube. Las contraseñas del compose son exclusivamente para desarrollo local.

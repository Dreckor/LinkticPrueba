#!/bin/sh
echo "Esperando a que PostgreSQL esté disponible para Productos..."

until nc -z postgres_db 5432; do
  sleep 1
done

echo "PostgreSQL disponible. Iniciando aplicación..."
exec java -jar /app/productos.jar
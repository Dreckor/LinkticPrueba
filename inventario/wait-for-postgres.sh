#!/bin/sh
echo "Esperando a que PostgreSQL esté disponible para Inventario..."

until nc -z postgres_db 5432; do
  sleep 1
done

echo "PostgreSQL disponible. Iniciando Inventario..."
exec java -jar /app/inventario.jar
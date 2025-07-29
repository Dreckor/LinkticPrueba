FROM openjdk:17-jdk-alpine
COPY target/inventario-0.0.1-SNAPSHOT.jar /app/inventario.jar
COPY wait-for-postgres.sh /wait-for-postgres.sh
RUN chmod +x /wait-for-postgres.sh
ENTRYPOINT ["/wait-for-postgres.sh"]
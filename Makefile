init:
	docker compose down && \
	docker compose up -d && \
	mvn clean spring-boot:run -Dspring-boot.run.profiles=init,dev

cluster:
	docker compose down && \
	docker compose up -d && \
	mvn clean spring-boot:run  -Dspring-boot.run.profiles=dev

# cluster:
# 	docker compose down && \
# 	mvn clean package && \
# 	docker compose up

purge:
	docker compose down -v
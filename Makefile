init:
	docker compose down && \
	docker compose up -d && \
	./mvnw clean spring-boot:run -Dspring-boot.run.profiles=init,dev

cluster:
	docker compose down && \
	docker compose up -d && \
	./mvnw clean spring-boot:run  -Dspring-boot.run.profiles=dev

# cluster:
# 	docker compose down && \
# 	./mvnw clean package && \
# 	docker compose up

down:
	docker compose down

purge:
	docker compose down -v
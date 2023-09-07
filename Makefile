init:
	docker compose stop && \
	docker compose start -d && \
	./mvnw clean spring-boot:run -Dspring-boot.run.profiles=init,dev

cluster:
	docker compose stop && \
	docker compose start -d && \
	./mvnw clean spring-boot:run  -Dspring-boot.run.profiles=dev

# cluster:
# 	docker compose down && \
# 	./mvnw clean package && \
# 	docker compose up

stop:
	docker compose stop

down:
	docker compose down

purge:
	docker compose down -v
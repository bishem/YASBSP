dev:
	printf "\e[0;33mWARNING : Current configuration requires JAVA 17 to be installed \e[0;37m\n" && \
	docker compose -f docker-compose.dev.yml down --remove-orphans && \
	docker compose -f docker-compose.dev.yml up -d && \
	./mvnw clean spring-boot:run -Dspring-boot.run.profiles=init,dev

cluster:
	docker compose down --remove-orphans && \
	./mvnw clean package && \
	docker compose up

down:
	docker compose down --remove-orphans

purge:
	docker compose down -v --remove-orphans
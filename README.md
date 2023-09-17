Simple microservices echosystem sample.
Services are built with Spring Boot 3.1.3, and consist of:
- Department Service (to store and retrieve departments' info)
- Employee Service (to store and retrieve employees' info)
- Configuration Server (to store all services configurations natively)
- Service Registry (using Eureka service to register all services and monitor their status)
- Api Gateway (to re-direct http requests to their respective services without directly calling their endpoints)

This sample uses Zipkin to monitor queries and show logs.
DB is H2 embedded database for testing purposes.

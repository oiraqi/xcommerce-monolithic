# XCommerce SOA Monolithic - Spring Boot
This is the server-side of the enterprise-class XCommerce application based on a monolithic-mvc-soa architecture. It is written in Java and leverages Spring Boot as a highly productive, opinionated enterprise application development and production environment. Spring Boot orchestrates several technologies powering XCommerce Monolithic, namely JPA, Hibernare, PostgreSQL, Redis, REST and JWT.

This is part of the overarching [XCommerce](https://github.com/oiraqi/xcommerce) project. Other sibiling sub-projects are:
- [XCommerce Standalone (C)](https://github.com/oiraqi/xcommerce-standalone-c)
- [XCommerce Cloud Microservices (Spring Cloud)](https://github.com/oiraqi/xcommerce-microservices)
- [XCommerce PWA (Angular)](https://github.com/oiraqi/xcommerce-client-angular)

**You're welcome to contrbute through your favourite monolithic or microservices back-end technology and/or front-end technology!**

**The *progress* folder**: In every semester, the author rewrites the code with his students. The *progress* folder reflects where they are now. It is reinitialized in the beginning of each Fall (September 1st) and Spring (January 1st).

**Starting point**
- Clone this repository
- Depending on the stage you would like to work on, cd [ *initial* | *progress* | *final* ]
- ./gradlew build
- There you go!

**You need to install Docker, then run these commands**
- docker pull redis
- docker pull postgres
- docker run --name redis-container -p 6379:6379 -d redis
- docker run --name postgres-container -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
- docker exec -it postgres-container psql -U postgres
- create database xcommerce

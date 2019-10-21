# XCommerce Monolithic - Spring
This is the core module of the enterprise-class XCommerce application based on a monolithic-mvc-soa architecture. It is written in Java and leverages Spring Boot as a highly productive, opinionated enterprise application development and production environment. Spring Boot orchestrates several technologies powering XCommerce Monolithic, namely JPA (on top of Hibernare and Postgres), Redis and REST.

The overarching XCommerce project is accessible here: https://github.com/oiraqi/xcommerce. Other sibiling sub-projects are:
- XCommerce Web JSF: https://github.com/oiraqi/xcommerce-microservices
- XCommerce Web JSF: https://github.com/oiraqi/xcommerce-web-jsf
- XCommerce Web Django: https://github.com/oiraqi/xcommerce-web-django
- XCommerce Web Node/Express: https://github.com/oiraqi/xcommerce-web-node
- XCommerce PWA Angular: https://github.com/oiraqi/xcommerce-web-angular

**You're welcome to contrbute through your favourite monolithic, microservices and/or front-end technology!**

**The *progress* folder**: In every semester, the author rewrites the code with his students. The *progress* folder reflects where they are now. It is reinitialized in the beginning of each Fall (September 1st) and Spring (January 1st).

**Starting point**
- Clone this repository
- Depending on the stage you would like to work on, cd [ *initial* | *progress* | *final* ]
- ./gradlew build
- There you go!

**You need**
- Docker installed
- docker pull postgres
- docker pull redis
- docker run --name postgres-container -e POSTGRES_PASSWORD=postgres -d postgres
- Create a database called *xcommerce* on your *postgres-container*
- docker run --name redis-container -d redis

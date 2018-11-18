# PetRate

## First local run

- Clone project 

```
git clone git@github.com:couclock/petrate.git
```
- Start PostgreSQL database (ensure no other database is running)
```
cd petrate
docker-compose up
```
- Start SpringBoot backend (ensure no other process run on 8080 port)
```
mvn spring-boot:run
```
- Start VueJS frontend (ensure no other process run on 8081 port)
```
cd front
npm install && npm run serve
```
- Navigate to http://localhost:8081 and try that small project

## Local run using Docker

- What is it ? Cf https://fr.slideshare.net/NicolasMuller/docker-yajug
- Install Docker
- Switch your project on dockerfile branch
```
git checkout dockerfile
```

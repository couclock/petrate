# PetRate

## First local run

- Clone project 

```
git clone git@github.com:couclock/petrate.git
```
- Start PostgreSQL database (ensure no other database is running)
```
cd petrate
docker-compose start postgresql
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

## Local run using Docker

- What is it ? Cf https://fr.slideshare.net/NicolasMuller/docker-yajug
- Install Docker

### With dockerfile and docker-compose

- Explain why we want to use Docker to ease deployment
- Build docker images (and wait a moment)
```
docker-compose build front
docker-compose build back
```
- Start docker images
```
docker-compose up
```
- Navigate to http://localhost and try that small project

### With jib (https://github.com/GoogleContainerTools/jib)

- Image creation with traditionnal docker tool is slow and painfull => Jib 
- Build docker images 
```
docker-compose build front
mvn jib:dockerBuild
```
Each code update is now fast, all dependencies are not download anymore.
- Start docker images
```
docker-compose up
```
- Navigate to http://localhost and try that small project


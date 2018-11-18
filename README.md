# PetRate

# First local run

- Clone project 

```
git clone git@github.com:couclock/petrate.git
```
- Start PostgreSQL database (ensure no other database is running)
```
cd petrate
docker-compose up
```
- Start SpringBoot backend
```
mvn spring-boot:run
```
- Start VueJS frontend
```
cd front
npm install && npm run serve
```


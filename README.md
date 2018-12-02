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
- Explain why we use multi-stage Dockerfile : build on agnostic env
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

### With local Kubernetes (Minikube)

- Explain why docker orchestrator (Cf https://fr.slideshare.net/cfurmaniak/gdg-lilleintrotokubernetes)
- Install Minikube (https://kubernetes.io/docs/tasks/tools/install-minikube/)
- Launch minikube and set right docker environnement settings (to use minikube docker instance)

```
minikube start && eval $(minikube docker-env)
```

- Launch Kubernetes dashboard

```
kubectl proxy &
```

Navigate to http://127.0.0.1:8001/api/v1/namespaces/kube-system/services/http:kubernetes-dashboard:/proxy/

- Build docker images (and wait a moment) to get built images inside minikube env

```
docker-compose build
```

- Add containers to minikube

```
kubectl create -f kub/postgresql.yaml
kubectl create -f kub/back.yaml
kubectl create -f kub/front.yaml
```

- Check on dashboard there are 3 deployments and 3 services
- Open front service to get result

```
minikube service front
```

- On the bottom on the page, see the hostname of both front and back are switching between 2 replicas.

# Minikube

- Lancer minikube

```
minikube start
```

- Config de l'env

```
eval $(minikube docker-env)
```

- Pour voir le dashboard

```
kubectl proxy & minikube dashboard &
```

- Pour créer le deployment et service de la base

```
kubectl create -f kub/postgresql.yaml
```

- Pour créer le deployment et service du back

```
kubectl create -f kub/back.yaml
```

- Pour créer le deployment et service du fron

```
kubectl create -f kub/front.yaml
```

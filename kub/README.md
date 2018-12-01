- Pour voir le dashboard

```
kubectl proxy &
```

Pointer sur http://localhost:8001

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

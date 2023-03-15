# Deployments

In a production environment it is necessary to manage docker images fast and
reliably. Like updating container images, starting and stopping a release.
Rolling release of new images, roll back a new deploy fast.

# YAML

yaml for deployment are similar to ReplicaSet, but the kind is Deployment.
1. Create: `kubectl create -f manifests/deploy-examples.yml`    
2. List: `kubectl get deployments` || `kubectl get replicaset` || `kubectl get pods`      
3. List all: `kubectl get all`    

```
apiVersion: apps/v1
kind: Deployment
metadata:
    name: myapp-rs
    labels:
        app: myapp
        type: frontend
spec:
    template:
        metadata:
            name: myapp-pod
            labels:
                app: myapp
                type: frontend
        spec:
            containers:
            -   name: nginx-container
                image: nginx
    replicas: 3
    selector: 
        matchLabels:
            type: frontend
```

# Rollout and Version

When updating a container image to a newer version with k8, you only need to
specify the newer image version. Kubernetes takes care of managing individual
containers.
The rollout of the requested update can be done in two strategies:
1. Recreate : Destroy all pods and then recreate with the new version (not recommended)    
2. Rolling Update : Destroy and recreate each pod simultaneously (default)    


## Commands

1. Update: `kubectl apply -f manifests/deployment-example.yml`    
   1. record change cause in history with `--record`    
2. Status: `kubectl rollout status deployment/myapp-deploy`     
3. Rollback: `kubectl rollout undo  deployment/myapp-deploy`    
4. History: `kubectl rollout history deployment/mayapp-deploy`    





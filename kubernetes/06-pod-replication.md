# POD replication

Can be done with Replica Sets or Replication Controller(the controller is 
deprecated). If a POD fails then new one need to be created, or when the 
throughput increases new instances need to be created to handle the 
additional load.

# YAML

## Replication Controller

Create : `kubectl create -f manifests/rc-example.ym`
List : `kubectl get replicationcontrollers`
Delete : `kubectl delete replicationcontroller myapp-rc`
```
apiVersion: v1
kind: ReplicationController
metadata:
    name: myapp-rc
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
```

## Replica Set

The main difference of Replica Set is the selector field. Replication
Controller also has this field, but it assumes to be the labels of the pod
template. Replica Set can replicate other existing pods not declared in the 
template.

Create : `kubectl create -f manifests/rs-example.yml`
List : `kubectl get replicasets`
Delete : `kubectl delete replicasets myapp-rs` (and related pods)
Replace : `kubectl replace replicaset -f manifests/rs-example.yaml`
Scale : `kubectl scale  --replicas=6 -f replicaset-definition.yml` r
        `kubectl scale --replicas=6 replicaset myapp-rs` (will not update file)

```
apiVersion: apps/v1
kind: ReplicaSet
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

## Labels and Selectors

Replica set needs to know who it will monitor and replicate (if needed). It 
does that with a selector and matchLabels value. It will monitor pods with this
label and replicate when necessary.
If a pod with labels that match an existing selector of a replica set, the replica
set will terminate it.

##
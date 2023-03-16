# Services

As the file 08 describes, pods are in a private network,and requests to the
pod application are not mapped to a host automatically. Also how can we 
distribute requests evenly across all replica sets ? The answer is Services
There are a couple types of services, the first being NodePort

# NodePort
This services acts as a Proxy exposing a pod port to a host port between 30000
and 32767.
ports:
1. port : Service port
2. targetPort : port of the pods
3. nodPort : port that will be exposed to the host
   
When a NodePort is mapped  to many pods, than the load is distributed randomly.
1. Create : `kubectl create -f manifests/nodeport-example.yml`
2. List : `kubectl get services`
(to get the node url using minikube use `minikube service myapp-service --url`)

## YAML
```
apiVersion: v1
kind: Service 
metadata:
    name: myapp-service
spec:
    type: NodePort
    ports:
        - targetPort: 80 
          port: 80
          nodePort: 30008
    selector:
        matchLabels:
            app: myapp
            type: frontend
```

# ClusterIP
A complex infrastructure supported by k8 will eventually have communication
between services hosted on pods. This communication can not be done with ips
because they are not static, and a pod can be destroyed and recreates at any
given moment. To communicate with pods use ClusterIP.
With ClusterIP pods will be exposed to other pods by the id of the cluster 
of name of cluster.

## YAML

```
apiVersion: v1
kind: Service
metadata:
    name: back-end
spec:
    type: ClusterIP
    ports: 
        - port: 80
          targetPort: 80
    selector:
        app: myapp
        type: backend
```

# LoadBalancer
With NodePort all the single pods are exposed. But what we want is a single
ip and port to so the users can be routed to the proper pod. To do that in 
the cloud we use LoadBalancer (locally will be equivalent to NodePort), but
in the cloud will integrate with the environment and expose a single url to
be accessed.
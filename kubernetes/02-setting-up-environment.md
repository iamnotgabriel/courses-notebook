# Setup

To run k8 locally you will need:   
1. VM : to use a slave node    
2. minikube : to install everything on the slave node    

# Steps 

```
$ minikube start
$ kubectl create deployment hello-minikube --image=kicbase/echo-server:1.0
$ kubectl expose deployment hello-minikube --type=NodePort --port=8080
$ kubectl get services hello-minikube
$ kubectl port-forward service/hello-minikube 7080:8080
$ kubectl delete services hello-minikube
$ kubectl delete deployment hello-minikube
$ minikube stop
$ minikube delete
```

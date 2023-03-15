# Basic container architecture

Terms used in kubernetes
1. Node: A computer with kubernetes running containers (in the past minion)
2. Cluster: A group of connected pc running containers orchestrated by k8
3. Master: Responsible for orchestrating nodes and containers
   

# What is being installed with k8

1. API server : front-end for k8    
2. etcd : distributed key-value store with cluster data    
3. kubelet : agent monitors containers on a given node    
4. Container runtime : software used to run containers    
5. Controller : Brain behind orchestration, when a node fails it distribute the work to other nodes    
6. Scheduler : distribute load across nodes, assign containers to nodes    

# Master vs. Worker Nodes

Every node contains the container runtime to run nodes. The master node has
the api server interface. And the slaves contains the kubelet to  monitor the
status of the containers and report to master node. The master stores the data
in the etcd, uses the controller and  the scheduler.

# kubectl

Used to deploy and manage application on a kubernetes cluster. 
1. `kubectl run hello--minikube` : deploys application to the cluster
2. `kubectl cluster-info`: information about the node 
3. `kubectl get nodes`: list all nodes of the cluster

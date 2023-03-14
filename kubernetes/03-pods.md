# PODs

## Assumptions

There is a docker image of the application
There is a k8 cluster and running


## Nodes, containers and POD

Applications in the form of containers are not deployed directly on the node.
The containers are encapsulated into a k8 object aka POD. 
Each POD is a single instance of an application. When an application needs to
scale up with another instance, then a new pod is created to share the load.
A POD can have multiples containers of different kind. Containers in the same
POD can communicate through network using localhost and share same storage
space. Although possible this is not very common.

# Deploying PODs

To launche a new POD with a docker image, use `kubectl run nginx --image ngix`.
List of pods `kubectl get pods`, to see more information use 
`kubectl describe pod nginx`. This launches a new pod, but it is not available
to the network yet, to see the ip address of pods `kubectl get pods -o wide` 
can be used.



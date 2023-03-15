# PODs in yaml files
How to make yaml files for kubernetes. All k8 file contains in the top level:

1. apiVersion : version of kubernetes api
2. kind : type of the object created
3. metadata : information about the object
4. spec : container, image ... (changes according to the object)
   
```
apiVersion: 1
kind: Pod
metadata:
    name: myapp-pod
    labels:
        app: myapp
        type: front-end
spec:
    containers:
        - name: nginx-container
          image: nginx
```
To run this file as a command, use `kubectl -f pod-definition.yml`

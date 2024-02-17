# README
 This is a simple application for CRD operation on order - mainly for k8s deployment
 Here deploy postgresql and spring-boot application using configMap and secret 
## docker folder
    1. This folder has the jar file and Dockerfile
    2. Run the following command to create image 
        > docker build -t sample-kube-order-service .
    3. Check docker images by `docker images`

## k8s folder
    - postgresql-configMap.yaml: Non sensitive data like dbName and host declared here
    - postgresql-secrets.yaml: Sensitive information like db username and password store here
    - db-deployment.yaml: deployment and service objects are defined here. It's start a postgresql service using configMap and secret information
    - app-deployment.yaml: deployment and service object defined for the spring boot application

## deployment in kubernetes (Should follow the order)
    > minikube start
    > minikube docker-env
    - from the output run:
        > @FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env --shell cmd') DO @%i
    > docker build -t sample-kube-order-service .
    > kubectl apply -f postgresql-secrets.yaml
    > kubectl apply -f postgresql-configMap.yaml
    > kubectl apply -f db-deployment.yaml
    > kubectl apply -f app-deployment.yaml
    > minikube service sample-kube-order-service-svc
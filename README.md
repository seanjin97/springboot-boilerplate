# Springboot Project Template
## Description:
> Multi-modular middleware server for CRUD endpoints of [`FakeStoreAPI`](https://fakestoreapi.com/docs).

## Modules:
1. api
> This is where models and API definition interfaces are defined.
2. controller
> This is where controllers, services, dao, repositories & utils are created.
3. entrypoint
> This is where main class is.

---

## Run on localhost:
- ### Step by step
1. Check application-localhost.properties.
2. I recommend running `./mvnw clean install` (for linux/ mac) OR `mvnw clean install` (windows) before every application start. 
3. Run entrypoint > Entrypoint.java.
4. Go to [`localhost:8080/swagger-ui/`](http://localhost:8080/swagger-ui/) and test your APIs.

---

## Run on docker:
- ### Prerequisites
> 1. Docker running on your computer.
- ### Step by step
1. Check configurations in [`docker/config.env`](docker/config.env).
2. Build docker image locally and push to docker repository.
> bash docker/build.sh
3. Run docker image.
> bash docker/run.sh
4. Go to [`localhost:8080/swagger-ui/`](http://localhost:8080/swagger-ui/) and test your APIs.
---

## Run on local k8s cluster: 
- ### Prerequisites
> 1. Docker running on your computer.
> 2. [`k3d`](https://github.com/rancher/k3d) installed on your computer (faster and more efficient alternative to minikube) [`k3d docs`](https://k3d.io/).
> 3. Docker image pushed to remote docker repository.

- ### Step by step
1. Start k3d cluster
> k3d cluster create 
2. Apply k8s configs
> kubectl apply -f k8s (not done)
3. Delete cluster
> k3d cluster delete
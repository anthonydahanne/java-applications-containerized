# Using the Dockerfile

## Classic: build using maven, then package into an image

    ./mvnw package -DskipTests

    docker build -f src/main/docker/Dockerfile -t myapp .

## Multi stage build: 1 stage to build, other stage to package into an image

    docker build -f src/main/docker/Dockerfile.multi -t myapp .

## Run the container

    docker run -p 8080:8080 -it myapp:latest
# Build a maven project with buildpacks

## Simple, no binding

    pack build demo:0.0.1-SNAPSHOT --builder=paketobuildpacks/builder:0.1.87-base

## With ca-certificates binding and Liberica 16

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --env BP_JVM_VERSION=16 \
  --volume $PWD/binding/ca-certificates/:/platform/bindings/my-certificates \
  --builder=paketobuildpacks/builder:0.1.87-base
```


## With settings.xml binding

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env BP_MAVEN_BUILD_ARGUMENTS="-Dmirror-password=$ARTIFACTORY_TOKEN package -DskipTests" \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --volume $PWD/binding/maven-settings:/platform/bindings/maven-settings \
  --builder=paketobuildpacks/builder:0.1.87-base
```

## With both binding AND adoptopenjdk

```shell
pack build demo:0.0.1-SNAPSHOT \
--env BP_MAVEN_BUILD_ARGUMENTS="-Dmirror-password=$ARTIFACTORY_TOKEN package -DskipTests" \
--env SERVICE_BINDING_ROOT=/platform/bindings \
--volume $PWD/binding/maven-settings:/platform/bindings/maven-settings \
--volume $PWD/binding/ca-certificates/:/platform/bindings/my-certificates \
--builder=paketobuildpacks/builder:0.1.87-base \
--buildpack=anthonydahanne/meta-paketo-adoptopenjdk:0.0.2
```

## Directly from maven !

    mvn spring-boot:build-image

## Using Github actions!

See [.github/workflows/main.yml](.github/workflows/main.yml)

## Using waypoint!

    waypoint init
    waypoint up

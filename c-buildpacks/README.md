# Build a maven project with buildpacks

## Simple, no binding

    pack build demo:0.0.1-SNAPSHOT --builder=paketobuildpacks/builder:0.1.181-base

## With ca-certificates binding and Liberica 16

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --env BP_JVM_VERSION=16 \
  --volume $PWD/binding/ca-certificates/:/platform/bindings/my-certificates \
  --builder=paketobuildpacks/builder:base
```


## With settings.xml binding

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env BP_MAVEN_BUILD_ARGUMENTS="-Dmirror-password=$ARTIFACTORY_TOKEN package -DskipTests" \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --volume $PWD/binding/maven-settings:/platform/bindings/maven-settings \
  --builder=paketobuildpacks/builder:0.1.181-base
```

## With both binding AND adoptopenjdk

```shell
pack build demo:0.0.1-SNAPSHOT \
--env BP_MAVEN_BUILD_ARGUMENTS="-Dmirror-password=$ARTIFACTORY_TOKEN package -DskipTests" \
--env SERVICE_BINDING_ROOT=/platform/bindings \
--volume $PWD/binding/maven-settings:/platform/bindings/maven-settings \
--volume $PWD/binding/ca-certificates/:/platform/bindings/my-certificates \
--builder=paketobuildpacks/builder:0.1.181-base \
--buildpack=anthonydahanne/meta-paketo-adoptopenjdk:0.0.2
```

## Rebase image on latest run image

    pack rebase demo:0.0.1-SNAPSHOT

or

    pack rebase demo:0.0.1-SNAPSHOT --run-image gcr.io/paketo-buildpacks/run

## Directly from maven !

    mvn spring-boot:build-image -DskipTests

## Using Github actions!

See [.github/workflows/main.yml](.github/workflows/main.yml)

## Using waypoint!

    waypoint install --platform=kubernetes -accept-tos
    waypoint init
    waypoint up

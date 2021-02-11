# Build a maven project with buildpacks

## Simple, no binding

    pack build demo:0.0.1-SNAPSHOT --builder=paketobuildpacks/builder:base

## With ca-certificates binding

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --volume $PWD/binding/ca-certificates/:/platform/bindings/my-certificates \
  --builder=docker.io/paketobuildpacks/builder:base
```


## With settings.xml binding

```shell
pack build demo:0.0.1-SNAPSHOT \
  --env BP_MAVEN_BUILD_ARGUMENTS="-Dmirror-password=XXX package -DskipTests" \
  --env SERVICE_BINDING_ROOT=/platform/bindings \
  --volume $PWD/binding/maven-settings:/platform/bindings/maven-settings \ 
  --builder=paketobuildpacks/builder:base
```
    


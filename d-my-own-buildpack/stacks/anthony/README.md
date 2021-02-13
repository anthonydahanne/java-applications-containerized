```shell
docker build -t anthonydahanne/stack-base-debian:10 base/ && docker push anthonydahanne/stack-base-debian:10
docker build --build-arg  "stack_id=net.dahanne.anthony" -t anthonydahanne/stack-build-debian:10  build/ && docker push anthonydahanne/stack-build-debian:10
docker build --build-arg  "stack_id=net.dahanne.anthony" -t anthonydahanne/stack-run-debian:10  run/ && docker push anthonydahanne/stack-run-debian:10
```
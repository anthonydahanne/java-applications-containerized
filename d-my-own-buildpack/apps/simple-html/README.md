# How to build

Use the builder named `anthonydahanne/anthony-builder:0.0.2` that is defined in the [builders](../../builders/anthony) folder:

```shell
pack build test  --builder anthonydahanne/anthony-builder:0.0.2
```

And you can see the web page being served on 8080 after running this command:

```shell
docker run -p 8080:8080 -it test
```
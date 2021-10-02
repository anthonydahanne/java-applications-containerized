```shell
pack builder create anthonydahanne/anthony-builder:0.1.0 --config builder.toml --publish 
```

Use it:

```shell
pack build test  --builder anthonydahanne/anthony-builder:0.1.0
```

Inspect it!

```shell
 pack builder inspect anthonydahanne/anthony-builder:0.1.0
```
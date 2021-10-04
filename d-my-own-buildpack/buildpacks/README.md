# Example buildpacks


## Hello anthony

This is a completely useless buildpack since it returns 2 during the detect phase, no matter what you have in your current folder.
It will never build!

```shell
pack  buildpack package  anthonydahanne/anthony-buildpack:0.1.0 --config ./hello-anthony/package.toml  --publish
```

#Hello anthony after

Slightly more useful, since this buildpack returns 0 during the detect phase, and it will build a nice echo command when being used.

```shell
pack  buildpack package  anthonydahanne/anthony-buildpack-after:0.1.0 --config ./hello-anthony-after/package.toml  --publish
```

# Single html page

The most useful buildpack in this folder: if an html page is found, it will build an image with the most page web server to serve this page: using `socat`!

```shell
pack  buildpack package  anthonydahanne/buildpack-simple-web:0.1.0 --config ./single-html-page/package.toml  --publish
```

#Meta Paketo AdoptOpenJDK buildpack

This buildpack demonstrates how you can define a buildpack that will solely rely on other buildpacks !

```shell
pack  buildpack package  anthonydahanne/meta-paketo-adoptopenjdk:0.0.2 --config ./meta-paketo-adoptopenjdk/package.toml  --publish
```

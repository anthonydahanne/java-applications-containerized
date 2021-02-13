# Build your own buildpacks from scratch

While you would usually rest on the shoulders of giant, configuring, or re combining existing buildpacks, let's go through the exercise of creating a (almost) complete buildpack (including a builder, and a stack).

I was greatly inspired by the official [CNCF buildpacks samples repository](https://github.com/buildpacks/samples).

## Stack

You'll need to begin with a [stack](stacks/anthony) : basically some `run` and some `build` image that can share a `base` image.

The important bit ? This label:

    LABEL io.buildpacks.stack.id=net.dahanne.stack.anthony

Once they're built, you can move on to the next step.

## Buildpacks

You could create at the mininum 1 buildpack, but in this example, we have [several buildpacks](buildpacks/) to showcase the ordering.

Each buildpack (except `meta-paketo-adoptopenjdk` that is a meta buildpack composing several others) comes with a `bin` folder and its `detact` and `build` script.

Also, they each come with a `buildpack.toml` and a `package.toml`

Pay attention to the version, name, and also on which `stack` it can run; of course those builpacks can all run on the stack created previously.


## Builder

The `builder` is the piece of metadata that glues the buildpacks and their stack(s) together.

In this example [builder](builders/anthony) we are composing and ordering 3 buildpacks that we created previously and the stack we created previously.

## Try it out !

Finally, let's try this simple builder on a [project](apps/simple-html)!

Among the 3 buildpacks, the [simple-html-page](buildpacks/single-html-page) buildpack can detect an `index.html` page and can build an image with a very trivial webserver to serve it !

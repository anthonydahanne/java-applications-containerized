# Java applications containerized

This repository contains all code samples used during the presentation named "Java applications containerized and deployed".

This repository is divided into 4 sub folders

* [a-dockerfile](a-dockerfile): old school way of building Docker image for a Java project (Spring boot in this case), using simple Dockerfile or multi staged Dockerfile
* [b-jib](b-jib): java native way to build a Docker / OCI image for a Java project (still Spring boot), using the [Jib Maven plugin](https://github.com/GoogleContainerTools/jib)
* [c-buildpacks](c-buildpacks): using [CNCF Buildpacks](https://buildpacks.io) to build a Docker / OCI image for a Java project (still Spring boot) - this method is the focus of this repository
* [d-my-own-buildpack](d-my-own-buildpack): so you want to create your own buildpacks, including your own builder and own stack? This way please!

## Blog posts

For more detail and context, check out those blog posts:

* [https://blog.dahanne.net/2021/02/06/customizing-cloud-native-buildpacks-practical-examples/](https://blog.dahanne.net/2021/02/06/customizing-cloud-native-buildpacks-practical-examples/)

## The talk

* [Slides](https://www.slideshare.net/anthonydahanne/java-applications-containerized-and-deployed)
* [Confoo 2021 page](https://confoo.ca/en/yul2021/session/java-applications-containerized-and-deployed-2021-edition)
* [recording at Global Summit for Java Devs 2021](https://youtu.be/BqipSKH9cdU?t=28416)
* [CNCF Eastern Canada April 2021 recording](https://youtu.be/AnhcT5fOmPc?t=3913)
* [JCon One page](https://sched.co/k3M5)
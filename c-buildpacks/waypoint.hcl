project = "c-buildpacks"

app "c-buildpacks" {
  labels = {
    "service" = "c-buildpacks",
    "env"     = "dev"
  }

  build {
    use "pack" {
      builder = "paketobuildpacks/builder:0.1.181-base"
      disable_entrypoint = true
      static_environment = {
        BP_JVM_VERSION=17
      }
    }
    registry {
      use "docker" {
        image = "anthonydahanne/c-buildpacks"
        tag   = "latest"
        local = false
      }
    }
  }

  deploy {
    use "kubernetes" {
      probe_path = "/actuator/health/liveness"
      service_port = 8080
    }
  }

  release {
    use "kubernetes" {
      port = 8080
      load_balancer = true
    }
  }
}

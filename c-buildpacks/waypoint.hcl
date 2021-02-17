project = "cbuildpacks"

app "cbuildpacks" {
  labels = {
    "service" = "cbuildpacks",
    "env"     = "dev"
  }

  build {
    use "pack" {
      builder = "paketobuildpacks/builder:0.1.64-base"
      disable_entrypoint = true
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

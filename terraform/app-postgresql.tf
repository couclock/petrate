resource "kubernetes_deployment" "postgresql" {
  metadata {
    name = "postgresql"

    labels {
      app = "postgresql"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels {
        app = "postgresql"
      }
    }

    template {
      metadata {
        labels {
          app = "postgresql"
        }
      }

      spec {
        container {
          image = "postgres:11-alpine"
          name  = "postgresql"

          env = [
            {
              name  = "POSTGRES_USER"
              value = "petrate"
            },
            {
              name  = "POSTGRES_PASSWORD"
              value = "petrate"
            },
            {
              name  = "POSTGRES_DB"
              value = "petrate"
            },
          ]

          port = {
            container_port = 5432
            name           = "postgresql"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "postgresql-srv" {
  metadata {
    name = "postgresql"
  }

  spec {
    selector {
      app = "${kubernetes_deployment.postgresql.metadata.0.labels.app}"
    }

    port {
      port = 5432
    }
  }
}

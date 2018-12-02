resource "kubernetes_deployment" "back" {
  metadata {
    name = "back"

    labels {
      app = "back"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels {
        app = "back"
      }
    }

    strategy {
      type = "RollingUpdate"
    }

    template {
      metadata {
        labels {
          app = "back"
        }
      }

      spec {
        container {
          image = "082895264261.dkr.ecr.eu-west-1.amazonaws.com/terraform-eks-demo-back:v1"
          name  = "back"

          port {
            container_port = 8080
            name           = "back"
          }

          readiness_probe {
            initial_delay_seconds = 30

            http_get {
              path = "/actuator/health"
              port = 8080
            }
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "back-srv" {
  metadata {
    name = "back"
  }

  spec {
    selector {
      app = "${kubernetes_deployment.back.metadata.0.labels.app}"
    }

    port {
      port = 8080
    }
  }
}

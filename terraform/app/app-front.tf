resource "kubernetes_deployment" "front" {
  metadata {
    name = "front"

    labels {
      app = "front"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels {
        app = "front"
      }
    }

    strategy {
      type = "RollingUpdate"
    }

    template {
      metadata {
        labels {
          app = "front"
        }
      }

      spec {
        container {
          image = "082895264261.dkr.ecr.eu-west-1.amazonaws.com/terraform-eks-demo-front:v1"
          name  = "front"

          port = {
            container_port = 80
            name           = "front"
          }

          readiness_probe {
            initial_delay_seconds = 10

            http_get {
              path = "/"
              port = 80
            }
          }

          liveness_probe {
            http_get {
              path = "/"
              port = 80
            }
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "front-srv" {
  metadata {
    name = "front"
  }

  spec {
    selector {
      app = "${kubernetes_deployment.front.metadata.0.labels.app}"
    }

    port {
      port = 80
    }

    type = "LoadBalancer"
  }
}

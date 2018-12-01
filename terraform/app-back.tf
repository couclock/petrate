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

          port = {
            container_port = 8080
            name           = "back"
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

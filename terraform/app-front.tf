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

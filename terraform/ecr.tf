resource "aws_ecr_repository" "front" {
  name = "${var.cluster-name}-front"
}

resource "aws_ecr_repository" "back" {
  name = "${var.cluster-name}-back"
}

resource "aws_ecr_repository" "bd" {
  name = "${var.cluster-name}-bd"
}

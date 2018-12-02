# Add a file secret.tf containing with valid access_key
# Go AWS console > IAM > Users > Pick a user > Security credentials > Create access key
# to get one valid
#provider "aws" {
#  access_key = "AKIAJYB7CZUWZJOATOQQ"
#  secret_key = "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"
#  region     = "eu-west-1"
#}

variable "cluster-name" {
  default = "terraform-eks-demo"
  type    = "string"
}

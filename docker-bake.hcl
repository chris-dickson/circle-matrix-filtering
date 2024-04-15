target "_platforms" {
  platforms = ["linux/amd64", "linux/arm64"]
}

variable "TAG" {
  default = "latest"
}

group "default" {
  targets = ["server", "proxy"]
}

target "server" {
  inherits = ["_platforms"]
  context = "server"
  tags = ["ghcr.io/chris-dickson/circle-test-server:${TAG}"]
}

target "proxy" {
  inherits = ["_platforms"]
  context = "proxy"
  tags = ["ghcr.io/chris-dickson/circle-test-proxy:${TAG}"]
}

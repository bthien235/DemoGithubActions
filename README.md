# DemoGithubActions

Spring Boot demo project with GitHub Actions configured to:

- build the Docker image from `Dockerfile`
- push the image to Docker Hub as `DOCKERHUB_USERNAME/demogithubaction`

Required GitHub repository secrets:

- `DOCKERHUB_USERNAME`
- `DOCKERHUB_TOKEN`

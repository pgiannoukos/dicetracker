pipeline {
    agent any
    stages {
        stage('run') {
            steps {
                // sh "docker build -t dicetracker_build -f DockerfileBuild ."
                // sh 'docker run --volume "$(pwd):/app" dicetracker_build'
                // sh "docker kill dicetracker_run || true"
                // sh "docker rm dicetracker_run || true"
                // sh "docker build -t dicetracker_run:latest -f DockerfileRun ."
                // sh "docker login -upgiannoukos -pPackardg1!"
                // sh "docker image tag dicetracker_run pgiannoukos/dicetracker_run:latest"
                // sh "docker image push pgiannoukos/dicetracker_run:latest"
                // sh "docker run -d --name dicetracker_run  -p 80:8080 pgiannoukos/dicetracker_run:latest"
                sh 'docker run -v "$(pwd):/app" -w "/app" maven:3.8.3-openjdk-17 mvn clean test install'
                sh "docker kill dicetracker || true"
                sh "docker rm dicetracker || true"
                sh "docker build -t dicetracker:latest ."
                sh "docker login -upgiannoukos -pPackardg1!"
                sh "docker image tag dicetracker pgiannoukos/dicetracker:latest"
                sh "docker image push pgiannoukos/dicetracker:latest"
                sh "docker network create dicetracker-network || true"
                sh "docker run --name dicetracker --network dicetracker-network -p 80:8080 pgiannoukos/dicetracker:latest "
            }
        }
    }
}
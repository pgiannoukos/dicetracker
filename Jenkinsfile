pipeline {
    agent any
    stages {
        stage('build app') {
            steps {
                sh 'docker run -v "$(pwd):/app" -w "/app" maven:3.8.3-openjdk-17 mvn clean test install'
            }
        }
        stage('build docker image') {
            steps {
                sh "docker kill dicetracker || true"
                sh "docker rm dicetracker || true"
                sh "docker build -t dicetracker:latest ."
                sh "docker login -upgiannoukos -pPackardg1!"
                sh "docker image tag dicetracker pgiannoukos/dicetracker:latest"
                sh "docker image push pgiannoukos/dicetracker:latest"
                sh "docker network create dicetracker-network || true"
            }
        }
        stage('run docker app') {
            steps {
                sh "docker run -d --restart always --name dicetracker --network dicetracker-network -p 80:8080 pgiannoukos/dicetracker:latest "
            }
        }
    }
}
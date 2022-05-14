pipeline {
    agent any
    // agent {
    //     label "main"
    // }
    stages {
        stage('test') {
            steps {
                sh "docker build -t dicetracker_build -f DockerfileBuild ."
                sh 'docker run --volume "$(pwd):/app" dicetracker_build'
                sh "docker kill dicetracker_run || true"
                sh "docker rm dicetracker_run || true"
                sh "docker build -t dicetracker_run:latest -f DockerfileRun ."
                sh "docker login -upgiannoukos -pPackardg1!"
                sh "docker image tag dicetracker_run pgiannoukos/dicetracker_run:latest"
                sh "docker image push pgiannoukos/dicetracker_run:latest"
                sh "docker run -d --name dicetracker_run  -p 80:8080 dicetracker_run:latest"
            }
        }
    }
}
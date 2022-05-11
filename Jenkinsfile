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
                sh "docker run --name dicetracker_run -p 80:8080 -D dicetracker_run:latest"
            }
        }
    }
}
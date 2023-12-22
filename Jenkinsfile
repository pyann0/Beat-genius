pipeline {
    agent any

    tools {
        maven "Maven 3.9.6"
    }

    stages {
        stage('Hello') {
            steps {
                script {
                    echo 'Hello World !'
                }
            }
        }

        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build('beatgeniusproject:latest')
                    bat "docker image prune -f"
               }
            }
        }

        stage('Start Docker Container') {
            steps {
                script {
                    try {
                        bat "docker stop beatgeniusproject"
                        bat "docker rm beatgeniusproject"
                    } catch (Exception e) {
                       echo '404 Not Found : beatgeniusproject'
                    }
                    bat "docker run --name beatgeniusproject -d -p 9075:8080 beatgeniusproject:latest Beat-genius.jar"
                }
            }
        }
    }
}

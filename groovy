pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/Sbsankar/jenkins.git'  // Your GitHub repo
        IMAGE_NAME = 'sbsankar-hello-world'  // Unique Docker image name
    }

    stages {
        stage('Clone Repository') {
            steps {
                git REPO_URL
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME} ."
                }
            }
        }
        stage('Run Container') {
            steps {
                script {
                    sh "docker run --rm ${IMAGE_NAME}"
                }
            }
        }
    }
}

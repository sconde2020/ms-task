pipeline {
    agent any

    tools {
        jdk 'openjdk-21.0.7' // Doit être installé dans Jenkins (Manage Jenkins > Tools)
        maven 'maven-3.8.7' // Idem
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}

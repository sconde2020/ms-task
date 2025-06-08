pipeline {
    agent any

    tools {
        jdk 'openjdk-21.0.7' // Doit être installé dans Jenkins (Manage Jenkins > Global Tool Configuration)
        maven 'maven-3.8.7' // Idem
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/sconde2020/ms-task.git', branch: 'master'
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

pipeline {
    agent any

    tools {
        maven 'Maven 3.8.8'     // Jenkins me ye maven install hona chahiye
        jdk 'jdk11'             // Jenkins me JDK 11 configure hona chahiye
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Aryan-QA/myproject.git'
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

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'screenshots/*.png', fingerprint: true
        }
    }
}

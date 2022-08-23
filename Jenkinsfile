pipeline {
    agent any
    tools {
          maven 'maven-3.8.4'
    }
    options {
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
        timestamps()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                echo 'Build stage...'
            }
        }
        stage('Test') {
            steps {
                // sh 'mvn test'
                echo 'Test stage...'
            }
//             post {
//                 always {
//                     junit 'target/surefire-reports/*.xml'
//                 }
//             }
        }
    }
}
pipeline {
    agent any
    tools {
          maven 'MAVEN_HOME'
          jdk 'JAVA_HOME'
    }
    options {
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
        timestamps()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
                echo 'Build stage...'
            }
        }
        stage('Test') {
            steps {
                // sh 'mvn test'
                echo 'Test stage...'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
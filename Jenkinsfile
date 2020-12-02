pipeline {
    agent {
        label 'agent'
    }
    stages {
        stage('Run Test') {
            steps {
            withMaven(maven :'maven-3.6.3')
                script {
                    sh 'mvn clean test'
                }
            }
        }
    }

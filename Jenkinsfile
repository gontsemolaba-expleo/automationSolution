pipeline {
    agent {
        label 'agent'
    }
    stages {
        stage("Run Test") {
            steps {
                script {
                    sh "mvn clean test"
                }
            }
        }
    }
}
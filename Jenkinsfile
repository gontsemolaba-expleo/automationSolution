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
    post {
            always {
                junit 'build/reports/**/*.xml'
            }
        }
    }
}
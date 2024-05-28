pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Generate Javadoc') {
            steps {
                sh 'mvn javadoc:jar -Dmaven.javadoc.failOnError=false'
            }
        }

        stage('K8s') {
            steps {
            sh 'kubectl set image deployments/hello-node docs=cswccc/teedy_local:latest'
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', fingerprint: true
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
        }
    }
}

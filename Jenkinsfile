pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('K8s') {
            steps {
            sh 'kubectl set image deployment/teedy docs=sismics/docs:latest'
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

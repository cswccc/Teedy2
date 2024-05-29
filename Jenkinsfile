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
                withCredentials([file(credentialsId: 'eb640752-6d83-41fb-a6b4-f291c7963a4d', variable: 'KUBECONFIG')]) {
                    sh 'kubectl --kubeconfig=$KUBECONFIG set image deployments/hello-node docs=sismics/docs:latest'
                }
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
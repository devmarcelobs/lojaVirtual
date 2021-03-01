pipeline{
    agent any

    stages{
        stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '/*main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'jenkins-user-github', url: 'https://github.com/marcelim122/lojaVirtual.git']]])
                sh "ls -lart ./*"
                sh './mvnw clean -f lojaVirtual'
            }
        }
        stage('Build'){
            steps{
                sh './mvnw install -f lojaVirtual'
            }
        }
    }  
}
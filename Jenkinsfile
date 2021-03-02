pipeline{
    agent any

    stages{
        /*stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '/*main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'jenkins-user-github', url: 'https://github.com/marcelim122/lojaVirtual.git']]])
            }
        }*/
        stage("Clone Code"){
            steps{
                git url: 'https://github.com/marcelim122/lojaVirtual.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean install'
            }
        }
    }
}
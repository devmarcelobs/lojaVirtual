node{
    //agent any

    /*stages{
        stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '/*main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'jenkins-user-github', url: 'https://github.com/marcelim122/lojaVirtual.git']]])
            }
        }
    }*/
    stages{
        stage('Build'){
            git url: 'https://github.com/marcelim122/lojaVirtual.git'
            withMaven{
                sh "mvn clean verify"
            }
        }
    }  
}
pipeline{
    agent any

    tools{
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }

    stages{
        stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '/*main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'jenkins-user-github', url: 'https://github.com/marcelim122/lojaVirtual.git']]])
            }
        }
        stage('Initialize'){
            steps{
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build'){
            steps{
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post{
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }  
}
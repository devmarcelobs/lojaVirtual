pipeline{
    agent any

    stages{
        stage('Build'){
            steps{
                git 'https://github.com/marcelim122/lojaVirtual.git'
                sh './mvn clean compile'
            }
        }
    }
    stage('Test'){
        steps{
            sh './mvnw test'
        }
        post{
            junit '**/src/test/com/mockito/AdmControllerMockito.java'
        }
    }
}
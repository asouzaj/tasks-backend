pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment scannerHome = tool 'SONAR_SCANNER'
            steps {
                withSonarQubeEnv(SONAR_LOCAL) {
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=169272e62d13e9404d83db97825fdd61381ec682 -Dsonar.java.binaries=target -Dsonar.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
                
            }
        }
    }
}


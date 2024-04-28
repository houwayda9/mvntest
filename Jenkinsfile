pipeline {
 
   
 

 
    agent any

    stages {






stage('ARTIFACT CONSTRUCTION') {
            steps {
                echo 'Constructing artifact'
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }


stage ('MVN COMPILE') {
    steps {
        sh 'mvn compile'
    }
}
stage ('MVN test') {
    steps {
        sh 'mvn test'
    }
}




stage ('MVN SONAR') {
    steps {
        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=hou99'
    }
}

stage ('MVN DEPLOY TO NEXUS') {
            steps {
                nexusArtifactUploader(
        nexusVersion: 'nexus3',
        protocol: 'http',
        nexusUrl: 'localhost:8081',
        groupId: 'pom.tn.esprit.spring',
        version: 'pom.4.0.0',
        repository: 'maven-nexus-repo',
        credentialsId: 'NEXUS_CRED',
        artifacts: [
            [artifactId: 'pom.gestion-station-ski',
             classifier: '',
             file: "pom.xml" ,
             type: "pom"]
        ]
     )
            }
        }




stage('Docker Compose') {
            steps {
                script {
                    // Run Docker Compose
                    sh 'docker-compose up -d --build'
                    def gitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                    def imageName = "houwayda/devops_esprit:$gitHash"
                    sh "docker tag houwayda/devops_esprit:latest $imageName"
                    docker.withRegistry('', 'registryCredential') {
                        sh " docker push houwayda/devops_esprit"
                   
                }
                
                
                }
            }
        }

}}

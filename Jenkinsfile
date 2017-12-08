node {
   
   env.PATH = "${tool 'M3'}/bin:${env.PATH}"
   
   stage('Checkout') {
      git 'https://github.com/andersonlfeitosa/maven-release-plugin-demo.git'
   }
   stage('Clean') {
      sh "mvn clean"
   }
   stage('Build') {
      sh "mvn install -DskipTest"
   }
   stage('Unit Tests') {
      sh "mvn test"
      junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Sonar') {
      sh "mvn sonar:sonar"
   }
   stage('Archive') {
      sh "mvn deploy -DskipTest"
   }
   stage('Docker') {
      sh "mvn package docker:build docker:push"
   }


}
node {
   
   env.PATH = "${tool 'M3'}/bin:${env.PATH}"
   
   stage('Checkout') {
      git 'https://github.com/andersonlfeitosa/poc-jenkins-buildpipeline.git'
   }
   stage('Clean') {
      sh "mvn clean"
   }
   stage('Build') {
      sh "mvn install -DskipTest"
   }
   stage('Unit Tests') {
      sh "mvn test"
      //junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Sonar') {
      sh "mvn sonar:sonar -Dsonar.host.url=http://192.168.99.100:9000 -Dsonar.jdbc.url=\"jdbc:h2:tcp://192.168.99.100/sonar\""
   }
   stage('Archive') {
      sh "mvn deploy -DskipTest"
   }
   stage('Docker') {
      sh "mvn package docker:build docker:push"
   }


}
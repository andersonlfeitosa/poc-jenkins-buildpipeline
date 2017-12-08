node {
   
   env.PATH = "${tool 'M3'}/bin:${env.PATH}"
   
   stage('Checkout') {
      git 'https://github.com/andersonlfeitosa/poc-jenkins-buildpipeline.git'
   }
   stage('Clean') {
      sh "mvn clean"
   }
   stage('Build') {
      sh "mvn install -DskipTests -s $JENKINS_HOME/settings.xml"
   }
   stage('Unit Tests') {
      sh "mvn test"
      //junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Sonar') {
      sh "mvn sonar:sonar -s $JENKINS_HOME/settings.xml"
   }
   stage('Archive') {
      sh "mvn deploy -DskipTest -s $JENKINS_HOME/settings.xml"
   }
   stage('Docker') {
      sh "mvn package docker:build docker:push"
   }


}
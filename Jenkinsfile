node {
   
   env.PATH = "${tool 'M3'}/bin:${env.PATH}"
   //String mvn = "mvn -s $JENKINS_HOME/settings.xml"
   
   // adds job parameters within jenkinsfile
//   properties([
//      parameters([
//       booleanParam(
//          defaultValue: false,
//          description: 'Is a release version?',
//          name: 'isRelease'
//       ),
//       string(
//          defaultValue: "1.0.0-SNAPSHOT",
//          description: 'Number of version',
//          name: 'version'
//       ),
//       string(
//          defaultValue: "2.0.0-SNAPSHOT",
//          description: 'Next number of version',
//          name: 'nextVersion'
//       ),
//      ])
//   ])
   
   stage('Checkout') {
      git 'https://github.com/andersonlfeitosa/poc-jenkins-buildpipeline.git'
   }
   stage('Clean') {
       bat "mvn clean"
   }
   stage('Build') {
       bat "mvn install -DskipTests"
   }
   stage('Unit Tests') {
       bat "mvn test"
   }
   stage('Sonar') {
        withSonarQubeEnv('Sonar') {
            bat "mvn clean install sonar:sonar"
        }
   }
   stage('Quality Gate') {
        timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
   }
   stage('Archive') {
      bat "mvn deploy -DskipTest"
   }
   stage('Docker') {
      bat "dir"
      //sh "mvn package docker:build docker:push"
   }


}
node {
   
   env.PATH = "${tool 'M3'}/bin:${env.PATH}"
   String mvn = "mvn -s $JENKINS_HOME/settings.xml"
   
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
//   stage('Clean') {
//       sh "${mvn} clean"
//   }
//   stage('Build') {
//       sh "${mvn} install -DskipTests"
//   }
//   stage('Unit Tests') {
//       sh "${mvn} test"
//   }
   stage('Sonar') {
        withSonarQubeEnv('Sonar') {
            sh "${mvn} sonar:sonar"
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
      sh "${mvn} deploy -DskipTest"
   }
   stage('Docker') {
      sh "ls -la"
      //sh "mvn package docker:build docker:push"
   }


}
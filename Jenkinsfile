node {

  env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
  env.PATH = "${tool 'jdk1.8'}/bin:${env.PATH}"
  env.DOCKER_TLS_VERIFY="1"
  env.DOCKER_HOST="tcp://192.168.99.100:2376"
  env.DOCKER_CERT_PATH="/Users/anderson/.docker/machine/machines/default"
  env.DOCKER_MACHINE_NAME="default"
  env.JAVA_HOME = "${tool 'jdk1.8'}"

  stage('Checkout') {
    git 'https://github.com/andersonlfeitosa/poc-jenkins-buildpipeline.git'
  }
  stage('Clean') {
     sh "mvn clean"
  }
  stage('Build') {
     sh "mvn install -DskipTests"
  }
  stage('Unit Tests') {
     sh "mvn test"
  }
  stage('Archive') {
    sh "mvn deploy -DskipTest"
  }
  stage('Sonar') {
    withSonarQubeEnv('Sonar') {
      sh "mvn sonar:sonar"
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
  stage('Docker') {
    //sh "mvn package docker:build docker:push"
  }
}

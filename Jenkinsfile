node {
  stage('SCM Checkout') {
   git 'https://github.com/hamzus1992/projectfullstack'
  }
  stage('Compile-Checkout') {
   def mvn = tool (name: 'maven3', type: 'maven') + '/bin/mvn'
    dir('/restwebservices') {
     sh "${mvn}/bin/mvn package"
}
   
  }
}

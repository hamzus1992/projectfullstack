node {
  stage('SCM Checkout') {
   git 'https://github.com/hamzus1992/projectfullstack'
  }
  stage('Compile-Checkout') {
   def mvnHome = tool name: '', type: 'maven'
    dir('/restwebservices') {
     sh "${mvnHome}/bin/mvn package"
}
   
  }
}

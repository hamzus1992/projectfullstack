node {
  stage('SCM Checkout') {
   git 'https://github.com/hamzus1992/projectfullstack'
  }
  stage('Compile-Checkout') {
   def mvn = tool name: 'M3', type: 'maven'
    dir('/restwebservices') {
     sh "${mvn}/bin/mvn package"
}
   
  }
}

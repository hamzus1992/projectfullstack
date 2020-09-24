node {
  stage('SCM Checkout') {
   git 'https://github.com/hamzus1992/projectfullstack'
  }
  stage('Compile-Checkout') {
   def mvn = tool name: '', type: 'maven'
    dir('/restwebservices') {
     sh "${mvn}/bin/mvn package"
}
   
  }
}

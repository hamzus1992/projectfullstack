node {
  stage('SCM Checkout') {
   git 'https://github.com/hamzus1992/projectfullstack'
  }
  stage('Compile-Checkout') {
   def mvnHome = tool name: '', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}
